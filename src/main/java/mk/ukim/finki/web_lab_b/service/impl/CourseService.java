package mk.ukim.finki.web_lab_b.service.impl;

import mk.ukim.finki.web_lab_b.model.Course;
import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.model.Teacher;
import mk.ukim.finki.web_lab_b.repository.CourseRepository;
import mk.ukim.finki.web_lab_b.service.CourseServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CourseServiceInterface {

    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public CourseService(CourseRepository courseRepository, StudentService studentService, TeacherService teacherService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = studentService.listAll().stream().filter(s->s.getUsername().equals(username)).findFirst().get();
        Course course = courseRepository.findById(courseId).get();
        courseRepository.addStudentToCourse(student, course);
        return course;
    }

    @Override
    public Course save(String courseName, String courseDesc, Long teacherId) {
        Optional<Teacher> teacher = teacherService.findById(teacherId);
        courseRepository.save(courseName, courseDesc, teacher);
        return new Course(courseName, courseDesc, teacher.get());

    }

    @Override
    public void delete(Long courseId) {
        courseRepository.delete(courseId);
    }

    @Override
    public Optional<Course> findByName(String name) {
        return courseRepository.findByName(name);
    }

    public List<Course> listAll(){
        return courseRepository.findAllCourses();
    }
}