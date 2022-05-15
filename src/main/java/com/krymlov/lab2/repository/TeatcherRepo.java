package com.krymlov.lab2.repository;

import com.krymlov.lab2.entity.TeatcherEntity;
import org.springframework.data.repository.CrudRepository;

public interface TeatcherRepo extends CrudRepository<TeatcherEntity, Long> {
}
