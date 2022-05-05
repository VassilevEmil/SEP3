package group6.semester.project.model;

import lombok.Data;
import org.springframework.stereotype.Component;
@Component
@Data

public class Comment {
    private int id;
    private User writer;
    private String body;

}
