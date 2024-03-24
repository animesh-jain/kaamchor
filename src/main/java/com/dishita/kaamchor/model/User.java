package com.dishita.kaamchor.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "user", schema = "kaamchor")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String mobile;
    private String createdAt;
    private String updatedAt;
    private String role;
    private String status;


}
