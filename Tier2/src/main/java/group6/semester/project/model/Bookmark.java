package group6.semester.project.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Bookmark {
    private User User;
    private Post Post;
}
