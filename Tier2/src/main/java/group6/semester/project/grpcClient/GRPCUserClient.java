package group6.semester.project.grpcClient;

import group6.semester.project.model.User;
import org.springframework.http.ResponseEntity;

public interface GRPCUserClient
{
  ResponseEntity addUser(User user);
  ResponseEntity<User> getUser(String username);
}
