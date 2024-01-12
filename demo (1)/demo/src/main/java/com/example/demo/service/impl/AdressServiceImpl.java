package com.example.demo.service.impl;

import com.example.demo.dto.person.adress.AdressRequest;
import com.example.demo.dto.person.adress.AdressResponse;
import com.example.demo.entites.Adress;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repositories.AdressRepository;
import com.example.demo.service.AdressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdressServiceImpl implements AdressService {
    @Autowired
    private AdressRepository adressRepository;

    @Override
    public AdressResponse getById(Long id) {
        Optional<Adress> adress = adressRepository.findById(id);
        if(adress.isEmpty()){
            System.out.println("adress is empty!");

        }
        else{
            AdressResponse adressResponse = new AdressResponse();
            adressResponse.setId(adress.get().getId());
            adressResponse.setCity(adress.get().getCity());
            adressResponse.setStreet(adress.get().getStreet());
            adressResponse.setHouse_number(adress.get().getHouse_number());

            return adressResponse;
        }
        return null;
    }

    @Override
    public void addAdress(AdressRequest adressRequest) {
        Adress adress = new Adress();

        adress.setCity(adressRequest.getCity());
        adress.setStreet(adressRequest.getStreet());
        adress.setHouse_number(adressRequest.getHouse_number());

        adressRepository.save(adress);
    }

    @Override
    public void deleteById(Long id) {
        if (adressRepository.findById(id).isEmpty())
            throw new NotFoundException("the adress with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        adressRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, AdressRequest adressRequest) {
        Optional<Adress> adress = adressRepository.findById(id);
        if (adress.isEmpty())
            throw new NotFoundException("the adress with id: "+id+" is empty!", HttpStatus.BAD_REQUEST);
        adress.get().setCity(adressRequest.getCity());
        adress.get().setStreet(adressRequest.getStreet());
        adress.get().setHouse_number(adressRequest.getHouse_number());
    }
}
