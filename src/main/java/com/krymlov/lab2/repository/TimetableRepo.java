package com.krymlov.lab2.repository;

import com.krymlov.lab2.entity.TimetableEntity;
import org.springframework.data.repository.CrudRepository;

public interface TimetableRepo extends CrudRepository<TimetableEntity, Long> {
}
