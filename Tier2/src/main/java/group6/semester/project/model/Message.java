package group6.semester.project.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Message {
    private int id;
    private String body;
}
