package com.krymlov.lab1.entity;

import com.krymlov.lab1.model.Faculty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class FacultyEntity extends Faculty {

    public FacultyEntity() {
        super();
    }

    public FacultyEntity(@NotEmpty @NotNull String name) {
        super(name);
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
}
