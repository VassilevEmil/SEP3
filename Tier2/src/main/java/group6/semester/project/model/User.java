package group6.semester.project.model;

import lombok.Data;

@Data
public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
}
