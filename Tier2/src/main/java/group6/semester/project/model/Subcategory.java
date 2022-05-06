package group6.semester.project.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data

public class Subcategory {
    private int id;
    private String name;
    private List<Post> posts;
}
