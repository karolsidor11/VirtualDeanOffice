package pl.sidor.controller;

import com.google.common.base.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import pl.sidor.connection.DatabaseConnection;
import pl.sidor.entity.general.Student;
import pl.sidor.service.LoginService;
import pl.sidor.util.StringUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Data
@SessionScoped
@AllArgsConstructor
@ManagedBean(name = "login", eager = true)
public class LoginController implements Serializable {

    private String email;
    private String password;
    private LoginService loginService;

    public LoginController() {
        DatabaseConnection.getInstance();
        this.loginService = new LoginService();
    }

    public String checkLoginDetails() {
        Optional<Student> student = loginService.findStudentByEmialAndPassword(email, StringUtil.convertMD5(password));
        if (!student.isPresent()) {
            return "";
        }
        return "standard";
    }
}
