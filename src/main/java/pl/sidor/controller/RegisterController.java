package pl.sidor.controller;

import lombok.*;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import pl.sidor.entity.embeded.Address;
import pl.sidor.entity.general.Student;
import pl.sidor.service.RegisterService;
import pl.sidor.utils.GeneralUtil;
import pl.sidor.utils.StringUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

@Data
@SessionScoped
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ManagedBean(name = "register", eager = true)
public class RegisterController implements Serializable {

    private static final long serialVersionUID = 1344377299496514702L;
    protected final static Logger log = LoggerFactory.logger(RegisterController.class);

    private static final String CONFIRM_PAGE = "/modules/confirm.xhtml?faces-redirect=true";
    private static final String REGISTER_PAGE = "/modules/register.xhtml?faces-redirect=true";
    private static final String MAIN_PAGE = "/modules/index.xhtml?faces-redirect=true";
    public static final String IMAGE_LOCATION = "C:/image/";

    private Student student;
    private Address address;
    private RegisterService registerService;
    private UploadedFile file;

    @PostConstruct
    public void init() {
        this.student = new Student();
        this.address = new Address();
        this.registerService = new RegisterService();
    }

    /**
     * Method get a list of sorted countries
     *
     * @return List  countries
     */
    public List<String> getAllCountries() {
        return GeneralUtil.getAllCountries();
    }

    /**
     * Method registers the student
     *
     * @return Registration confirmation url
     */
    public String confirmRegister() {
        encryptPassword();
        student.setAddres(address);
        registerService.registerStudent(student);
        saveImge(student);

        return CONFIRM_PAGE;
    }

    /**
     * Method set a image student
     *
     * @param event
     */
    public void upload(FileUploadEvent event) {
        if (event != null) {
            student.setData(event.getFile().getContents());
            FacesMessage message = new FacesMessage("Załadowano", event.getFile().getFileName() + " zdjecie.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    /**
     * Method redirect to register form
     *
     * @return Register page url
     */
    public String backToForm() {
        student.setPassword("");
        return REGISTER_PAGE;
    }

    /**
     * Method redirect to register form
     *
     * @return Login page url
     */
    public String cleanFormAndRedirect() {
        this.student = new Student();
        this.address = new Address();
        return MAIN_PAGE;
    }

    /**
     * Method set and encrypting the user's password
     */
    private void encryptPassword() {
        student.setPassword(StringUtil.convertMD5(student.getPassword()));
    }

    /**
     * Method  saves the student's image to disk
     * @param student
     */
    @SneakyThrows
    private void saveImge(Student student) {
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(student.getData()));
        if (image != null) {
            createDictionaryIfNotExists();
            ImageIO.write(image, "JPG", new File(IMAGE_LOCATION + student.getEmail() + ".jpg"));
        }
    }

    /**
     * Method create dictionary if not exists
     */
    private void createDictionaryIfNotExists() {
        File file = new File(IMAGE_LOCATION);
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
