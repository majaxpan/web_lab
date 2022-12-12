package mk.ukim.finki.web_lab_b.service;

import mk.ukim.finki.web_lab_b.model.Course;
import mk.ukim.finki.web_lab_b.model.Student;

import java.util.List;

public interface CourseServiceInterface {
    List<Student> listStudentsByCourse(Long courseId);
    Course addStudentInCourse(String username, Long courseId);
}