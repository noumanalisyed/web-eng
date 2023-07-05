package com.book.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.book.bookstore.entity.Book;
/**
 * AbstractDAO.java
 * This DAO class gives CRUD database operations for the table book
 * in the database.
 *
 */
public class BookDAO {
    private String jdbcUsername;
    private String jdbcURL;
    private Connection jdbcConnection;
    private String jdbcPassword;

    public BookDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcUsername = jdbcUsername;
        this.jdbcURL = jdbcURL;
        this.jdbcPassword = jdbcPassword;
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    public List<Book> listAllBooks() throws SQLException {
        List<Book> listBook = new ArrayList<>();
        String sql = "SELECT * FROM book";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            String title = result.getString("title");
            int id = result.getInt("book_id");
            float price = result.getFloat("price");
            String author = result.getString("author");

            Book book = new Book(id, author, title, price);
            listBook.add(book);
        }

        result.close();
        statement.close();
        disconnect();

        return listBook;
    }

    public boolean deleteBook(Book book) throws SQLException {
        String sql = "DELETE FROM book where book_id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public boolean insertBook(Book book) throws SQLException {
        String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(2, book.getAuthor());
        statement.setString(1, book.getTitle());
        statement.setFloat(3, book.getPrice());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public Book getBook(int id) throws SQLException {
        Book book = null;
        connect();
        String sql = "Select * from book where book_id = ?";

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String author = resultSet.getString("author");
            String title = resultSet.getString("title");
            float price = resultSet.getFloat("price");

            book = new Book(id, author, title, price);
        }

        resultSet.close();
        statement.close();

        return book;
    }

    public boolean updateBook(Book book) throws SQLException {
        String sql = "UPDATE book SET author = ?, title = ?, price = ?";
        sql += " WHERE book_id = ?";
        connect();

        PreparedStatement stmt= jdbcConnection.prepareStatement(sql);
        stmt.setString(2, book.getAuthor());
        stmt.setString(1, book.getTitle());
        stmt.setInt(4, book.getId());
        stmt.setFloat(3, book.getPrice());

        boolean rowUpdated = statement.executeUpdate() > 0;
        stmt.close();
        disconnect();
        return rowUpdated;
    }
}

