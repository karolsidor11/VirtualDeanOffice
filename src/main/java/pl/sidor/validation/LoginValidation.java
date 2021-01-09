package pl.sidor.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidation {

    public boolean validateLoginData(String email, String password) {
        return email.isEmpty() || password.isEmpty() || isEmailIncorrect(email);
    }

    private boolean isEmailIncorrect(String email) {
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
}
