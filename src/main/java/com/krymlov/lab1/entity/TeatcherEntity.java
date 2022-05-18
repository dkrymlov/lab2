package com.krymlov.lab1.entity;

import com.krymlov.lab1.model.Teatcher;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class TeatcherEntity extends Teatcher {

    public TeatcherEntity() {
        super();
    }

    public TeatcherEntity(@NotNull @NotEmpty String name, @NotNull @NotEmpty @Range(min = 6, max = 6) @Min(100000) @Max(999999) int phone, @NotNull @NotEmpty String degree) {
        super(name, phone, degree);
    }

    public TeatcherEntity(Long id, @NotNull @NotEmpty String name, @NotNull @NotEmpty @Range(min = 6, max = 6) @Min(100000) @Max(999999) int phone, @NotNull @NotEmpty String degree) {
        super(id, name, phone, degree);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(length = 50, nullable = false)
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Column(nullable = false)
    @Override
    public int getPhone() {
        return super.getPhone();
    }

    @Override
    public void setPhone(int phone) {
        super.setPhone(phone);
    }

    @Column(nullable = false, length = 50)
    @Override
    public String getDegree() {
        return super.getDegree();
    }

    @Override
    public void setDegree(String degree) {
        super.setDegree(degree);
    }
}
