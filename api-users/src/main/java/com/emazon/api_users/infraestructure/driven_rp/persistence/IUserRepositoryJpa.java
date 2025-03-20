package com.emazon.api_users.infraestructure.driven_rp.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emazon.api_users.infraestructure.driven_rp.entity.UserEntity;
public interface IUserRepositoryJpa extends JpaRepository<UserEntity,Integer>{

    Optional<UserEntity> findByEmail(String email);
    
}
