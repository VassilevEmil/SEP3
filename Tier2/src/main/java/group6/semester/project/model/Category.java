package group6.semester.project.model;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private int id;
    private String name;
    private List<Subcategory> subcategories;
}
