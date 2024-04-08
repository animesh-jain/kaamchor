package com.dishita.kaamchor.model;

import com.dishita.kaamchor.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "user_task_mapping", schema = "kaamchor")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserTaskMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "task_id")
    private Integer taskId;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;
    @Column(name = "priority")
    private String priority;
    @Column(name = "due_date")
    private Date dueDate;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;


}
