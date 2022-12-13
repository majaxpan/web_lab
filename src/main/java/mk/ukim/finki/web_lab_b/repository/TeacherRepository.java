package mk.ukim.finki.web_lab_b.repository;

import mk.ukim.finki.web_lab_b.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TeacherRepository {

    private List<Teacher> teachers = new ArrayList<>();

    public TeacherRepository() {
        teachers.add(new Teacher("Teacher 1", "Surname"));
        teachers.add(new Teacher("Teacher 2", "Surname"));
        teachers.add(new Teacher("Teacher 3", "Surname"));
        teachers.add(new Teacher("Teacher 4", "Surname"));
        teachers.add(new Teacher("Teacher 5", "Surname"));
    }

    public List<Teacher> findAll(){
        return teachers;
    }

    public Optional<Teacher> findById(Long teacherId){
        return teachers.stream()
                .filter(t -> t.getId().equals(teacherId))
                .findFirst();
    }
}
