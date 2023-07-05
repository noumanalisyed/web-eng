package com.library.BookApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDbUtil {

    @Resource(name="jdbc/book")
    private DataSource dataSource;

    public BookDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<com.library.BookApplication.Book> getBooks() throws Exception {

        List<com.library.BookApplication.Book> Books = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // get a connection
            myConn = dataSource.getConnection();

            // create sql statement
            String sql = "select * from book_tbl order by Author_name";

            myStmt = myConn.createStatement();

            // execute query
            myRs = myStmt.executeQuery(sql);

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("Book_Id");
                String BookTitle = myRs.getString("Book_title");
                String AuthorName = myRs.getString("Author_name");
                String Category = myRs.getString("Category");
                int Price = myRs.getInt("Price");

                // create new Book object
                com.library.BookApplication.Book tempBook = new com.library.BookApplication.Book(id, BookTitle, AuthorName, Category, Price);

                // add it to the list of Books
                Books.add(tempBook);
            }

            return Books;
        }
        finally {
            // close JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();   // doesn't really close it ... just puts back in connection pool
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void addBook(com.library.BookApplication.Book theBook) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create sql for insert
            String sql = "insert into book_tbl "
                    + "(Book_title, Author_name, Category, Price) "
                    + "values (?, ?, ?, ?)";

            myStmt = myConn.prepareStatement(sql);

            // set the param values for the Book
            myStmt.setString(1, theBook.getBookTitle());
            myStmt.setString(2, theBook.getAuthorName());
            myStmt.setString(3, theBook.getCategory());
            myStmt.setInt(4, theBook.getPrice());

            // execute sql insert
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public com.library.BookApplication.Book getBook(String theBookId) throws Exception {

        com.library.BookApplication.Book theBook = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int BookId;

        try {
            // convert Book id to int
            BookId = Integer.parseInt(theBookId);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to get selected Book
            String sql = "select * from book_tbl where Book_Id=?";

            // create prepared statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, BookId);

            // execute statement
            myRs = myStmt.executeQuery();

            // retrieve data from result set row
            if (myRs.next()) {
                String BookTitle = myRs.getString("first_name");
                String AuthorName = myRs.getString("last_name");
                String Category = myRs.getString("Category");
                int Price = myRs.getInt("Price");

                // use the BookId during construction
                theBook = new com.library.BookApplication.Book(BookId, BookTitle, AuthorName, Category, Price);
            }
            else {
                throw new Exception("Could not find Book id: " + BookId);
            }

            return theBook;
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, myRs);
        }
    }

    public void updateBook(com.library.BookApplication.Book theBook) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create SQL update statement
            String sql = "update book_tbl "
                    + "set Book_title=?, Author_name=?, Category=?, Price=? "
                    + "where Book_Id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, theBook.getBookTitle());
            myStmt.setString(2, theBook.getAuthorName());
            myStmt.setString(3, theBook.getCategory());
            myStmt.setInt(4, theBook.getId());
            myStmt.setInt(5, theBook.getPrice());

            // execute SQL statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public void deleteBook(String theBookTitle) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // convert Book id to int
            int BookId = Integer.parseInt(theBookTitle);

            // get connection to database
            myConn = dataSource.getConnection();

            // create sql to delete Book
            String sql = "delete from book_tbl where Book_title=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, BookId);

            // execute sql statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
        }
    }
}
