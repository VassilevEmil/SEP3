package group6.semester.project.model;

import lombok.Data;

@Data
public class Comment {
    private int id;
    private User writer;
    private String body;

}
