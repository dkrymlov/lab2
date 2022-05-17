package com.krymlov.lab1.repository;

import com.krymlov.lab1.entity.LessonEntity;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepo extends CrudRepository<LessonEntity, Long>{
}
