package org.bitbucket.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bitbucket.micro.orm.CustomJdbcTemplate;
import org.bitbucket.repository.UsersRepository;
import org.bitbucket.service.CustomUsersService;

import javax.sql.DataSource;
import java.io.File;

public class DatabaseConfig {

    public static DataSource getHikariDS(){
        HikariConfig config = new HikariConfig("src" + File.separator + "main" + File.separator + "resources" + File.separator + "hikari.properties");
        return new HikariDataSource(config);
    }

    public static UsersRepository getUsersRepository(){
        return new UsersRepository(new CustomJdbcTemplate(getHikariDS()));
    }

    public static CustomUsersService getUsersService(){
        return new CustomUsersService(getUsersRepository());
    }

}
