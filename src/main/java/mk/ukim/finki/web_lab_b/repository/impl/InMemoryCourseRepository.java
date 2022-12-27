package mk.ukim.finki.web_lab_b.repository.impl;

import mk.ukim.finki.web_lab_b.model.Course;
import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCourseRepository {

    private List<Course> courses = new ArrayList<>();

    public InMemoryCourseRepository() {
//        courses.add(new Course("Course 1", "course 1 description"));
//        courses.add(new Course("Course 2", "course 2 description"));
//        courses.add(new Course("Course 3", "course 3 description"));
//        courses.add(new Course("Course 4", "course 4 description"));
//        courses.add(new Course("Course 5", "course 5 description"));
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

    public Course save(String courseName, String courseDesc, Optional<Teacher> teacher){
        courses.removeIf(c -> c.getName().equals(courseName));
        Course course = new Course(courseName, courseDesc, teacher.get());
        courses.add(course);
        return course;
    }

    public void delete(Long courseId){
        courses.removeIf(c -> c.getCourseId().equals(courseId));
    }

    public Optional<Course> findByName(String name){
        return courses.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();
    }
}


