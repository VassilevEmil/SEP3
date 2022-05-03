package group6.semester.project.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class User implements Serializable {
    private String Username;
    private String FirstName;
    private String LastName;
    private String Password;
    private String Role;
}
