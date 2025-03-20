package com.emazon.api_users.Auxiliar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.emazon.api_users.domain.model.RoleEnum;
import com.emazon.api_users.domain.model.User;
import com.emazon.api_users.domain.util.ConstantsDomain;

class UserModelTest {

    private User user;

    @BeforeEach
    public void setUp() {
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
    void testGetters() {
        assertEquals(1L, user.getId());
        assertEquals("John", user.getName());
        assertEquals("Doe", user.getLastName());
        assertEquals("1234567890", user.getIdDocument());
        assertEquals("0998765432", user.getCelular());
        assertEquals(LocalDate.of(1990, 1, 1), user.getDateOfBirth());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("Password123", user.getPassword());
        assertEquals(RoleEnum.ADMIN, user.getRole());
    }

    @Test
    void testSetters() {
        user.setName("Jane");
        user.setLastName("Smith");
        user.setIdDocument("0987654321");
        user.setCelular("0998765433");
        user.setEmail("jane.smith@example.com");
        user.setPassword("NewPassword123");
        user.setRole(RoleEnum.CLIENT);

        assertEquals("Jane", user.getName());
        assertEquals("Smith", user.getLastName());
        assertEquals("0987654321", user.getIdDocument());
        assertEquals("0998765433", user.getCelular());
        assertEquals("jane.smith@example.com", user.getEmail());
        assertEquals("NewPassword123", user.getPassword());
        assertEquals(RoleEnum.CLIENT, user.getRole());
    }

    @Test
    void testGetAuthorities() {
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        assertEquals(1, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority(ConstantsDomain.ROLE + "ADMIN")));
    }

    @Test
    void testGetUsername() {
        assertEquals("john.doe@example.com", user.getUsername());
    }

    @Test
    void testIsAccountNonExpired() {
        assertTrue(user.isAccountNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        assertTrue(user.isAccountNonLocked());
    }

    @Test
    void testIsCredentialsNonExpired() {
        assertTrue(user.isCredentialsNonExpired());
    }

    @Test
    void testIsEnabled() {
        assertTrue(user.isEnabled());
    }


}
