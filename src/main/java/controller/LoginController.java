package controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@Data
@SessionScoped
@NoArgsConstructor
@AllArgsConstructor
@ManagedBean(name = "login", eager = true)
public class LoginController implements Serializable {

    private String email;
    private String password;

    public String checkLoginDetails() {
        // not implemented  yet
        return "index";
    }
}
