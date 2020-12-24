package pl.sidor.controller;

import com.google.common.base.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import pl.sidor.connection.DatabaseConnection;
import pl.sidor.entity.general.Student;
import pl.sidor.exception.ExceptionFactory;
import pl.sidor.service.LoginService;
import pl.sidor.util.StringUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

import static pl.sidor.enums.GeneralEnums.EMPTY_STRING;
import static pl.sidor.enums.GeneralEnums.NOMEN_NESCIO;

@Data
@SessionScoped
@AllArgsConstructor
@ManagedBean(name = "login", eager = true)
public class LoginController implements Serializable {

    private String email;
    private String password;
    private LoginService loginService;
    private Student currentStudent;

    public LoginController() {
        DatabaseConnection.getInstance();
        this.loginService = new LoginService();
    }

    public String checkLoginDetails() {
        Optional<Student> student = loginService.findStudentByEmialAndPassword(email, StringUtil.convertMD5(password));
        if (!student.isPresent()) {
            ExceptionFactory.incorrectLoginData();
            return "";
        }
        currentStudent = student.get();
        return "standard";
    }

    public String personalData() {
        Optional<Student> student = loginService.findStudentByEmail(email);
        return student.isPresent() ? getFullName(student.get()) : NOMEN_NESCIO.getValue();
    }

    private String getFullName(Student student) {
        String name = student.getName();
        String lastName = student.getLastName();
        return name + EMPTY_STRING.getValue() + lastName;
    }
}
