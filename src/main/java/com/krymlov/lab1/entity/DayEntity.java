package com.krymlov.lab1.entity;

import com.krymlov.lab1.model.Day;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class DayEntity extends Day {

    public DayEntity() {
        super();
    }

    public DayEntity(@Min(1) Long id, @NotEmpty @NotNull String name) {
        super(id, name);
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
