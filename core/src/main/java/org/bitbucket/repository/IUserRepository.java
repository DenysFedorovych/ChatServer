package org.bitbucket.repository;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;

import java.util.Collection;

public interface IUserRepository<T> {

    Collection<T> findAll();

    User findAuth(UserAuthorizationDto userAuthorizationDto);

    User findReg(UserRegistrationDto userRegistrationDto);

    User insert(UserRegistrationDto userRegistrationDto);

    User update(User user);

    void delete(User user);

    void deleteAll();
}
