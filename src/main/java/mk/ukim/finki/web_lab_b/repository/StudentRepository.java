package mk.ukim.finki.web_lab_b.repository;

import mk.ukim.finki.web_lab_b.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    public StudentRepository() {
        students.add(new Student("username1", "pass", "Name1", "Surname1"));
        students.add(new Student("username2", "pass", "Name2", "Surname2"));
        students.add(new Student("username3", "pass", "Name3", "Surname3"));
        students.add(new Student("username4", "pass", "Name4", "Surname4"));
        students.add(new Student("username5", "pass", "Name5", "Surname5"));
    }

    public List<Student> findAllStudents(){
        return students;
    }

    public List<Student> findAllByNameOrSurname(String text){
        return students.stream()
                .filter(i -> i.getName().contains(text) || i.getSurname().contains(text))
                .collect(Collectors.toList());
    }
}
