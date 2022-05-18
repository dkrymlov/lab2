package com.krymlov.lab1.service;

import com.krymlov.lab1.entity.LessonEntity;
import com.krymlov.lab1.entity.TeatcherEntity;
import com.krymlov.lab1.model.Lesson;
import com.krymlov.lab1.model.Teatcher;
import com.krymlov.lab1.repository.LessonRepo;
import com.krymlov.lab1.repository.TeatcherRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeatcherService {

    @Autowired
    TeatcherRepo teatcherRepo;

    public int insertValid(Teatcher object) {

        if (teatcherRepo.existsByName(object.getName()) && teatcherRepo.existsByPhone(object.getPhone())){
            return 1;
        }else if (teatcherRepo.existsByName(object.getName())){
            return 1;
        }else if (teatcherRepo.existsByPhone(object.getPhone())){
            return 1;
        }else{
            teatcherRepo.save(new TeatcherEntity(object.getName(), object.getPhone(), object.getDegree()));
            return 0;
        }

    }

    public int updateValid(Teatcher object) {

        if (teatcherRepo.existsByName(object.getName()) && teatcherRepo.existsByPhone(object.getPhone())) {
            return 1;
        }else{
            TeatcherEntity entity = teatcherRepo.findById(object.getId()).get();
            TeatcherEntity returnEntity = new TeatcherEntity(object.getName(), object.getPhone(), object.getDegree());
            BeanUtils.copyProperties(returnEntity, entity, "id");
            teatcherRepo.save(entity);
            return 0;
        }
    }

    public int deleteValid(long id) {
        if (teatcherRepo.findById(id).isPresent()){
            teatcherRepo.deleteById(id);
            return 0;
        }else return 1;
    }

    public TeatcherRepo getRepo() {
        return teatcherRepo;
    }

}
