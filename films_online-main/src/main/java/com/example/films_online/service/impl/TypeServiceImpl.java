package com.example.films_online.service.impl;

import com.example.films_online.dto.type.TypeResponse;
import com.example.films_online.entities.Type;
import com.example.films_online.exception.NotFoundException;
import com.example.films_online.mapper.TypeMapper;
import com.example.films_online.repositories.TypeRepository;
import com.example.films_online.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public void addType(String name, String token) {
        if (typeRepository.findByName(name).isPresent())
            throw new NotFoundException("Type with name: "+name+" is already exist!", HttpStatus.BAD_REQUEST);
        Type type = new Type();
        type.setName(name);
        typeRepository.save(type);
    }

    @Override
    public List<TypeResponse> getAll() {
        return typeMapper.toDtoS(typeRepository.findAll());
    }
}
