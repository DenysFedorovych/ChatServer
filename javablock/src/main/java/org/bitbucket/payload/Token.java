package org.bitbucket.payload;

import org.bitbucket.entity.User;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Token implements Serializable {

    private long userid;

    private String firstName;

    private String lastName;

    private Date expireIn;

    private Date createdAt;

    public Token() {
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExpireIn(Date expireIn) {
        this.expireIn = expireIn;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Token(Long id, String firstName, String lastName, Date expireIn, Date createdAt) {
        this.userid = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.expireIn = expireIn;
        this.createdAt = createdAt;
    }

    public Token(User user, Date expireIn, Date createdAt) {
        this.userid = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.expireIn = expireIn;
        this.createdAt = createdAt;
    }

    public Token(User user) {
        this.userid = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.createdAt = new Date(System.currentTimeMillis());
        this.expireIn = new Date(createdAt.getTime() + 1800000);
    }

    public Long getuserid() {
        return userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getlastName() {
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
        return Objects.equals(userid, token.userid) && Objects.equals(firstName, token.firstName) && Objects.equals(lastName, token.lastName) && Objects.equals(expireIn, token.expireIn) && Objects.equals(createdAt, token.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, firstName, lastName, expireIn, createdAt);
    }

    @Override
    public String toString() {
        return "Token{" +
                "id" + userid +
                ", firstName=" + firstName + '\n' +
                ", lasteName=" + lastName + '\n' +
                ", expireIn" + expireIn +
                ", createdAt" + createdAt +
                '}';
    }
}
