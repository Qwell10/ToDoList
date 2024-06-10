package com.example.todolist.task.repository;

import com.example.todolist.task.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


    //PROC INTERFACE A NE CLASS --->>
}
