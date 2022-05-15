package com.krymlov.lab2.repository;

import com.krymlov.lab2.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
