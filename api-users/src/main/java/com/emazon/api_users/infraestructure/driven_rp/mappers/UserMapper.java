package com.emazon.api_users.infraestructure.driven_rp.mappers;



import org.mapstruct.Mapper;

import com.emazon.api_users.domain.model.User;
import com.emazon.api_users.infraestructure.driven_rp.entity.UserEntity;

@Mapper(componentModel="spring")
public interface UserMapper {
    UserEntity toEntity(User user);
    User toUser(UserEntity userEntity);
}
