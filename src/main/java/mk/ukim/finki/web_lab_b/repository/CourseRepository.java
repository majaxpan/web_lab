package mk.ukim.finki.web_lab_b.repository;

import mk.ukim.finki.web_lab_b.model.Course;
import mk.ukim.finki.web_lab_b.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course(1L, "Course 1", "course 1 description"));
        courses.add(new Course(2L, "Course 2", "course 2 description"));
        courses.add(new Course(3L, "Course 3", "course 3 description"));
        courses.add(new Course(4L, "Course 4", "course 4 description"));
        courses.add(new Course(5L, "Course 5", "course 5 description"));
    }

    public List<Course> findAllCourses(){
        return courses;
    }

    public Optional<Course> findById(Long courseId){
        return courses.stream().filter(i -> i.getCourseId().equals(courseId)).findFirst();
    }

    public List<Student> findAllStudentsByCourse(Long courseId){
        return courses.stream().filter(i -> i.getCourseId().equals(courseId)).findFirst().get().getStudents();
    }

    public Course addStudentToCourse(Student student, Course course){
        course.getStudents().add(student);
        return course;
    }
}


