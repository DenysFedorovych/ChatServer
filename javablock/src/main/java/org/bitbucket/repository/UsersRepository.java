package org.bitbucket.repository;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;
import org.bitbucket.micro.orm.CustomJdbcTemplate;

public class UsersRepository {

    private final CustomJdbcTemplate jdbcTemplate;

    public UsersRepository(CustomJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findByAuthDto(UserAuthorizationDto userAuthorizationDto){
        return jdbcTemplate.findBy(
                "SELECT * FROM users WHERE login = ? AND password = ?",
                RowMapper.getCustomRowMapperUser(),
                userAuthorizationDto.getLogin(),
                userAuthorizationDto.getPassword()
        );
    }

    public User findById(long id){
        return jdbcTemplate.findBy(
                "SELECT * FROM users WHERE id = ?",
                RowMapper.getCustomRowMapperUser(),
                id
        );
    }

    public User insert(UserRegistrationDto userRegistrationDto){
        return jdbcTemplate.insert(
                "INSERT INTO users (first_name, last_name, email, login, password, phone_number) VALUES(?, ?, ?, ?, ?, ?)",
                RowMapper.getCustomRowMapperUser(),
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getLogin(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getPhone()
        );
    }

    public void delete(UserRegistrationDto userRegistrationDto){
        jdbcTemplate.delete(
                "DELETE FROM users WHERE login = ?",
                userRegistrationDto.getLogin()
        );
    }

    public void update(UserRegistrationDto userRegistrationDto){
        jdbcTemplate.update(
                "UPDATE users " +
                        "SET first_name = ?, last_name = ?, email = ?, login = ?, password = ?, phone_number = ?" +
                        "WHERE login = ?",
                userRegistrationDto.getFirstName(),
                userRegistrationDto.getLastName(),
                userRegistrationDto.getEmail(),
                userRegistrationDto.getLogin(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getPhone(),
                userRegistrationDto.getLogin()
                );
    }

}
