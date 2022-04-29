package group6.semester.project.services;

import group6.semester.project.model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    ResponseEntity CreateUserAsync(User user) throws Exception;
    ResponseEntity<User> GetUserAsync(String username) throws Exception;
}
