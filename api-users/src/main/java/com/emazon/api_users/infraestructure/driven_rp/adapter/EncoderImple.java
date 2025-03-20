package com.emazon.api_users.infraestructure.driven_rp.adapter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emazon.api_users.domain.interfaces.IEncoderPort;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EncoderImple implements IEncoderPort{
    
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

     return false;
    }
    @Override
    public String encode(CharSequence rawPassword) {
       String password= passwordEncoder.encode(rawPassword);
        return password;
    }

    
}
