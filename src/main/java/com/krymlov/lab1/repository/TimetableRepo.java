package com.krymlov.lab1.repository;

import com.krymlov.lab1.entity.*;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public interface TimetableRepo extends CrudRepository<TimetableEntity, Long> {
    boolean existsByParaAndRoomAndDayAndGroupAndLessonAndTeatcher(@Min(1) @Max(5) int para, @Min(1) @Max(999) int room, @Min(1) DayEntity day, @Min(1) GroupEntity group, @Min(1) LessonEntity lesson, @Min(1) TeatcherEntity teatcher);
    boolean existsByRoomAndAndDayAndPara(int room, DayEntity day, int para);
}
