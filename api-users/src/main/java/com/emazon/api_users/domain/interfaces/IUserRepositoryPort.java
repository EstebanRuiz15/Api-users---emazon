package com.emazon.api_users.domain.interfaces;

import java.util.Optional;

import com.emazon.api_users.domain.model.User;

public interface IUserRepositoryPort {
    
    void saveUser(User user);
    Optional<User> findByEmail(String email);
}
