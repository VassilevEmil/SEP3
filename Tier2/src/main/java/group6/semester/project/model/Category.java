package group6.semester.project.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data

public class Category {
    private int id;
    private String name;
    private List<Subcategory> subcategories;
}
