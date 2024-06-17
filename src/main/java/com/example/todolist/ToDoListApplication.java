package com.example.todolist;

import com.example.todolist.task.entity.UserEntity;
import com.example.todolist.task.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class ToDoListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoListApplication.class, args);
    }

    @Component
    public class UserInputs {

        @Autowired
        private UserService userService;

        @PostConstruct
        public void init() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome in your diar.");
            boolean keepRunning = true;

            while (keepRunning) {
                System.out.println("1 - Register");
                System.out.println("2 - Login");
                System.out.println("3 - Exit");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("Nickname:");
                        String nickname = sc.nextLine();
                        System.out.println("Password:");
                        String password = sc.nextLine();

                        userService.registerUser(nickname, password);

                        System.out.println("Registration completed");
                        break;
                    case "2":
                        try {
                            Optional<UserEntity> user = userService.loginUser();
                            System.out.println();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "3":
                        System.out.println("Exiting application.");
                        keepRunning = false;
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter 1 for Register or 2 for Login.");
                }
            }
        }
    }
}
