package com.krymlov.lab1.repository;

import com.krymlov.lab1.entity.TeatcherEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeatcherRepo extends CrudRepository<TeatcherEntity, Long> {
}
