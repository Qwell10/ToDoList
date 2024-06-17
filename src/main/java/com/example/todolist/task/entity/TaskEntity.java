package com.example.todolist.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private long id;
    private String taskName;
    private String description;
    private Boolean finished;
    @ManyToOne
    private UserEntity userEntity;

    public TaskEntity(String taskName, String description, Boolean finished) {
        this.taskName = taskName;
        this.description = description;
        this.finished = finished;
    }
}
