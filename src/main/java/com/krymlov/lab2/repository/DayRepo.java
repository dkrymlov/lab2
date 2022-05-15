package com.krymlov.lab2.repository;

import com.krymlov.lab2.entity.DayEntity;
import org.springframework.data.repository.CrudRepository;

public interface DayRepo extends CrudRepository<DayEntity, Long> {
}
