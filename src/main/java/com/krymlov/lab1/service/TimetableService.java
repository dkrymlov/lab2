package com.krymlov.lab1.service;

import com.krymlov.lab1.entity.TeatcherEntity;
import com.krymlov.lab1.entity.TimetableEntity;
import com.krymlov.lab1.model.Teatcher;
import com.krymlov.lab1.model.Timetable;
import com.krymlov.lab1.repository.TeatcherRepo;
import com.krymlov.lab1.repository.TimetableRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimetableService {

    @Autowired
    TimetableRepo timetableRepo;

    public int insertValid(Timetable object) {

        if (object.getPara() > 4 || object.getPara() < 1){
            return 1;
        }
        if (object.getRoom() > 1000 || object.getRoom() < 1){
            return 1;
        }

        if (timetableRepo.existsByParaAndRoomAndDayAndGroupAndLessonAndTeatcher(object.getPara(), object.getRoom(), object.getDay(), object.getGroup(), object.getLesson(), object.getTeatcher())){
            return 1;
        }else if (timetableRepo.existsByRoomAndAndDayAndPara(object.getRoom(), object.getDay(), object.getPara())){
            return 1;
        }else {
            timetableRepo.save(new TimetableEntity(object.getRoom(), object.getPara(), object.getGroup(), object.getLesson(), object.getTeatcher(), object.getDay()));
            return 0;
        }
    }

    public int updateValid(Timetable object) {

        if (timetableRepo.existsByParaAndRoomAndDayAndGroupAndLessonAndTeatcher(object.getPara(), object.getRoom(), object.getDay(), object.getGroup(), object.getLesson(), object.getTeatcher())){
            return 1;
        }else if (timetableRepo.existsByRoomAndAndDayAndPara(object.getRoom(), object.getDay(), object.getPara())){
            return 1;
        }else {
            TimetableEntity entity = timetableRepo.findById(object.getId()).get();
            TimetableEntity returnEntity = new TimetableEntity(object.getRoom(), object.getPara(), object.getGroup(), object.getLesson(), object.getTeatcher(), object.getDay());
            BeanUtils.copyProperties(returnEntity, entity, "id");
            timetableRepo.save(entity);
            return 0;
        }
    }

    public int deleteValid(long id) {
        if (timetableRepo.findById(id).isPresent()){
            timetableRepo.deleteById(id);
            return 0;
        }else return 1;
    }

    public TimetableRepo getRepo() {
        return timetableRepo;
    }

}
