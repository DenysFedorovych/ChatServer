package org.bitbucket.service;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;

public interface IUserService {

    User findById(long id);

    User findByAuth(UserAuthorizationDto auth);

    User insert(UserRegistrationDto userRegistrationDto);

    void delete(UserRegistrationDto userRegistrationDto);

    void update(UserRegistrationDto userRegistrationDto);

}
