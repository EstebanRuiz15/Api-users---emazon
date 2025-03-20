package com.emazon.api_users.infraestructure.security_config;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.emazon.api_users.infraestructure.util.ConstantsInfra;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request, 
                         HttpServletResponse response,
                       AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.write(ConstantsInfra.ACCES_DENIED_MESSAGE+ authException.getMessage() + "\"}");
        writer.flush();
     }
    
   
    
}
