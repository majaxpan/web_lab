package mk.ukim.finki.web_lab_b.web.controller;

import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.service.impl.StudentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/createStudent")
public class CreateStudentController {

    private final StudentService studentService;

    public CreateStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showCreateStudentForm(HttpServletRequest req){
        if(req.getSession().getAttribute("courseId") == null){
            return "redirect:/courses";
        }
        return "/createStudent";
    }

    @PostMapping
    public String createStudentForm(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String name,
                             @RequestParam String surname){
        studentService.save(username, password, name, surname);
        return "redirect:/addStudent";
    }
}
