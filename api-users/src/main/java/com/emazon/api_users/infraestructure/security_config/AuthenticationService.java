package com.emazon.api_users.infraestructure.security_config;

import org.springframework.stereotype.Service;

import com.emazon.api_users.aplication.exceptions.ErrorNotAuthenticated;
import com.emazon.api_users.domain.interfaces.IUserRepositoryPort;
import com.emazon.api_users.domain.model.User;
import com.emazon.api_users.infraestructure.driving_http.dtos.security.AuthenticationRequest;
import com.emazon.api_users.infraestructure.driving_http.dtos.security.AuthenticationResponse;
import com.emazon.api_users.infraestructure.security_config.jwt_configuration.JwtService;
import com.emazon.api_users.infraestructure.util.ConstantsInfra;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IUserRepositoryPort repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try{
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = repository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generate(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }catch(AuthenticationException e) {
                throw new ErrorNotAuthenticated(ConstantsInfra.ERROR_MESSAGE_UNAUTHORIZED);
            }
    }
}
