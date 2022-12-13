package mk.ukim.finki.web_lab_b.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Course {

    private Long courseId;
    private static Long idSeed = 1L;
    private String name;
    private String description;
    private List<Student> students;
    private Teacher teacher;

    public Course(String name, String description) {
        this.courseId = idSeed++;
        this.name = name;
        this.description = description;
        this.students = new ArrayList<>();
    }

    public Course(String name, String description, Teacher teacher) {
        this.courseId = idSeed++;
        this.name = name;
        this.description = description;
        this.students = new ArrayList<>();
        this.teacher = teacher;
    }
}