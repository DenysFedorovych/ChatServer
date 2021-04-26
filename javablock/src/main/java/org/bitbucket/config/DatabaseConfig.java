package org.bitbucket.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bitbucket.micro.orm.CustomJdbcTemplate;
import org.bitbucket.repository.UsersRepository;
import org.bitbucket.service.CustomUsersService;

import javax.sql.DataSource;

public class DatabaseConfig {

    public static DataSource getHikariDS(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://ec2-34-252-251-16.eu-west-1.compute.amazonaws.com/de28o4hdufj7m1");
        config.setUsername("qgvrweumbrinxe");
        config.setPassword("89c37abe70b0c0a5b337f1a55edccb6e7064a1c93eaac14db2a4d747c42e2be5");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return new HikariDataSource(config);
    }

    public static UsersRepository getUsersRepository(){
        return new UsersRepository(new CustomJdbcTemplate(getHikariDS()));
    }

    public static CustomUsersService getUsersService(){
        return new CustomUsersService(getUsersRepository());
    }

}
