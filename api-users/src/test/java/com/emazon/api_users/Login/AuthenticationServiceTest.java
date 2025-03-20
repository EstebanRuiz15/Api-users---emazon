package com.emazon.api_users.Login;

import com.emazon.api_users.aplication.exceptions.ErrorNotAuthenticated;
import com.emazon.api_users.domain.interfaces.IUserRepositoryPort;
import com.emazon.api_users.domain.model.RoleEnum;
import com.emazon.api_users.domain.model.User;
import com.emazon.api_users.infraestructure.driving_http.dtos.security.AuthenticationRequest;
import com.emazon.api_users.infraestructure.driving_http.dtos.security.AuthenticationResponse;
import com.emazon.api_users.infraestructure.security_config.AuthenticationService;
import com.emazon.api_users.infraestructure.security_config.jwt_configuration.JwtService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

class AuthenticationServiceTest {

    @InjectMocks
    private AuthenticationService authenticationService;

    @Mock
    private IUserRepositoryPort repository;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authenticate_ValidRequest_ReturnsToken() {
        // Arrange
        AuthenticationRequest request = new AuthenticationRequest("user@example.com", "password");
        User user = new User(1L,
                "John",
                "Doe",
                "1234567890",
                "0998765432",
                LocalDate.of(1990, 1, 1),
                "john.doe@example.com",
                "Password123",
                RoleEnum.ADMIN);
        String token = "jwtToken";

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(null);
        when(repository.findByEmail(anyString())).thenReturn(java.util.Optional.of(user));
        when(jwtService.generate(user)).thenReturn(token);

        // Act
        AuthenticationResponse response = authenticationService.authenticate(request);

        // Assert
        assertEquals(token, response.getToken());
    }

    @Test
    void authenticate_InvalidCredentials_ThrowsErrorNotAuthenticated() {
        // Arrange
        AuthenticationRequest request = new AuthenticationRequest("user@example.com", "wrongPassword");

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
        .thenThrow(new AuthenticationException("Invalid credentials") {});

        // Act & Assert
        assertThrows(ErrorNotAuthenticated.class, () -> authenticationService.authenticate(request));
    }

}