package com.emazon.api_users.infraestructure.driven_rp.adapter;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.emazon.api_users.domain.interfaces.IEncoderPort;
import com.emazon.api_users.domain.interfaces.IUserRepositoryPort;
import com.emazon.api_users.domain.model.User;
import com.emazon.api_users.infraestructure.driven_rp.mappers.UserMapper;
import com.emazon.api_users.infraestructure.driven_rp.persistence.IUserRepositoryJpa;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserRepositoryImpl implements IUserRepositoryPort {
    private final IUserRepositoryJpa repositoryJpa;
    private final UserMapper mapper;
    private final IEncoderPort encoderPort;

    @Override
    public void saveUser(User user) {
        String encryptedPassword = encoderPort.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        repositoryJpa.save(mapper.toEntity(user));

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repositoryJpa.findByEmail(email)
                .map(mapper::toUser);
    }

}
