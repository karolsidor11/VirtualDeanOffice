package pl.sidor.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionFactory {

    /**
     * Method generate a login error message
     */
    public static void incorrectLoginData() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, MessageException.INCORRECT_LOGIN_DATA.getMessage(), null);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
    }

    /**
     * Method generate a message about the lack of login data
     */
    public static void requiredLoginData() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, MessageException.REQUIRED_LOGIN_DATA.getMessage(), null);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
    }
}
