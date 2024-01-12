package com.example.demo.entites;

import jakarta.persistence.*;

@Entity
public class Adress {
    @Id
    @GeneratedValue
    private Long id;
    private String city;

    private String street;

    private Integer house_number;

    @ManyToOne()
    Person owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse_number() {
        return house_number;
    }

    public void setHouse_number(Integer house_number) {
        this.house_number = house_number;
    }
}
