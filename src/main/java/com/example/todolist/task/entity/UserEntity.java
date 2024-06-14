package com.example.todolist.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @SequenceGenerator(
            name = "userEntity_sequence",
            sequenceName = "userEntity_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userEntity_sequence"
    )
    private long id;
    private String nickname;
    private String password;
    @OneToMany(mappedBy = "userEntity")
    private List<TaskEntity> tasks;

    public UserEntity(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
