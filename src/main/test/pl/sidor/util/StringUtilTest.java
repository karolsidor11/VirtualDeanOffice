package pl.sidor.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StringUtilTest {

    @Test
    public void convertMD5() {
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