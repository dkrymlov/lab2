package com.krymlov.lab1.service;

import com.krymlov.lab1.entity.FacultyEntity;
import com.krymlov.lab1.entity.GroupEntity;
import com.krymlov.lab1.model.Faculty;
import com.krymlov.lab1.model.Group;
import com.krymlov.lab1.repository.FacultyRepo;
import com.krymlov.lab1.repository.GroupRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    FacultyRepo facultyRepo;

    public int insertValid(Group object) {

        if (groupRepo.existsByName(object.getName()) || !facultyRepo.existsByName(object.getFaculty().getName())){
            return 1;
        }else {
            groupRepo.save(new GroupEntity(object.getName(), object.getCourse(), object.getFaculty(), object.getStudents()));
        }
        return 0;
    }

    public int updateValid(Group object) {
        if (groupRepo.existsByName(object.getName()) || !facultyRepo.existsById(object.getFaculty().getId())){
            return 1;
        }else if (object.getId() == null || !groupRepo.existsById(object.getId())){
            return 1;
        }else {
            GroupEntity entity = groupRepo.findById(object.getId()).get();
            GroupEntity returnEntity = new GroupEntity(object.getName(), object.getCourse(), object.getFaculty(), object.getStudents());
            BeanUtils.copyProperties(returnEntity, entity, "id");
            groupRepo.save(entity);
        }
        return 0;
    }

    public int deleteValid(long id) {
        if (groupRepo.findById(id).isPresent()){
            groupRepo.deleteById(id);
            return 0;
        }else return 1;
    }

    public GroupRepo getRepo() {
        return groupRepo;
    }

}
