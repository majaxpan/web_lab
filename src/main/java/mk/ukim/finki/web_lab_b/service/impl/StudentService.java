package mk.ukim.finki.web_lab_b.service.impl;

import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.model.exceptions.InvalidPasswordException;
import mk.ukim.finki.web_lab_b.model.exceptions.InvalidUsernameException;
import mk.ukim.finki.web_lab_b.repository.impl.InMemoryStudentRepository;
import mk.ukim.finki.web_lab_b.repository.jpa.StudentRepository;
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
        return studentRepository.findAll();
    }

    @Override
    public List<Student> searchByNameOrSurname(String text) {
        return studentRepository.findAllByNameOrSurname(text, text);
    }

    @Override
    public Student save(String username, String password, String name, String surname) {
        if(username == null || username.isEmpty()){
            throw new InvalidUsernameException();
        }
        if(password == null || password.isEmpty()){
            throw new InvalidPasswordException();
        }
        Student student = new Student(username, password, name, surname);
        studentRepository.save(student);
        return student;
    }
}



