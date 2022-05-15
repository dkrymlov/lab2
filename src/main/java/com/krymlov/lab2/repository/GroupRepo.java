package com.krymlov.lab2.repository;

import com.krymlov.lab2.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepo extends CrudRepository<GroupEntity, Long> {
}
