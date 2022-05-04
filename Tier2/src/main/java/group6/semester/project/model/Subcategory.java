package group6.semester.project.model;

import lombok.Data;

import java.util.List;

@Data
public class Subcategory {
    private int id;
    private String name;
    private List<Post> posts;
}
