package group6.semester.project.services;

import group6.semester.project.model.User;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity CreateUserAsync(User user) throws ExecutionControl.NotImplementedException;
    ResponseEntity<User> GetUserAsync(String username) throws ExecutionControl.NotImplementedException;
}
