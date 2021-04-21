package pl.sidor.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidation {

    /** Pattern for the email address */
    private static final String REGEX = "^.+@.+\\..+$";

    /**
     * Method validate login data
     * @param email
     * @param password
     * @return is login data correct
     */
    public boolean validateLoginData(String email, String password) {
        return email.isEmpty() || password.isEmpty() || isEmailIncorrect(email);
    }

    /**
     * Method checks if the email matches the pattern
     * @param  email
     * @return is Email incorrect
     */
    private boolean isEmailIncorrect(String email) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
}
