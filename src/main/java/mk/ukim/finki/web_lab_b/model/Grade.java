package mk.ukim.finki.web_lab_b.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Character grade;

    @OneToOne
    private Student student;

    @OneToOne
    private Course course;

    private LocalDateTime timestamp;

    public Grade(Character grade, Student student, Course course) {
        this.grade = grade;
        this.student = student;
        this.course = course;
        this.timestamp=LocalDateTime.now();
    }
}
