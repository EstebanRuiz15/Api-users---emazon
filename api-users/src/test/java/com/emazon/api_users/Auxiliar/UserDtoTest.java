package com.emazon.api_users.Auxiliar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.emazon.api_users.infraestructure.driving_http.dtos.UserDtoAdd;
import com.emazon.api_users.infraestructure.util.ConstantsInfra;

 class UserDtoTest {
    private static Validator validator;

    @BeforeAll
     static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenValidUser_thenNoViolations() {
        UserDtoAdd userDto = new UserDtoAdd(
                null,
                "John",
                "Doe",
                "1234567890",
                "0998765432",
                LocalDate.of(1990, 1, 1),
                "john.doe@example.com",
                "Password123",
                null
        );

        Set<ConstraintViolation<UserDtoAdd>> violations = validator.validate(userDto);

        assertTrue(violations.isEmpty(), "No debería haber violaciones de restricciones");
    }

    @Test
   void whenNameIsBlank_thenViolationOccurs() {
        UserDtoAdd userDto = new UserDtoAdd(
                null,
                "", // Nombre en blanco
                "Doe",
                "1234567890",
                "0998765432",
                LocalDate.of(1990, 1, 1),
                "john.doe@example.com",
                "Password123",
                null
        );

        Set<ConstraintViolation<UserDtoAdd>> violations = validator.validate(userDto);
        
        assertFalse(violations.isEmpty());
        assertEquals(ConstantsInfra.ERROR_NAME_NULL, violations.iterator().next().getMessage());
    }

    @Test
    void whenEmailIsInvalid_thenViolationOccurs() {
        UserDtoAdd userDto = new UserDtoAdd(
                null,
                "John",
                "Doe",
                "1234567890",
                "0998765432",
                LocalDate.of(1990, 1, 1),
                "invalid-email", // Email no válido
                "Password123",
                null
        );

        Set<ConstraintViolation<UserDtoAdd>> violations = validator.validate(userDto);
        
        assertFalse(violations.isEmpty());
        assertEquals(ConstantsInfra.ERROR_EMAIL_INCORRECT, violations.iterator().next().getMessage());
    }

    @Test
    void whenDateOfBirthIsInFuture_thenViolationOccurs() {
        UserDtoAdd userDto = new UserDtoAdd(
                null,
                "John",
                "Doe",
                "1234567890",
                "0998765432",
                LocalDate.of(2050, 1, 1), // Fecha futura
                "john.doe@example.com",
                "Password123",
                null
        );

        Set<ConstraintViolation<UserDtoAdd>> violations = validator.validate(userDto);
        
        assertFalse(violations.isEmpty());
        assertEquals(ConstantsInfra.ERROR_DATE_INVALID, violations.iterator().next().getMessage());
    }

    @Test
    void whenPasswordIsInvalid_thenViolationOccurs() {
        UserDtoAdd userDto = new UserDtoAdd(
                null,
                "John",
                "Doe",
                "1234567890",
                "0998765432",
                LocalDate.of(1990, 1, 1),
                "john.doe@example.com",
                "pass", // Contraseña no válida
                null
        );

        Set<ConstraintViolation<UserDtoAdd>> violations = validator.validate(userDto);

        assertFalse(violations.isEmpty());
        assertEquals(ConstantsInfra.ERROR_PASSWORD_INCORRECT, violations.iterator().next().getMessage());
    }
}
