package com.emazon.api_users.domain.interfaces;

public interface IEncoderPort {
    
	boolean matches(CharSequence rawPassword, String encodedPassword);
    String encode(CharSequence rawPassword);
}
