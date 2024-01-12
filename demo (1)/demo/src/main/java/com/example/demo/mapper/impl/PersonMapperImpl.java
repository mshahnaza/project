package com.example.demo.mapper.impl;

import com.example.demo.dto.person.PersonResponse;
import com.example.demo.entites.Person;
import com.example.demo.mapper.PersonMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonMapperImpl implements PersonMapper {
    @Override
    public PersonResponse toDto(Person person) {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(person.getId());
        personResponse.setFirst_name(person.getFirst_name());
        personResponse.setLast_name(person.getLast_name());

        return personResponse;
    }
}