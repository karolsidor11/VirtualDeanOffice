package pl.sidor.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static pl.sidor.exception.MessageException.PASSWORD_ENCRYPTION_ERROR;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringUtil {

    protected final static Logger log = LoggerFactory.logger(StringUtil.class);

    private static final String ALGORITHM_MD = "MD5";
    private static final String ZERO = "0";
    private static final int MIN_SIGNUM = 1;
    private static final int MAX_RADIX = 16;
    private static final int MAX_LENGTH = 31;

    /**
     * Method of encrypting the user's password
     *
     * @param password
     * @return Encrypted password
     */
    public static String convertMD5(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_MD);
            messageDigest.update(password.getBytes());
            BigInteger number = new BigInteger(MIN_SIGNUM, messageDigest.digest());
            String encryptedPassword = number.toString(MAX_RADIX);
            if (encryptedPassword.length() == MAX_LENGTH)
                encryptedPassword = ZERO + encryptedPassword;

            return encryptedPassword;

        } catch (NoSuchAlgorithmException e) {
            log.error(PASSWORD_ENCRYPTION_ERROR);
            throw new RuntimeException(PASSWORD_ENCRYPTION_ERROR.getMessage());
        }
    }
}
