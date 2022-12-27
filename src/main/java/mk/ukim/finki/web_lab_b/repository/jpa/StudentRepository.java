package mk.ukim.finki.web_lab_b.repository.jpa;

import mk.ukim.finki.web_lab_b.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findAllByNameOrSurname(String text1, String text2);

    Student findByUsername(String username);
}
