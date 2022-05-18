package com.krymlov.lab1.service;

import com.krymlov.lab1.entity.GroupEntity;
import com.krymlov.lab1.entity.LessonEntity;
import com.krymlov.lab1.model.Group;
import com.krymlov.lab1.model.Lesson;
import com.krymlov.lab1.repository.GroupRepo;
import com.krymlov.lab1.repository.LessonRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

    @Autowired
    LessonRepo lessonRepo;

    public int insertValid(Lesson object) {

        if (lessonRepo.existsByName(object.getName())){
            if (!lessonRepo.existsByTypeId(object.getType().getId())){
                lessonRepo.save(new LessonEntity(object.getName(), object.getControl(), object.getHours(), object.getType()));
                return 0;
            }
            return 1;
        }else {
            lessonRepo.save(new LessonEntity(object.getName(), object.getControl(), object.getHours(), object.getType()));
            return 0;
        }
    }

    public int updateValid(Lesson object) {

        if (lessonRepo.existsByName(object.getName())){
            if (!lessonRepo.existsByTypeId(object.getType().getId())){
                LessonEntity entity = lessonRepo.findById(object.getId()).get();
                LessonEntity returnEntity = new LessonEntity(object.getName(), object.getControl(), object.getHours(), object.getType());
                BeanUtils.copyProperties(returnEntity, entity, "id");
                lessonRepo.save(entity);
                return 0;
            }
            return 1;
        }else {
            LessonEntity entity = lessonRepo.findById(object.getId()).get();
            LessonEntity returnEntity = new LessonEntity(object.getName(), object.getControl(), object.getHours(), object.getType());
            BeanUtils.copyProperties(returnEntity, entity, "id");
            lessonRepo.save(entity);
            return 0;
        }
    }

    public int deleteValid(long id) {
        if (lessonRepo.findById(id).isPresent()){
            lessonRepo.deleteById(id);
            return 0;
        }else return 1;
    }

    public LessonRepo getRepo() {
        return lessonRepo;
    }

}
