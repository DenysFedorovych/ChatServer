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
        config.setJdbcUrl("jdbc:postgresql://ec2-34-252-251-16.eu-west-1.compute.amazonaws.com/d2kkikhuddo0t4");
        config.setUsername("piyjovprplzkvn");
        config.setPassword("77da983c208285d6521db10052fdf957d81a31bf682eda96363a8fdcf9bebab6");
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
