package pl.sidor.validation;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginValidationTestNG {

    private LoginValidation loginValidation;

    @BeforeMethod
    public void setUp() {
        loginValidation = new LoginValidation();
    }

    @Test
    public void testValidateLoginDataFalse() {
        // given:
        String email = "jan@wp.pl";
        String password = "password";
        // when:
        boolean result = loginValidation.validateLoginData(email, password);
        // then:
        AssertJUnit.assertFalse(result);
    }

    @Test
    public void testValidateLoginDataTrue() {
        // given:
        String email = "jan_wp.pl";
        String password = "password";
        // when:
        boolean result = loginValidation.validateLoginData(email, password);
        // then:
        AssertJUnit.assertTrue(result);
    }
}