package org.bitbucket.controllers;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.payload.Token;

import java.util.Date;

public class UserControllers {

    public Token auth(UserAuthorizationDto payload) {
        return new Token(1L, "Test", "Test", new Date(), new Date());
    }
}
