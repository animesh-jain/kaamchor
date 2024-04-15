package com.dishita.kaamchor.model;

import com.dishita.kaamchor.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "task", schema = "kaamchor")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "form_link")
    private String formLink;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "user_id")
    private Integer userId;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;
    @Column(name = "due_date")
    private Date dueDate;
    @Column(name="static_details")
    private String staticDetails;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "updated_at")
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}
