package mk.ukim.finki.web_lab_b.web.controller;

import mk.ukim.finki.web_lab_b.service.impl.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/addStudent")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(HttpServletRequest req, Model model){
        if(req.getSession().getAttribute("courseId") == null){
            return "redirect:/courses";
        }
        model.addAttribute("students", studentService.listAll());
        return "/listStudents";
    }

    @PostMapping
    public String enrollStudent(HttpServletRequest req){
        req.getSession().setAttribute("username", req.getParameter("username"));
        //req.getSession().setAttribute("courseId", req.getParameter("courseId"));
        return "redirect:/studentsEnrollment";
    }
}
