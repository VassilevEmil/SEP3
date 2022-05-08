package group6.semester.project.model;

import com.google.type.DateTime;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
@Data

public class Post {
    private int id;
    private String Title;
    private String Description;
    public Date DateCreated;
    private int Price;
    private String Address;
    private String Condition;
    private String PhoneNumber;
    private String Email;
    private List<Image> Images;
    private User Writer;

    public Post() {

    }
}
