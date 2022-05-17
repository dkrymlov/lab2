package com.krymlov.lab1.repository;


import com.krymlov.lab1.entity.FacultyEntity;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepo extends CrudRepository<FacultyEntity, Long> {
}
