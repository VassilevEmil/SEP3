package group6.semester.project.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
@Data

public class Post {
    private int id;
    private String title;
    private String description;
    public Date dateCreated;
    private int price;
    private String address;
    private String condition;
    private String phoneNumber;
    private String email;
    private List<Image> images;
    private List<Comment> comments;
    private User writer;

    public Post() {
        title ="";
        description = "";
        address="";
        condition ="";
        phoneNumber = "";
        email = "";
    }
}
