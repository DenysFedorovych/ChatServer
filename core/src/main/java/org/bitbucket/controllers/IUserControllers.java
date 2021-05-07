package org.bitbucket.controllers;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;

public interface IUserControllers {

    String authorize(UserAuthorizationDto userAuthorizationDto);

    void registration(UserRegistrationDto userRegistrationDto);
}
