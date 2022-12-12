package mk.ukim.finki.web_lab_b.service.impl;

import mk.ukim.finki.web_lab_b.model.Course;
import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.repository.CourseRepository;
import mk.ukim.finki.web_lab_b.service.CourseServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements CourseServiceInterface {

    private final CourseRepository courseRepository;
    private final StudentService studentService;

    public CourseService(CourseRepository courseRepository, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = studentService.listAll().stream().filter(s->s.getUsername().equals(username)).findFirst().get();
        Course course = courseRepository.findById(courseId).get();
        courseRepository.addStudentToCourse(student, course);
        return course;
    }

    public List<Course> listAll(){
        return courseRepository.findAllCourses();
    }
}