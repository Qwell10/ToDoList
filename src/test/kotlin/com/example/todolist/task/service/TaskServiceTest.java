package com.example.todolist.task.service;

import com.example.todolist.task.entity.TaskEntity;
import com.example.todolist.task.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @see com.example.todolist.task.service.TaskService
 */

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void getTasksTest() {
        List<TaskEntity> mockTasks = Arrays.asList(
                new TaskEntity("Task 1", "Description 1", false),
                new TaskEntity("Task 2", "Description 2", true)
        );

        when(taskRepository.findAll()).thenReturn(mockTasks);

        List<TaskEntity> retrievedTasks = taskService.getTasks();

        assertEquals(mockTasks, retrievedTasks);
        verify(taskRepository, times(1)).findAll();
    }
}