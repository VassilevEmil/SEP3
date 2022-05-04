package group6.semester.project.grpcClient.user;

import group6.semester.project.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserClient
{
  User addUser(User user);
  User getUser(String username);
}
