package com.krymlov.lab2.repository;

import com.krymlov.lab2.entity.LessonEntity;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepo extends CrudRepository<LessonEntity, Long>{
}
