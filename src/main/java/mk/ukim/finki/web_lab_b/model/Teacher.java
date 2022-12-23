package mk.ukim.finki.web_lab_b.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private static Long idSeed=100L;

    private String name;

    private String surname;

    private LocalDate dateOfEmployment;

    public Teacher(String name, String surname) {
        //this.id=idSeed++;
        this.name = name;
        this.surname = surname;
        dateOfEmployment=LocalDate.now();
    }
}
