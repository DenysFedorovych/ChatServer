package org.bitbucket.repository;

import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;
import org.bitbucket.micro.orm.CustomRowMapper;

public class UserRowMapper {

    private static CustomRowMapper<UserAuthorizationDto> customRowMapperAuth;

    private static CustomRowMapper<User> customRowMapperUser;

    private static CustomRowMapper<UserRegistrationDto> customRowMapperReg;

    public static CustomRowMapper<UserAuthorizationDto> getCustomRowMapperAuthDto() {
        if (customRowMapperAuth == null) {
            customRowMapperAuth = rs -> new UserAuthorizationDto(
                    rs.getString("login"),
                    rs.getString("password"));
        }
        return customRowMapperAuth;
    }

    public static CustomRowMapper<User> getCustomRowMapperUser() {
        if (customRowMapperUser == null) {
            customRowMapperUser = rs -> new User(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("phone_number")
            );
        }
        return customRowMapperUser;
    }

    public static CustomRowMapper<UserRegistrationDto> getCustomRowMapperReg(){
        if (customRowMapperReg == null) {
            customRowMapperReg = rs -> new UserRegistrationDto(
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("confirmPassword"),
                    rs.getString("email"),
                    rs.getString("phone")
            );
        }
        return customRowMapperReg;
    }


}
