package mk.ukim.finki.web_lab_b.web.controller;

import mk.ukim.finki.web_lab_b.model.Course;
import mk.ukim.finki.web_lab_b.model.Teacher;
import mk.ukim.finki.web_lab_b.service.impl.CourseService;
import mk.ukim.finki.web_lab_b.service.impl.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("courses", this.courseService.listAll());
        return "listCourses";
    }

    @GetMapping("/add-form")
    public String getAddCoursePage(Model model){
        List<Teacher> teachers = teacherService.findAll();
        model.addAttribute("teachers", teachers);
        return "add-course";
    }

    @PostMapping("/add-form")
    public String saveCourse(@RequestParam String courseName,
                             @RequestParam String courseDesc,
                             @RequestParam Long teacherId){
        this.courseService.save(courseName, courseDesc, teacherId);
        return "redirect:/courses";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        this.courseService.delete(id);
        return "redirect:/courses";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditCoursePage(@PathVariable Long id, Model model){
        if(this.courseService.findById(id).isPresent()){
            Course course = this.courseService.findById(id).get();
            List<Teacher> teachers = teacherService.findAll();
            model.addAttribute("teachers", teachers);
            model.addAttribute("course", course);
            return "add-course";
        }
        return "redirect:/courses";
    }
}
