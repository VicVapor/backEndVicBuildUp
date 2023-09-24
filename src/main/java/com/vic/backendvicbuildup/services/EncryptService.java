package com.vic.backendvicbuildup.services;

import com.vic.backendvicbuildup.repositories.EncryptRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptService implements EncryptRepository {

    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public boolean verifyPassword(String originalPassword, String hashPassword) {
        return false;
    }
}
