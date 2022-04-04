package pl.sidor.controller;

import com.google.common.base.Optional;
import lombok.*;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import pl.sidor.entity.general.Student;
import pl.sidor.exception.ExceptionFactory;
import pl.sidor.service.LoginService;
import pl.sidor.utils.StringUtil;
import pl.sidor.validation.LoginValidation;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static pl.sidor.enums.GeneralEnums.EMPTY_STRING;
import static pl.sidor.enums.GeneralEnums.NOMEN_NESCIO;

@Data
@SessionScoped
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ManagedBean(name = "login", eager = true)
public class LoginController implements Serializable {

    private static final long serialVersionUID = -4064692950061635325L;
    protected final static Logger log = LoggerFactory.logger(LoginController.class);

    private static final String BLANK_STRING = "";
    private static final String STANDARD_PAGE = "/modules/standard.xhtml?faces-redirect=true";
    private static final String CONTENT_TYPE = "image/jpg";
    public static final String IMAGE_LOCATION = "C:/image/";

    private String email;
    private String password;
    private LoginService loginService;
    private LoginValidation loginValidation;
    private Student currentStudent;
    private DefaultStreamedContent image;

    @PostConstruct
    public void init() {
        this.loginService = new LoginService();
        this.loginValidation = new LoginValidation();
    }

    /**
     * The method checks the login credentials and redirects to the user's website
     * @return User's website address or login address
     */
    public String checkLoginDetails() {
        if (loginValidation.validateLoginData(email, password)) {
            ExceptionFactory.requiredLoginData();
            return BLANK_STRING;
        }
        Optional<Student> student = loginService.findStudentByEmialAndPassword(email, StringUtil.convertMD5(password));

        if (!student.isPresent()) {
            ExceptionFactory.incorrectLoginData();
            return BLANK_STRING;
        }
        prepareStudentData(student.get());
        return STANDARD_PAGE;
    }

    /**
     * Method get student personal data
     * @return Basic student data
     */
    public String personalData() {
        Optional<Student> student = loginService.findStudentByEmail(email);
        return student.isPresent() ? getFullName(student.get()) : NOMEN_NESCIO.getValue();
    }

    /**
     * Method loads a photo from the disk
     * @return Instance StreamedContent
     */
    public StreamedContent getPhoto() {
        try {
            String photoName = currentStudent.getEmail() + ".jpg";
            Path path = Paths.get(IMAGE_LOCATION + photoName);
            byte[] data = Files.readAllBytes(path);
            image = new DefaultStreamedContent(new ByteArrayInputStream(data), CONTENT_TYPE, photoName);
        } catch (IOException ex) {
            log.error("There was an error loading the photo");
            image = getDefaultImage();
        }
        return image;
    }

    /**
     * Method combines the first and last name into one object
     * @param student
     * @return Student fullname
     */
    private String getFullName(Student student) {
        String name = student.getName();
        String lastName = student.getLastName();
        return name + EMPTY_STRING.getValue() + lastName;
    }

    /**
     *  Method prepares the student's data
     * @param student
     */
    @SneakyThrows
    private void prepareStudentData(Student student) {
        this.currentStudent = student;
        if (currentStudent != null && currentStudent.getData() != null) {
            InputStream inputStream = new ByteArrayInputStream(currentStudent.getData());
            image = new DefaultStreamedContent(inputStream, CONTENT_TYPE);
        }
    }

    //TODO Zrealizować wczytywanie domyślengo obrazu
    private DefaultStreamedContent getDefaultImage() {
        return null;
    }
}
