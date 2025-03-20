package com.emazon.api_users.Auxiliar;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.emazon.api_users.domain.interfaces.IUserRepositoryPort;
import com.emazon.api_users.domain.model.RoleEnum;
import com.emazon.api_users.domain.model.User;

class UserRepositoryPortTest {

    @Mock
    private IUserRepositoryPort userRepositoryPort;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(
                1L,
                "John",
                "Doe",
                "1234567890",
                "0998765432",
                LocalDate.of(1990, 1, 1),
                "john.doe@example.com",
                "Password123",
                RoleEnum.ADMIN);
    }

    @Test
    void testSaveUser() {
        // Act
        userRepositoryPort.saveUser(user);

        // Assert
        verify(userRepositoryPort).saveUser(user);
    }

    @Test
    void testFindByEmail_UserExists() {
        // Arrange
        when(userRepositoryPort.findByEmail("john.doe@example.com")).thenReturn(Optional.of(user));

        // Act
        Optional<User> foundUser = userRepositoryPort.findByEmail("john.doe@example.com");

        // Assert
        assertTrue(foundUser.isPresent());
        assertEquals(user.getEmail(), foundUser.get().getEmail());
        assertEquals(user.getName(), foundUser.get().getName());
        assertEquals(user.getRole(), foundUser.get().getRole());
    }

    @Test
    void testFindByEmail_UserDoesNotExist() {
        // Arrange
        when(userRepositoryPort.findByEmail("non.existent@example.com")).thenReturn(Optional.empty());

        // Act
        Optional<User> foundUser = userRepositoryPort.findByEmail("non.existent@example.com");

        // Assert
        assertTrue(foundUser.isEmpty());
    }
}