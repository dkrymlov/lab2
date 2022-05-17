package com.krymlov.lab1.entity;

import com.krymlov.lab1.model.Group;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class GroupEntity extends Group {
    public GroupEntity() {
        super();
    }

    public GroupEntity(@Min(1) Long id, @NotNull @NotEmpty String name, @Min(1) @Max(6) int course, FacultyEntity faculty, @NotNull @NotEmpty @Min(1) @Max(40) int students) {
        super(id, name, course, faculty, students);
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
    public int getCourse() {
        return super.getCourse();
    }

    @Override
    public void setCourse(int course) {
        super.setCourse(course);
    }

    @ManyToOne
    @Override
    public FacultyEntity getFaculty() {
        return super.getFaculty();
    }

    @Override
    public void setFaculty(FacultyEntity faculty) {
        super.setFaculty(faculty);
    }

    @Column(nullable = false)
    @Override
    public int getStudents() {
        return super.getStudents();
    }

    @Override
    public void setStudents(int students) {
        super.setStudents(students);
    }
}
