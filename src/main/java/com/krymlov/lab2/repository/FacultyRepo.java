package com.krymlov.lab2.repository;

import com.krymlov.lab2.entity.FacultyEntity;
import org.springframework.data.repository.CrudRepository;

public interface FacultyRepo extends CrudRepository<FacultyEntity, Long> {
}
