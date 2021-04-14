package org.bitbucket.repository;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.entity.User;
import org.bitbucket.micro.orm.CustomJdbcTemplate;

import java.util.Collection;

public class UsersRepository implements IUserRepository {
    //Hikari config
    private final CustomJdbcTemplate<User> customJdbcTemplate;

    private final HikariDataSource dataSource;

    public UsersRepository(HikariConfig hikariConfig){
        dataSource = new HikariDataSource(hikariConfig);
        customJdbcTemplate = new CustomJdbcTemplate<>(dataSource);
    }

    //Database commands (find, create, update, delete)

    @Override
    public Collection findAll() {
        String sqlScript = "select * from " + "table_name";
        try {
            return customJdbcTemplate.findAll(sqlScript, RowMapper.getCustomRowMapperUser());
        } catch (NullPointerException e) {
            throw new NullPointerException("No users");
        }
    }

    @Override
    public User findAuth(UserAuthorizationDto userAuthorizationDto) {
        return null;
    }

    @Override
    public User findReg(UserRegistrationDto userRegistrationDto) {
        return null;
    }

    @Override
    public User insert(UserRegistrationDto userRegistrationDto) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteAll() {

    }
}
