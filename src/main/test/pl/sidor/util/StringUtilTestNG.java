package pl.sidor.util;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class StringUtilTestNG {

    @Test
    public void testConvertMD5() {
        // given:
        String password = "password";

        // when:
        String encryptedPassword = StringUtil.convertMD5(password);

        // then:
        assertNotNull(encryptedPassword);
        assertEquals(encryptedPassword.length(), 32);
        assertEquals(encryptedPassword, StringUtil.convertMD5(password));
    }
}