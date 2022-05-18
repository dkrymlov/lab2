package com.krymlov.lab1.entity;

import com.krymlov.lab1.model.Timetable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class TimetableEntity extends Timetable {

    public TimetableEntity(@Min(1) Long id, @Min(1) @Max(999) int room, @Min(1) @Max(5) int para, @Min(1) GroupEntity group, @Min(1)LessonEntity lesson, @Min(1) TeatcherEntity teatcher, @Min(1) DayEntity day) {
        super(id, room, para, group, lesson, teatcher, day);
    }

    public TimetableEntity(@Min(1) @Max(999) int room, @Min(1) @Max(5) int para, @Min(1) GroupEntity group, @Min(1)LessonEntity lesson, @Min(1) TeatcherEntity teatcher, @Min(1) DayEntity day) {
        super(room, para, group, lesson, teatcher, day);
    }

    public TimetableEntity() {
        super();
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

    @Column(nullable = false)
    @Override
    public int getRoom() {
        return super.getRoom();
    }

    @Override
    public void setRoom(int room) {
        super.setRoom(room);
    }

    @Column(nullable = false)
    @Override
    public int getPara() {
        return super.getPara();
    }

    @Override
    public void setPara(int para) {
        super.setPara(para);
    }

    @ManyToOne
    @Override
    public GroupEntity getGroup() {
        return super.getGroup();
    }

    @Override
    public void setGroup(GroupEntity group) {
        super.setGroup(group);
    }

    @ManyToOne
    @Override
    public LessonEntity getLesson() {
        return super.getLesson();
    }

    @Override
    public void setLesson(LessonEntity lesson) {
        super.setLesson(lesson);
    }

    @ManyToOne
    @Override
    public TeatcherEntity getTeatcher() {
        return super.getTeatcher();
    }

    @Override
    public void setTeatcher(TeatcherEntity teatcher) {
        super.setTeatcher(teatcher);
    }

    @ManyToOne
    @Override
    public DayEntity getDay() {
        return super.getDay();
    }

    @Override
    public void setDay(DayEntity day) {
        super.setDay(day);
    }
}
