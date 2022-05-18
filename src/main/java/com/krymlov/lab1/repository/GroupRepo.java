package com.krymlov.lab1.repository;

import com.krymlov.lab1.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepo extends CrudRepository<GroupEntity, Long> {

    boolean existsByName(String name);

}
