package org.bitbucket.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class UserRegistrationDto {

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    private String confirmPassword;

    private String email;

    private String phone;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String firstName, String lastName, String login, String password, String confirmPassword, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.phone = phone;
    }

    @JsonIgnore
    public boolean isValidPassword() {
        return this.password.equals(this.confirmPassword);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRegistrationDto that = (UserRegistrationDto) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(confirmPassword, that.confirmPassword) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, confirmPassword, email, phone);
    }
}
