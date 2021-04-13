package org.bitbucket.payload;

import java.util.Date;
import java.util.Objects;

public class Token {

    private long userid;

    private String firstName;

    private String lastName;

    private Date expireIn;

    private Date createdAt;

    public Token() {
    }

    public Token(long userid, String firstName, String lastName, Date expireIn, Date createdAt) {
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expireIn = expireIn;
        this.createdAt = createdAt;
    }

    public long getUserid() {
        return userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getExpireIn() {
        return expireIn;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return userid == token.userid && Objects.equals(firstName, token.firstName) && Objects.equals(lastName, token.lastName) && Objects.equals(expireIn, token.expireIn) && Objects.equals(createdAt, token.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, firstName, lastName, expireIn, createdAt);
    }

    @Override
    public String toString() {
        return "Token{" +
                "userid=" + userid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", expireIn=" + expireIn +
                ", createdAt=" + createdAt +
                '}';
    }
}
