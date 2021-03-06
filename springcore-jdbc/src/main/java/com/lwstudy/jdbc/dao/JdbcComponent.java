package com.lwstudy.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: LiuWang
 * @Created: 2018/8/7 15:04
 */
@Repository
public class JdbcComponent {
    private final DataSource dataSource;

    @Autowired
    public JdbcComponent(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection connection() {
        //连接数据库
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PreparedStatement preparedStatement(Connection connection, String sql) {
        if (connection != null) {
            try {
                return connection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ResultSet query(PreparedStatement statement) {
        if (statement != null) {
            try {
                return statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int update(PreparedStatement statement) {
        if (statement != null) {
            try {
                return statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }


    public void close(ResultSet resultSet, PreparedStatement statement, Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
