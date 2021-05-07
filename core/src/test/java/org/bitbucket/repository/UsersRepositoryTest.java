package org.bitbucket.repository;

import org.bitbucket.config.DatabaseConfig;
import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;
import org.junit.Assert;
import org.junit.Test;

public class UsersRepositoryTest {

    private UsersRepository repo = DatabaseConfig.getUsersRepository();

    private UserRegistrationDto userRegistrationDto = new UserRegistrationDto("Denys", "Fedorovych", "login","nickname", "password", "password","email", "+22222222");
    private UserAuthorizationDto userAuthorizationDto = new UserAuthorizationDto("login","password");
    private User user1 = new User(1,"Denys", "Fedorovych","email","login","nickname","password", "+22222222");
    private User user = new User(1, "Denys", "Fedorovych","email", "login", "nickname","password", "+22222222");
    private UserRegistrationDto userRegistrationDto1 = new UserRegistrationDto(user1);

    @Test
    public void findByAuthDto() {
        repo.insert(userRegistrationDto);
        Assert.assertEquals(new UserRegistrationDto(user), new UserRegistrationDto(repo.findByAuthDto(userAuthorizationDto)));
        repo.delete(userRegistrationDto);
    }

    @Test
    public void insertAndDelete() {
        repo.insert(userRegistrationDto);
        repo.delete(userRegistrationDto);
        Assert.assertEquals(null, repo.findByAuthDto(userAuthorizationDto));
    }

    @Test
    public void update() {
        repo.insert(userRegistrationDto);
        repo.update(userRegistrationDto1);
        Assert.assertEquals(userRegistrationDto1, new UserRegistrationDto(repo.findByAuthDto(new UserAuthorizationDto(userRegistrationDto1))));
        repo.delete(userRegistrationDto1);
    }
}