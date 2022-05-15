package com.krymlov.lab2.entity;

import com.krymlov.lab2.model.Lesson;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class LessonEntity extends Lesson {

    public LessonEntity() {
        super();
    }

    public LessonEntity(@Min(1) Long id, @NotNull @NotEmpty String name, @NotNull @NotEmpty String control, @NotNull @NotEmpty @Min(20) @Max(50) @Range(min = 20, max = 50) Integer hours, TypeEntity type) {
        super(id, name, control, hours, type);
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

    @Column(length = 50, nullable = false)
    @Override
    public String getControl() {
        return super.getControl();
    }

    @Override
    public void setControl(String control) {
        super.setControl(control);
    }

    @Column(nullable = false)
    @Override
    public Integer getHours() {
        return super.getHours();
    }

    @Override
    public void setHours(Integer hours) {
        super.setHours(hours);
    }

    @ManyToOne
    @Override
    public TypeEntity getType() {
        return super.getType();
    }

    @Override
    public void setType(TypeEntity type) {
        super.setType(type);
    }
}
