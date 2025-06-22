package com.rocketseat.service.tasks;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Task")
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String email;

    private LocalDateTime dueDate;

    private boolean notified;

    public TasksEntity(TaskRequest taskRequest) {
        this.title = taskRequest.title();
        this.email = taskRequest.email();
        this.dueDate = taskRequest.dueDate();
        this.notified = taskRequest.notified();
    }

}
