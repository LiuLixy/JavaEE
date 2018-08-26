package com.lwstudy.springcore.jdbc;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 11:19
 */
@Component
public class JdbcOperation {

    private final DataSource dataSource;

    public JdbcOperation(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 添加书
     */
    public void addBook() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 创建连接
            connection = dataSource.getConnection();

            // 创建语句
            statement = connection.prepareStatement("insert into `soft_bookrack` (book_name, " +
                    "book_author, book_isbn) values (?,?,?)");

            // 赋值参数
            statement.setString(1, "Spring in Action");
            statement.setString(2, "Craig Walls");
            statement.setString(3, "9787115417305");

            // 执行语句
            int effect = statement.executeUpdate();
            System.out.println("Execute Result " + effect);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
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

    /**
     * 更新
     */
    public void updateBook() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 创建连接
            connection = dataSource.getConnection();

            // 创建语句
            statement = connection.prepareStatement("update `soft_bookrack` set " +
                    "book_author=? where book_isbn=?");

            // 赋值参数
            statement.setString(1, "张卫滨");
            statement.setString(2, "9787115417305");

            // 执行语句
            int effect = statement.executeUpdate();
            System.out.println("Execute Result " + effect);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
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

    public void queryBook() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 创建连接
            connection = dataSource.getConnection();

            // 创建语句
            statement = connection.prepareStatement("select book_name, book_author, " +
                    "book_isbn from soft_bookrack where book_isbn=?");

            // 赋值参数
            statement.setString(1, "9787115417305");

            // 执行语句
            resultSet = statement.executeQuery();
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBookName(resultSet.getString("book_name"));
                book.setBookAuthor(resultSet.getString("book_author"));
                book.setBookIsbn(resultSet.getString("book_isbn"));
                books.add(book);
            }
            System.out.println(books);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
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

}
