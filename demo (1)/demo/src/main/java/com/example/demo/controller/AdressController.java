package com.example.demo.controller;

import com.example.demo.dto.person.PersonResponse;
import com.example.demo.dto.person.adress.AdressRequest;
import com.example.demo.dto.person.adress.AdressResponse;
import com.example.demo.repositories.AdressRepository;
import com.example.demo.service.AdressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/adress")
public class AdressController {
    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private AdressService adressService;

    @GetMapping("/adress/{id}")
    public AdressResponse getById(@PathVariable Long id) {
        return adressService.getById(id);
    }

    @PostMapping("/addAdress")
    public void addAdress(@RequestBody AdressRequest adressRequest) {
        adressService.addAdress(adressRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        adressService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody AdressRequest adressRequest) {
        adressService.updateById(id,adressRequest);
    }
}
