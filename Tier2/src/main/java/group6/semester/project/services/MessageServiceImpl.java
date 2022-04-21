package group6.semester.project.services;


import group6.semester.project.grpcClient.GRPCClient;
import group6.semester.project.grpcClient.GRPCClientImpl;
import group6.semester.project.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    private GRPCClient client;

    public MessageServiceImpl() {
       client = new GRPCClientImpl();
    }

    @Override
    public Message getMessageById(int id) {
        return client.getMessage(id);
    }

    @Override
    public Message addMessage(Message message) {
        return client.addMessage(message);
    }
}
