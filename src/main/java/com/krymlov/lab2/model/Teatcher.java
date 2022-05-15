package com.krymlov.lab2.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Teatcher {

    @Min(1)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    @Range(min = 6, max = 6)
    @Min(100000)
    @Max(999999)
    private int phone;

    @NotNull
    @NotEmpty
    private String degree;

    public Teatcher(){}

    public Teatcher(@Min(1) Long id, @NotNull @NotEmpty String name, @NotNull @NotEmpty @Range(min = 6, max = 6) @Min(100000) @Max(999999) int phone, @NotNull @NotEmpty String degree) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.degree = degree;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
}
