package app.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderConfig {
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
