package com.example.todolist.task.controller;

import com.example.todolist.task.entity.UserEntity;
import com.example.todolist.task.repository.TaskRepository;
import com.example.todolist.task.repository.UserRepository;
import com.example.todolist.task.service.TaskService;
import com.example.todolist.task.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("newUser")
    public UserEntity createUser(@RequestBody UserEntity newUser) {
        return userRepository.save(newUser);
    }

    @PostMapping("newTask")
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return taskRepository.save(task);
    }

    @GetMapping("get")
    public List<TaskEntity> getTask() {
        return taskService.getTasks();
    }
}
