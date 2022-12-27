package mk.ukim.finki.web_lab_b.service.impl;

import mk.ukim.finki.web_lab_b.model.Course;
import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.model.Teacher;
import mk.ukim.finki.web_lab_b.repository.impl.InMemoryCourseRepository;
import mk.ukim.finki.web_lab_b.repository.jpa.CourseRepository;
import mk.ukim.finki.web_lab_b.repository.jpa.StudentRepository;
import mk.ukim.finki.web_lab_b.repository.jpa.TeacherRepository;
import mk.ukim.finki.web_lab_b.service.CourseServiceInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CourseServiceInterface {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.courseRepository =  courseRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findById(courseId).get().getStudents();
    }

    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }


    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = studentRepository.findByUsername(username);
        Course course = courseRepository.findById(courseId).get();
        courseRepository.findById(courseId).get().getStudents().add(student);
        return course;
    }

    @Override
    public void save(String courseName, String courseDesc, Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).get();
        Course course = new Course(courseName, courseDesc, teacher);
        courseRepository.save(course);
    }

    @Override
    public void delete(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Optional<Course> findByName(String name) {
        return courseRepository.findByName(name);
    }

    public List<Course> listAll(){
        return courseRepository.findAll();
    }
}