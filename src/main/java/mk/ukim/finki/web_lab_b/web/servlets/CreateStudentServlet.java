package mk.ukim.finki.web_lab_b.web.servlets;

import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.service.impl.StudentService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="createStudent", urlPatterns = "/createStudent")
public class CreateStudentServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final StudentService studentService;

    public CreateStudentServlet(SpringTemplateEngine springTemplateEngine, StudentService studentService) {
        this.springTemplateEngine = springTemplateEngine;
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("courseId") == null){
            resp.sendRedirect("/listCourses");
        }
        WebContext context = new WebContext(req, resp, req.getServletContext());
        this.springTemplateEngine.process("createStudent.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("username").isEmpty()){
            resp.sendRedirect("/createStudent");
        }
        else if(req.getParameter("password").isEmpty()){
            resp.sendRedirect("/createStudent");
        }
        else if(req.getParameter("name").isEmpty()){
            resp.sendRedirect("/createStudent");
        }
        else if(req.getParameter("surname").isEmpty()){
            resp.sendRedirect("/createStudent");
        }
        else{
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");

            studentService.save(username, password, name, surname);
            resp.sendRedirect("/addStudent");
        }
    }
}
