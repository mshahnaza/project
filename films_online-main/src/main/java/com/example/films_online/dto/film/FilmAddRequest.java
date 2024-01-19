package com.example.films_online.dto.film;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmAddRequest {
    private String name;
    private String transcript;
    private Integer age_access;
    private Integer price;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public Integer getAge_access() {
        return age_access;
    }

    public void setAge_access(Integer age_access) {
        this.age_access = age_access;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
