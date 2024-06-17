package com.example.todolist.task.service;

import com.example.todolist.task.entity.UserEntity;
import com.example.todolist.task.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @see com.example.todolist.task.service.UserService
 */

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    public void registerUserTest() {
        when(userRepository.save(any(UserEntity.class))).thenReturn(new UserEntity());

        userService.registerUser("Qwell", "password");

        verify(userRepository).save(any(UserEntity.class));
    }

}