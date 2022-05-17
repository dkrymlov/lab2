package com.krymlov.lab1.repository;

import com.krymlov.lab1.entity.TypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepo extends CrudRepository<TypeEntity, Long> {
}
