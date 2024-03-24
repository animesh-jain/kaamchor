package com.dishita.kaamchor.model;

import com.dishita.kaamchor.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "user_task_mapping", schema = "kaamchor")
@Getter
@Setter
public class UserTaskMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer taskId;
    private TaskStatus status;
    private String priority;
    private String dueDate;
    private Boolean isActive;
    private String createdAt;
    private String updatedAt;
    @ManyToOne
    private Task task;
    @ManyToOne
    private User user;


}
