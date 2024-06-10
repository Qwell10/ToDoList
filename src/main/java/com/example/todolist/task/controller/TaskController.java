package com.example.todolist.task.controller;

import com.example.todolist.task.entity.UserEntity;
import com.example.todolist.task.repository.TaskRepository;
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


    @PostMapping("newUser")
    public UserEntity createUser(@RequestBody UserEntity newUser) {
        return taskRepository.save(newUser);
    }

    @GetMapping("get")
    public List<TaskEntity> getTask() {
        return taskService.getTasks();
    }

    @PostMapping("newTask")
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return taskRepository.save(task);
    }
}
