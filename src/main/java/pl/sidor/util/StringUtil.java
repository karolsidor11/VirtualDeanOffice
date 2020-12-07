package pl.sidor.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtil {

    public static String convertMD5(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest.digest());
            String encryptedPassword = number.toString(16);
            if (encryptedPassword.length() == 31)
                encryptedPassword = "0" + encryptedPassword;

            return encryptedPassword;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("Błąd przy szyfrowaniu hasła.");
        }
    }
}
