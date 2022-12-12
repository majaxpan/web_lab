package mk.ukim.finki.web_lab_b.service.impl;

import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.repository.StudentRepository;
import mk.ukim.finki.web_lab_b.service.StudentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAllStudents();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return studentRepository.findAllByNameOrSurname(text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        Student student = new Student(username, password, name, surname);
        studentRepository.findAllStudents().add(student);
        return student;
    }
}



