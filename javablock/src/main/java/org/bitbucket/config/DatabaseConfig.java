package org.bitbucket.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bitbucket.micro.orm.CustomJdbcTemplate;
import org.bitbucket.repository.UsersRepository;
import org.bitbucket.service.CustomUsersService;

import javax.sql.DataSource;

public class DatabaseConfig {

    public static DataSource getHikariDS(){
        HikariConfig hikariConfig = new HikariConfig("src/main/resources/hikari.properties");
        return new HikariDataSource(hikariConfig);
    }

    public static UsersRepository getUsersRepository(){
        return new UsersRepository(new CustomJdbcTemplate(getHikariDS()));
    }

    public static CustomUsersService getUsersService(){
        return new CustomUsersService(getUsersRepository());
    }

}
