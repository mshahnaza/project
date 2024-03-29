package com.example.films_online.dto.type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeResponse {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
