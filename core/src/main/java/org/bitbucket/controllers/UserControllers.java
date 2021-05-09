package org.bitbucket.controllers;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;
import org.bitbucket.exceptions.UserAlreadyExistException;
import org.bitbucket.payload.Token;
import org.bitbucket.service.UsersService;
import org.bitbucket.utils.TokenProvider;

public class UserControllers {

    private final UsersService usersService;

    public UserControllers(UsersService customUsersService) {
        this.usersService = customUsersService;
    }

    public String auth(UserAuthorizationDto payload) {
        User user = this.usersService.findByAuth(payload);
        return TokenProvider.encode(new Token(user));
    }

    public void registration(UserRegistrationDto userRegistrationDto) {
        //User u = TransferObj.toUser(payload);
        if (this.usersService.findByAuth(new UserAuthorizationDto(userRegistrationDto)) != null) {
            throw new UserAlreadyExistException();
        }
        //customUsersService.insert(u);
        usersService.insert(userRegistrationDto);
    }
}
