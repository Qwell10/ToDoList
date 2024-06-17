package com.example.todolist.task.service;

import com.example.todolist.task.entity.UserEntity;
import com.example.todolist.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Optional;
import java.util.Scanner;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(String nickname, String password) {
        //todo: Hash the password(security)
        UserEntity userEntity = new UserEntity(nickname, password);
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> loginUser() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter nickname:");
        String nickname = sc.nextLine();

        System.out.println("Enter password:");
        String password = sc.nextLine();

        String sqlUserEntity = "SELECT * FROM user_entity WHERE nickname = ? AND password = ?";
        String sqlUserId = "SELECT id FROM user_entity WHERE nickname = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sqlUserEntity)) {

            statement.setString(1, nickname);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Long userId = resultSet.getLong("id");
                System.out.println("You are logged in");
                return userRepository.findById(userId);

            } else {
                System.out.println("Invalid nickname or password.");
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/todolist?user=qwell&password=password");
    }
}

