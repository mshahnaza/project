package com.example.demo.service.impl;

import com.example.demo.dto.person.PersonRequest;
import com.example.demo.dto.person.PersonResponse;
import com.example.demo.entites.Person;
import com.example.demo.exception.NotFoundException;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @Override
    public PersonResponse getById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isEmpty()){
            System.out.println("person is empty!");

        }
        return personMapper.toDto(person.get());
    }

    @Override
    public void addPerson(PersonRequest personRequest) {
        Person person = new Person();
        System.out.println(personRequest.getFirst_name());
        System.out.println(personRequest.getLast_name());

        person.setFirst_name(personRequest.getFirst_name());
        person.setLast_name(personRequest.getLast_name());

        personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        if (personRepository.findById(id).isEmpty())
            throw new NotFoundException("the product with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        personRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, PersonRequest personRequest) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty())
            throw new NotFoundException("the person with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        person.get().setFirst_name(personRequest.getFirst_name());
        person.get().setLast_name(personRequest.getLast_name());
    }
}
