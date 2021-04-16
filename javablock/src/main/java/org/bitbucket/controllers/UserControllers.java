package org.bitbucket.controllers;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.payload.Token;

import java.util.Date;

public class UserControllers {
    public Token auth(UserAuthorizationDto payload){
        return new Token(1L,"First Name","Last Name",new Date(),new Date());
    }
}
