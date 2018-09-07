package com.lwstudy.mybatis.jdbc;

import java.sql.*;
import java.util.Date;

/**
 * @author: LiuWang
 * @data: 2018/9/4 8:52
 */
public class MemoApplication {

    private static Connection connection;
    private static ResultSet resultSet;
    private static Statement statement;

    public static void main(String[] args) {

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/memo?user=root&password=xyxy&useUnicode=true&characterEncoding=UTF-8");
            // 创建命令
            statement = connection.createStatement();
            // 执行 SQL
            resultSet = statement.executeQuery("select id, name, created_time, modify_time from memo_group");
            // 处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Date createdTime = resultSet.getDate("created_time");
                Date modifyTime = resultSet.getDate("modify_time");
                System.out.println(String.format("MemoGroup: id=%d, name=%s, createdTime=%s, modifyTime=%s", id, name, createdTime.toString(), modifyTime.toString()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭结果集
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 关闭命令
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 关闭连接
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
