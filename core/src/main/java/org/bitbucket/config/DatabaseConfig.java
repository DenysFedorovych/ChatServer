package org.bitbucket.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bitbucket.micro.orm.CustomJdbcTemplate;
import org.bitbucket.repository.UsersRepository;
import org.bitbucket.service.UsersService;

import javax.sql.DataSource;

public class DatabaseConfig {

    private static final String HIKARI_PROPERTY_PATH = "javablock/src/main/resources/hikari.properties";

    public static DataSource getHikariDS() {
        HikariConfig config = new HikariConfig(HIKARI_PROPERTY_PATH);
        return new HikariDataSource(config);
    }

    public static UsersRepository getUsersRepository() {
        return new UsersRepository(new CustomJdbcTemplate(getHikariDS()));
    }

    public static UsersService getUsersService() {
        return new UsersService(getUsersRepository());
    }

}
