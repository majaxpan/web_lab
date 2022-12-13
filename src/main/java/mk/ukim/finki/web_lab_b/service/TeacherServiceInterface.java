package mk.ukim.finki.web_lab_b.service;

import mk.ukim.finki.web_lab_b.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherServiceInterface {
    List<Teacher> findAll();
    Optional<Teacher> findById(Long id);
}
