package mk.ukim.finki.web_lab_b.web.controller;

import mk.ukim.finki.web_lab_b.service.impl.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/studentsEnrollment")
public class StudentEnrollmentController {

    //private final GradeService gradeService;
    private final CourseService courseService;

    public StudentEnrollmentController(CourseService courseService) {
        //this.gradeService = gradeService;
        this.courseService = courseService;
    }

    @GetMapping
    public String getStudentsInCourse(HttpServletRequest req, Model model){
        if(req.getSession().getAttribute("username") == null){
            return "redirect:/addStudent";
        }
        String username = (String) req.getSession().getAttribute("username");
        String id = (String) req.getSession().getAttribute("courseId");
        Long courseId = Long.valueOf(id);

        courseService.addStudentInCourse(username, courseId);
        model.addAttribute("studentsInCourse", courseService.listStudentsByCourse(courseId));

        return "/studentsInCourse";
    }
}
