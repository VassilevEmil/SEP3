package group6.semester.project.logic.GRPCInterfaces;

import group6.semester.project.model.User;
import org.springframework.http.ResponseEntity;

public interface IUserGRPC {
    ResponseEntity CreateUserAsync(User user);
    ResponseEntity<User> GetUserAsync(String username);
}
