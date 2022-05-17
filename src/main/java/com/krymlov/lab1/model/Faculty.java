package com.krymlov.lab1.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Faculty {

    @Min(1)
    private Long id;

    @NotEmpty
    @NotNull
    private String name;

    public Faculty(){}

    public Faculty(@Min(1) Long id, @NotEmpty @NotNull String name) {
        this.id = id;
        this.name = name;
    }

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
