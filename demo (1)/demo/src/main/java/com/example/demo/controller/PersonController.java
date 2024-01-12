package com.example.demo.controller;

import com.example.demo.dto.person.PersonRequest;
import com.example.demo.dto.person.PersonResponse;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.service.PersonService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/person/{id}")
    public PersonResponse getById(@PathVariable Long id) {
        return personService.getById(id);
    }

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody PersonRequest personRequest) {
        personService.addPerson(personRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        personService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody PersonRequest personRequest) {
        personService.updateById(id,personRequest);
    }
}
