package mk.ukim.finki.web_lab_b.service;

import mk.ukim.finki.web_lab_b.model.Student;

import java.util.List;

public interface StudentServiceInterface {
    List<Student> listAll();
    List<Student> searchByNameOrSurname(String text);
    Student save(String username, String password, String name, String surname);

}
