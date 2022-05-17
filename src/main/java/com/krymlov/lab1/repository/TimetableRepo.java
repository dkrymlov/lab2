package com.krymlov.lab1.repository;

import com.krymlov.lab1.entity.TimetableEntity;
import org.springframework.data.repository.CrudRepository;

public interface TimetableRepo extends CrudRepository<TimetableEntity, Long> {
}
