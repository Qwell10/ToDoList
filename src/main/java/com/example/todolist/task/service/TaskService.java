package com.example.todolist.task.service;

import com.example.todolist.task.entity.TaskEntity;
import com.example.todolist.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity createTask(String taskName, String description, Boolean finished) {
        TaskEntity task = new TaskEntity(taskName, description, false);
        return taskRepository.save(task);
    }

    public List<TaskEntity> getTasks() {
        return taskRepository.findAll();
    }
}
