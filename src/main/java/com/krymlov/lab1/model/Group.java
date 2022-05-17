package com.krymlov.lab1.model;


import com.krymlov.lab1.entity.FacultyEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Group {

    @Min(1)
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @Min(1)
    @Max(6)
    private int course;

    @Min(1)
    private FacultyEntity faculty;

    @NotNull
    @NotEmpty
    @Min(1)
    @Max(40)
    private int students;

    public Group(){}

    public Group(@Min(1) Long id, @NotNull @NotEmpty String name, @Min(1) @Max(6) int course, FacultyEntity faculty, @NotNull @NotEmpty @Min(1) @Max(40) int students) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.faculty = faculty;
        this.students = students;
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

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public FacultyEntity getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyEntity faculty) {
        this.faculty = faculty;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }
}


