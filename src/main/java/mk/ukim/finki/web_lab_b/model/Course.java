package mk.ukim.finki.web_lab_b.model;

import lombok.Data;
import mk.ukim.finki.web_lab_b.model.enumerations.TYPE;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    //private static Long idSeed = 1L;
    private String name;

    private String description;

    @ManyToMany
    private List<Student> students;

    @OneToOne
    private Teacher teacher;

    @Enumerated(EnumType.STRING)
    private TYPE type;

    public Course(String name, String description) {
        //this.courseId = idSeed++;
        this.name = name;
        this.description = description;
        this.students = new ArrayList<>();
        this.type = TYPE.MANDATORY;
    }

    public Course(String name, String description, Teacher teacher) {
        //this.courseId = idSeed++;
        this.name = name;
        this.description = description;
        this.students = new ArrayList<>();
        this.teacher = teacher;
        this.type = TYPE.MANDATORY;
    }
}