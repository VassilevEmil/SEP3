package group6.semester.project.grpcClient;


import group6.semester.project.model.Message;

public interface GRPCClient {
    Message addMessage(Message message);
    Message getMessage(int id);
}
