package mk.ukim.finki.web_lab_b;

import mk.ukim.finki.web_lab_b.model.Student;
import mk.ukim.finki.web_lab_b.model.exceptions.InvalidPasswordException;
import mk.ukim.finki.web_lab_b.model.exceptions.InvalidUsernameException;
import mk.ukim.finki.web_lab_b.repository.jpa.StudentRepository;
import mk.ukim.finki.web_lab_b.service.impl.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SavingStudentTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService service;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        Student student = new Student("username", "pass", "name", "surname");
        Mockito.when(this.studentRepository.save(Mockito.any(Student.class))).thenReturn(student);

        service = Mockito.spy(new StudentService(this.studentRepository));
    }

    @Test
    public void testSuccessSavingStudent(){
        Student student = this.service.save("username", "pass", "name", "surname");

        Mockito.verify(this.service).save("username", "pass", "name", "surname");

        Assert.assertNotNull("StudentIsNull", student);

        Assert.assertEquals("username do not match", "username", student.getUsername());
        Assert.assertEquals("password do not match", "pass", student.getPassword());
        Assert.assertEquals("name do not match", "name", student.getName());
        Assert.assertEquals("surname do not match", "surname", student.getSurname());
    }

    @Test
    public void testNullUsername(){
        Assert.assertThrows("InvalidUsernameException expected",
                InvalidUsernameException.class,
                () -> this.service.save(null, "password", "name", "surname"));
        Mockito.verify(this.service).save(null, "password", "name", "surname");

    }

    @Test
    public void testEmptyUsername() {
        String username = "";
        Assert.assertThrows("InvalidUsernameException expected",
                InvalidUsernameException.class,
                () -> this.service.save(username, "password", "name", "surname"));
        Mockito.verify(this.service).save(username, "password", "name", "surname");
    }


    @Test
    public void testNullPassword(){
        Assert.assertThrows("InvalidPasswordException expected",
                InvalidPasswordException.class,
                () -> this.service.save("username", null, "name", "surname"));
        Mockito.verify(this.service).save("username", null, "name", "surname");

    }

    @Test
    public void testEmptyPassword() {
        String password = "";
        Assert.assertThrows("InvalidPasswordException expected",
                InvalidPasswordException.class,
                () -> this.service.save("username", password, "name", "surname"));
        Mockito.verify(this.service).save("username", password, "name", "surname");
    }

}
