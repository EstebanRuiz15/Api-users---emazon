package com.emazon.api_users.domain.interfaces;

import com.emazon.api_users.domain.model.User;

public interface IUserService {

    void createUserAuxBod(User user);
    void createUserClient(User user);
} 
