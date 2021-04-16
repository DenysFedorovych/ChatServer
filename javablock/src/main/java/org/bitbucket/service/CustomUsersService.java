package org.bitbucket.service;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;
import org.bitbucket.repository.UsersRepository;

public class CustomUsersService implements IUserService {

    private final UsersRepository usersRepository;

    public CustomUsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public User findByAuth(UserAuthorizationDto auth) {
        return null;
    }

    @Override
    public User insert(UserRegistrationDto userRegistrationDto) {
        return null;
    }

    @Override
    public void delete(UserRegistrationDto userRegistrationDto) {

    }

    @Override
    public void update(UserRegistrationDto userRegistrationDto) {

    }
}
