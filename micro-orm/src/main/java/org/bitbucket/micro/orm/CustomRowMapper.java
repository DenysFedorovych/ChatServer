package org.bitbucket.micro.orm;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomRowMapper<T> {
    T rowMap(ResultSet rs) throws SQLException;
}