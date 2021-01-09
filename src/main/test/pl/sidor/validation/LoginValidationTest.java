package pl.sidor.validation;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class LoginValidationTest {

    private LoginValidation loginValidation;

    @Before
    public void setUp() throws Exception {
        loginValidation = new LoginValidation();
    }

    @Test
    @Parameters({
            "jan, DSA234, true",
            "jan_wp.pl, DSA234, true",
            "jan, DSA234, true",
            "jan@wp.pl, WSDA123, false"})
    public void shouldValidateEmail(String email, String password, boolean result) {
        boolean actualResult = loginValidation.validateLoginData(email, password);
        assertEquals(actualResult, result);
    }
}