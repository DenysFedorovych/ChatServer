package org.bitbucket.controllers;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.payload.Token;
import org.bitbucket.service.CustomUsersService;

import java.util.Date;

public class UserControllers {

    private final CustomUsersService customUsersService;

    public UserControllers(CustomUsersService customUsersService) {
        this.customUsersService = customUsersService;
    }

    public Token auth(UserAuthorizationDto payload){
        return new Token(1L,"First Name","Last Name",new Date(),new Date());
    }

    public void registration(UserRegistrationDto userRegistrationDto) {

    }
}
