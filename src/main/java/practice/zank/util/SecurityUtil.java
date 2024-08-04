package practice.zank.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtil {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public static String getPassWord(String password) {
        return ENCODER.encode(password);
    }

    public static boolean matches(String password, String encodePassword) {
        return ENCODER.matches(password, encodePassword);
    }
}
