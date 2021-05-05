package org.bitbucket.controllers;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;
import org.bitbucket.exceptions.UserAlreadyExistException;
import org.bitbucket.payload.Token;
import org.bitbucket.service.CustomUsersService;
import org.bitbucket.utils.TokenProvider;

public class UserControllers {

    private final CustomUsersService customUsersService;

    public UserControllers(CustomUsersService customUsersService) {
        this.customUsersService = customUsersService;
    }

    public String auth(UserAuthorizationDto payload) {
        User user = this.customUsersService.findByAuth(payload);
        return TokenProvider.encode(new Token(user));
    }

    public void registration(UserRegistrationDto userRegistrationDto) {
        //User u = TransferObj.toUser(payload);
        if (this.customUsersService.findByAuth(new UserAuthorizationDto(userRegistrationDto)) != null) {
            throw new UserAlreadyExistException();
        }
        //customUsersService.insert(u);
        customUsersService.insert(userRegistrationDto);
    }
}
