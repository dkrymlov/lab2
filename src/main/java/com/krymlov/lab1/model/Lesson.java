package com.krymlov.lab1.model;


import com.krymlov.lab1.entity.TypeEntity;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Lesson {

    @Min(1)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String control;
    @NotNull
    @NotEmpty
    @Min(20)
    @Max(50)
    @Range(min = 20, max = 50)
    private Integer hours;

    @NotEmpty
    @NotNull
    private TypeEntity type;

    public Lesson(){}

    public Lesson(@NotNull @NotEmpty String name, @NotNull @NotEmpty String control, @NotNull @NotEmpty @Min(20) @Max(50) @Range(min = 20, max = 50) Integer hours, TypeEntity type) {
        this.id = id;
        this.name = name;
        this.control = control;
        this.hours = hours;
        this.type = type;
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

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }
}
