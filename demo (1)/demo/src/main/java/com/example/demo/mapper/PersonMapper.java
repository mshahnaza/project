package com.example.demo.mapper;

import com.example.demo.dto.person.PersonResponse;
import com.example.demo.entites.Person;

import java.util.Optional;

public interface PersonMapper {
    PersonResponse toDto(Person person);
}