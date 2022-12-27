package mk.ukim.finki.web_lab_b.model;

import lombok.Data;
import mk.ukim.finki.web_lab_b.model.enumerations.TYPE;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(updatable = false, nullable = false)
    private Long courseId;

    //private static Long idSeed = 2L;

    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Student> students;

    @ManyToOne
    private Teacher teacher;

    @Enumerated()
    private TYPE type;

    public Course() {
    }

//    public Course(String name, String description) {
//        this.courseId = ++idSeed;
//        this.name = name;
//        this.description = description;
//        this.students = new ArrayList<>();
//        this.type = TYPE.MANDATORY;
//    }

    public Course(String name, String description, Teacher teacher) {
        //this.courseId = ++idSeed;
        this.name = name;
        this.description = description;
        this.students = new ArrayList<>();
        this.teacher = teacher;
        this.type = TYPE.MANDATORY;
    }
}