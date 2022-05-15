package com.krymlov.lab2.repository;

import com.krymlov.lab2.entity.TypeEntity;
import org.springframework.data.repository.CrudRepository;

public interface TypeRepo extends CrudRepository<TypeEntity, Long> {
}
