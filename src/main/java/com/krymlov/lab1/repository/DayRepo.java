package com.krymlov.lab1.repository;

import com.krymlov.lab1.entity.DayEntity;
import org.springframework.data.repository.CrudRepository;

public interface DayRepo extends CrudRepository<DayEntity, Long> {
}
