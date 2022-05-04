package group6.semester.project.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class User implements Serializable {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
}
