package com.lwstudy.springcore.template;

import com.lwstudy.springcore.jdbc.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: LiuWang
 * @Created: 2018/8/25 12:49
 */
@Component
public class JdbcTemplateOperation {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addBook() {
        int effect = this.jdbcTemplate.update("insert into `soft_bookrack` (book_name, " +
                        "book_author, book_isbn) values (?,?,?)",
                "Spring in Action", "Craig Walls", "9787115417306");
        System.out.println("Add Book Result: " + effect);
    }

    public void updateBook() {
        int effect = this.jdbcTemplate.update("update `soft_bookrack` set book_author=? where book_isbn=?",
                "张卫滨", "9787115417306");
        System.out.println("Update Book Result: " + effect);
    }

    public void deleteBook() {
        int effect = this.jdbcTemplate.update("delete from `soft_bookrack` where book_isbn=?",
                "9787115417306");
        System.out.println("Delete Result: " + effect);
    }

    public void queryBook() {
        List<Map<String, Object>> books = this.jdbcTemplate.queryForList("select book_name, book_author, " +
                "book_isbn from soft_bookrack where book_isbn=?", "9787115417306");
        System.out.println(books);
    }

    public void queryBookForList() {
        List<Book> books = this.jdbcTemplate.query("select book_name, book_author, " +
                        "book_isbn from soft_bookrack where book_isbn=?",
                new Object[]{"9787115417306"}, new RowMapper<Book>() {
                    @Override
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Book book = new Book();
                        book.setBookName(rs.getString("book_name"));
                        book.setBookAuthor(rs.getString("book_author"));
                        book.setBookIsbn(rs.getString("book_isbn"));
                        return book;
                    }
                });
        System.out.println(books);
    }

    public int countBook() {
        int count = this.jdbcTemplate.queryForObject("select count(book_isbn) from soft_bookrack", Integer.class);
        System.out.println("Count Book: " + count);
        return count;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
