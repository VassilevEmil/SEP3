package group6.semester.project.model;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Report {
    private Post post;
    private User reporter;
    private String reason;
}
