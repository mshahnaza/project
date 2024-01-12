package com.example.demo.service;

import com.example.demo.dto.person.PersonRequest;
import com.example.demo.dto.person.PersonResponse;

public interface PersonService {
    PersonResponse getById(Long id);

    void addPerson(PersonRequest personRequest);

    void deleteById(Long id);

    void updateById(Long id, PersonRequest personRequest);
}
