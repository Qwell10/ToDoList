package com.example.todolist.task.service;

import com.example.todolist.task.entity.TaskEntity;
import com.example.todolist.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskEntity> getTasks() {
        return taskRepository.findAll();
    }
}
