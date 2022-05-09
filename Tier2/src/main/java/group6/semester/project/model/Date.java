package group6.semester.project.model;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Date {
    private int day;
    private int month;
    private int year;
}
