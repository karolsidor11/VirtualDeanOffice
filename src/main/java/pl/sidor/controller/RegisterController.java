package pl.sidor.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sidor.entity.embeded.Adres;
import pl.sidor.entity.general.Student;
import pl.sidor.service.RegisterService;
import pl.sidor.util.StringUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.*;

@Data
@SessionScoped
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean(name = "register", eager = true)
public class RegisterController implements Serializable {

    private Student student = new Student();
    private Adres adres = new Adres();
    private RegisterService registerService;

    @PostConstruct
    public void  init(){
        this.registerService = new RegisterService();
        student.setAddres(adres);
    }

    public List<String> getAllCountries() {
        List<String> country = new ArrayList<>();
        for (String countryCode : Locale.getISOCountries()) {
            Locale obj = new Locale("", countryCode);
            country.add(obj.getDisplayCountry());
        }
        Collections.sort(country);
        return country;
    }

    public String confirmRegister() {
        encryptPassword();
        registerService.registerStudent(student);
        return "/modules/confirm.xhtml?faces-redirect=true";
    }

    public String backToForm() {
        student.setPassword("");
        return "/modules/register.xhtml?faces-redirect=true";
    }

    private void encryptPassword() {
        student.setPassword(StringUtil.convertMD5(student.getPassword()));
    }
}
