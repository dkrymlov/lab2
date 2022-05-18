package com.krymlov.lab1.model;

import com.krymlov.lab1.entity.DayEntity;
import com.krymlov.lab1.entity.GroupEntity;
import com.krymlov.lab1.entity.LessonEntity;
import com.krymlov.lab1.entity.TeatcherEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Timetable {

    @Min(1)
    private Long id;

    @Min(1)
    @Max(999)
    private int room;

    @Min(1)
    @Max(5)
    private int para;

    @Min(1)
    private GroupEntity group;

    @Min(1)
    private LessonEntity lesson;

    @Min(1)
    private TeatcherEntity teatcher;

    @Min(1)
    private DayEntity day;

    public Timetable(@Min(1) Long id, @Min(1) @Max(999) int room, @Min(1) @Max(5) int para, @Min(1) GroupEntity group, @Min(1) LessonEntity lesson, @Min(1) TeatcherEntity teatcher, @Min(1) DayEntity day) {
        this.id = id;
        this.room = room;
        this.para = para;
        this.group = group;
        this.lesson = lesson;
        this.teatcher = teatcher;
        this.day = day;
    }

    public Timetable(@Min(1) @Max(999) int room, @Min(1) @Max(5) int para, @Min(1) GroupEntity group, @Min(1) LessonEntity lesson, @Min(1) TeatcherEntity teatcher, @Min(1) DayEntity day) {
        this.room = room;
        this.para = para;
        this.group = group;
        this.lesson = lesson;
        this.teatcher = teatcher;
        this.day = day;
    }

    public Timetable(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public LessonEntity getLesson() {
        return lesson;
    }

    public void setLesson(LessonEntity lesson) {
        this.lesson = lesson;
    }

    public TeatcherEntity getTeatcher() {
        return teatcher;
    }

    public void setTeatcher(TeatcherEntity teatcher) {
        this.teatcher = teatcher;
    }

    public DayEntity getDay() {
        return day;
    }

    public void setDay(DayEntity day) {
        this.day = day;
    }
}
