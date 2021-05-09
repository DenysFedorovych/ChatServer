package org.bitbucket.payload;

import org.bitbucket.entity.User;
import org.bitbucket.utils.JsonHelper;
import org.bitbucket.utils.TokenProvider;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Token implements Serializable {

    private long userId;

    private String nickname;

    private Date expireIn;

    private Date createdAt;

    public Token() {
    }

    public void setUserid(long userid) {
        this.userId = userid;
    }

    public void setExpireIn(Date expireIn) {
        this.expireIn = expireIn;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Token(Long id, String firstName, String lastName, Date expireIn, Date createdAt) {
        this.userId = id;
        this.expireIn = expireIn;
        this.createdAt = createdAt;
    }

    public Token(User user, Date expireIn, Date createdAt) {
        this.userId = user.getId();
        this.expireIn = expireIn;
        this.createdAt = createdAt;
    }

    public Token(User user) {
        this.userId = user.getId();
        this.createdAt = new Date(System.currentTimeMillis());
        this.expireIn = new Date(createdAt.getTime() + 1800000);
    }

    public Long getUserId() {
        return userId;
    }

    public Date getExpireIn() {
        return expireIn;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getNickname() {
        return nickname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return userId == token.userId &&
                Objects.equals(nickname, token.nickname) &&
                Objects.equals(expireIn, token.expireIn) &&
                Objects.equals(createdAt, token.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nickname, expireIn, createdAt);
    }

    @Override
    public String toString() {
        return "Token{" +
                "userId=" + userId +
                ", nickname='" + nickname + '\'' +
                ", expireIn=" + expireIn +
                ", createdAt=" + createdAt +
                '}';
    }
}
