package mk.ukim.finki.web_lab_b.model;

import lombok.Data;

@Data
public class Teacher {

    private Long id;
    private static Long idSeed=100L;
    private String name;
    private String surname;

    public Teacher(String name, String surname) {
        this.id=idSeed++;
        this.name = name;
        this.surname = surname;
    }
}
