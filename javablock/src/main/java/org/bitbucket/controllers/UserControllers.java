package org.bitbucket.controllers;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;
import org.bitbucket.payload.Token;
import org.bitbucket.service.IUserService;
import org.bitbucket.utils.TokenProvider;

import java.util.Date;

public class UserControllers implements IUserControllers {

    IUserService userService;


    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

//    public Token auth(UserAuthorizationDto payload){
//        return new Token(1L,"First Name","Last Name",new Date(),new Date());
//    }

    @Override
    public String authorize(UserAuthorizationDto userAuthorizationDto) {
        User user = new User();
        Token token = new Token(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                new Date(System.currentTimeMillis() + 1000000),
                new Date());
        return TokenProvider.encoding(token);
    }

    @Override
    public void registration(UserRegistrationDto userRegistrationDto) {
        //this.userService.insert(userDto)
    }
}
