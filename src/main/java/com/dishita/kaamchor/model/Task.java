package com.dishita.kaamchor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "task", schema = "kaamchor")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String formLink;
    private Integer priority;
    private String createdAt;
    private String updatedAt;
}
