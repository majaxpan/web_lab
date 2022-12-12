package mk.ukim.finki.web_lab_b.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Course {

    private Long courseId;
    private String name;
    private String description;
    private List<Student> students;

    public Course(Long courseId, String name, String description) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.students = new ArrayList<>();
    }
}