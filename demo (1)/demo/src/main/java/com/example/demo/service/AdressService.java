package com.example.demo.service;

import com.example.demo.dto.person.adress.AdressRequest;
import com.example.demo.dto.person.adress.AdressResponse;

public interface AdressService {
    AdressResponse getById(Long id);

    void addAdress(AdressRequest adressRequest);

    void deleteById(Long id);

    void updateById(Long id, AdressRequest adressRequest);
}
