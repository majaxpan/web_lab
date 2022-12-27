package mk.ukim.finki.web_lab_b.repository.jpa;

import mk.ukim.finki.web_lab_b.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByName(String name);

    void deleteById(Long id);

    List<Course> findAll();

}
