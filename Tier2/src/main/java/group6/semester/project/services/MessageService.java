package group6.semester.project.services;


import group6.semester.project.model.Message;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    Message getMessageById(int id);
    Message addMessage(Message message);
}
