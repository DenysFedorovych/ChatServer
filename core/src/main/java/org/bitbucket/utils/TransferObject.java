package org.bitbucket.utils;

import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;

public class TransferObject {

    public static User toUser(UserRegistrationDto data) {
        return new User(
                data.getLastName(),
                data.getEmail(),
                data.getLogin(),
                data.getPassword(),
                data.getPhone(),
                data.getConfirmPassword()
        );
    }
}
