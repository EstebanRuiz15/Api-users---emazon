package com.emazon.api_users.domain.services;

import java.time.LocalDate;
import java.time.Period;
import com.emazon.api_users.domain.exceptions.ErrorExceptionParam;
import com.emazon.api_users.domain.interfaces.IUserRepositoryPort;
import com.emazon.api_users.domain.interfaces.IUserService;
import com.emazon.api_users.domain.model.RoleEnum;
import com.emazon.api_users.domain.model.User;
import com.emazon.api_users.domain.util.ConstantsDomain;

public class UserServiceImpl implements IUserService {
    private final IUserRepositoryPort repositoryPort;

    public UserServiceImpl(IUserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public void createUserAuxBod(User user) {

        if (repositoryPort.findByEmail(user.getEmail()).isPresent()) {
            throw new ErrorExceptionParam(ConstantsDomain.EMAIL_AL_READY_EXIST_ERROR_MESSAGE);
        }

        if (Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() < ConstantsDomain.AGE_MAY) {
            throw new ErrorExceptionParam(ConstantsDomain.AGE_MAY_ERROR);
        }

        user.setRole(RoleEnum.AUX_BODEGA);

        repositoryPort.saveUser(user);
    }

    @Override
    public void createUserClient(User user){
        if (repositoryPort.findByEmail(user.getEmail()).isPresent()) {
            throw new ErrorExceptionParam(ConstantsDomain.EMAIL_AL_READY_EXIST_ERROR_MESSAGE);
        }

        if (Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() < ConstantsDomain.AGE_MAY) {
            throw new ErrorExceptionParam(ConstantsDomain.AGE_MAY_ERROR);
        }

        user.setRole(RoleEnum.CLIENT);

        repositoryPort.saveUser(user);

    }

   

}
