package org.bitbucket.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;
import org.bitbucket.micro.orm.CustomJdbcTemplate;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersRepositoryTest {

    private HikariConfig hikariConfig = new HikariConfig("src/main/resources/hikari.properties");
    private HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
    private UsersRepository repo = new UsersRepository(new CustomJdbcTemplate(hikariDataSource));

    private UserRegistrationDto userRegistrationDto = new UserRegistrationDto("Denys", "Fedorovych", "login", "password", "password","email", "+22222222");
    private UserAuthorizationDto userAuthorizationDto = new UserAuthorizationDto("ffff","ffff");
    private UserAuthorizationDto userAuthorizationDto1 = new UserAuthorizationDto("login","password");
    private User user = new User(1,"Denys","Fedorovych","ffff","ffff","ffff","ffff");
    private User user1 = new User(1, "Denys", "Fedorovych", "login", "password","email", "+22222222");

    @Test
    public void findByAuthDto() {
        Assert.assertEquals(user, repo.findByAuthDto(userAuthorizationDto));
    }

    @Test
    public void findById() {
        Assert.assertEquals(user, repo.findById(1));
    }

    @Test
    public void insert() {
        repo.insert(userRegistrationDto);
        Assert.assertEquals(user1, repo.findByAuthDto(userAuthorizationDto1));
    }

    @Test
    public void delete() {
        repo.delete(userRegistrationDto);
        Assert.assertEquals(null, repo.findByAuthDto(userAuthorizationDto1));
    }

    @Test
    public void update() {
        repo.update(new UserRegistrationDto("Denys", "Fedorovych", "login", "password", "password","email", "+3333333"));
    }
}