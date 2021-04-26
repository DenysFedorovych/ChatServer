package org.bitbucket.dto;

import java.util.Objects;

public class UserAuthorizationDto {

    private String login;

    private String password;

    public UserAuthorizationDto() {
    }

    public UserAuthorizationDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserAuthorizationDto(UserRegistrationDto userRegistrationDto) {
        this.login = userRegistrationDto.getLogin();
        this.password = userRegistrationDto.getPassword();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAuthorizationDto that = (UserAuthorizationDto) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
