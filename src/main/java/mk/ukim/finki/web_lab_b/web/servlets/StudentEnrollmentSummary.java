package mk.ukim.finki.web_lab_b.web.servlets;

import mk.ukim.finki.web_lab_b.service.impl.CourseService;
import mk.ukim.finki.web_lab_b.service.impl.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="studentsInCourse", urlPatterns = "/StudentEnrollmentSummary")
public class StudentEnrollmentSummary extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;
    private final CourseService courseService;

    public StudentEnrollmentSummary(SpringTemplateEngine springTemplateEngine, StudentService studentService, CourseService courseService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("username") == null){
            resp.sendRedirect("/addStudent");
        }
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String username = (String) req.getSession().getAttribute("username");
        Long courseId = (Long) req.getSession().getAttribute("courseId");
        courseService.addStudentInCourse(username, courseId);

        context.setVariable("studentsInCourse", courseService.listStudentsByCourse(courseId));
        this.springTemplateEngine.process("studentsInCourse.html", context, resp.getWriter());
    }
}
