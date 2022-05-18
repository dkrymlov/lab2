package com.krymlov.lab1.service;

import com.krymlov.lab1.entity.FacultyEntity;
import com.krymlov.lab1.model.Faculty;
import com.krymlov.lab1.repository.FacultyRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService{

    @Autowired
    FacultyRepo facultyRepo;

    public int insertValid(Faculty object) {

        if (facultyRepo.existsByName(object.getName())){
            return 1;
        }else {
            facultyRepo.save(new FacultyEntity(object.getName()));
        }
        return 0;
    }

    public int updateValid(Faculty object) {
        if (getRepo().existsByName(object.getName())){
            return 1;
        }else if (object.getId() == null || !facultyRepo.existsById(object.getId())){
            return 1;
        }else {
            FacultyEntity entity = facultyRepo.findById(object.getId()).get();
            FacultyEntity returnEntity = new FacultyEntity(object.getName());
            BeanUtils.copyProperties(returnEntity, entity, "id");
            facultyRepo.save(entity);
        }
        return 0;
    }

    public int deleteValid(long id) {
        if (facultyRepo.findById(id).isPresent()){
            facultyRepo.deleteById(id);
            return 0;
        }else return 1;
    }

    public FacultyRepo getRepo() {
        return facultyRepo;
    }

}
