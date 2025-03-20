package com.emazon.api_users.infraestructure.driving_http.dtos.security;

import com.emazon.api_users.infraestructure.util.ConstantsInfra;

import jakarta.validation.constraints.NotBlank;

public class AuthenticationRequest {

    @NotBlank(message= ConstantsInfra.ERROR_EMAIL_NULL)
    private String email;
    @NotBlank(message = ConstantsInfra.ERROR_PASSWORD_NULL)
    private String password;
    public AuthenticationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public AuthenticationRequest() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
