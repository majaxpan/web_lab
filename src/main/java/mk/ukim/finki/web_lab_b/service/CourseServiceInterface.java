package mk.ukim.finki.web_lab_b.service;

import mk.ukim.finki.web_lab_b.model.Course;
import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface CourseServiceInterface {
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);

    Course save(String courseName, String courseDesc, Long teacherId);
    void delete(Long courseId);
    Optional<Course> findByName(String name);
}