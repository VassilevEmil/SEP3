package group6.semester.project.grpcClient;

import group6.semester.project.model.User;

public interface GRPCUserClient
{
  User addUser(User user);
  User getUser(String username);
}
