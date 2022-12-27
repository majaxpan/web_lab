package mk.ukim.finki.web_lab_b.repository.jpa;

import mk.ukim.finki.web_lab_b.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
