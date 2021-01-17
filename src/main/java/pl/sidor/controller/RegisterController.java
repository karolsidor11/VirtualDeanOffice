package pl.sidor.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.sidor.entity.general.Student;
import pl.sidor.service.RegisterService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Data
@SessionScoped
@AllArgsConstructor
@ManagedBean(name = "register", eager = true)
public class RegisterController implements Serializable {

    private Student student;
    private RegisterService registerService;

    public RegisterController() {
        this.registerService = new RegisterService();
    }

    public String register() {
        registerService.registerStudent(student);
        return "register";
    }
}
