package codegym2019.casestudy_2019.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrypPasswordUtils {
    public static String EncrypPasswordUtils(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        System.out.println(EncrypPasswordUtils("123"));
    }
}
