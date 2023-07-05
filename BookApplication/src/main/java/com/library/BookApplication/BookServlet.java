package com.library.BookApplication;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookDbUtil BookDbUtil;

    @Resource(name="jdbc/book")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        // create our Book db util ... and pass in the conn pool / datasource
        try {
            BookDbUtil = new BookDbUtil(dataSource);
        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");

            // if the command is missing, then default to listing Books
            if (theCommand == null) {
                theCommand = "LIST";
            }

            // route to the appropriate method
            switch (theCommand) {

                case "LIST":
                    listBooks(request, response);
                    break;

                case "ADD":
                    addBook(request, response);
                    break;

                case "LOAD":
                    loadBook(request, response);
                    break;

                case "UPDATE":
                    updateBook(request, response);
                    break;

                case "DELETE":
                    deleteBook(request, response);
                    break;

                default:
                    listBooks(request, response);
            }

        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read book id from form data
        String theBookTitle = request.getParameter("BookTitle");

        // delete Book from database
        BookDbUtil.deleteBook(theBookTitle);

        // send them back to "list Books" page
        listBooks(request, response);
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read Book info from form data
        int id = Integer.parseInt(request.getParameter("bookId"));
        String BookTitle = request.getParameter("BookTitle");
        String AuthorName = request.getParameter("AuthorName");
        String Category = request.getParameter("Category");
        int Price = Integer.parseInt(request.getParameter("Price"));

        // create a new Book object
        Book theBook = new Book(id, BookTitle, AuthorName, Category, Price);

        // perform update on database
        BookDbUtil.updateBook(theBook);

        // send them back to the "list Books" page
        listBooks(request, response);

    }

    private void loadBook(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read Book id from form data
        String theBookId = request.getParameter("BookId");

        // get Book from database (db util)
        Book theBook = BookDbUtil.getBook(theBookId);

        // place Book in the request attribute
        request.setAttribute("THE_Book", theBook);

        // send to jsp page: update-Book-form.jsp
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-books-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addBook(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read Book info from form data
        String BookTitle = request.getParameter("BookTitle");
        String AuthorName = request.getParameter("AuthorName");
        String Category = request.getParameter("Category");
        int Price = Integer.parseInt(request.getParameter("Price"));

        // create a new Book object
        Book theBook = new Book(BookTitle, AuthorName, Category, Price);

        // add the Book to the database
        BookDbUtil.addBook(theBook);

        // send back to main page (the Book list)
        listBooks(request, response);
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get Books from db util
        List<Book> Books = BookDbUtil.getBooks();

        // add Books to the request
        request.setAttribute("Book_LIST", Books);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-books.jsp");
        dispatcher.forward(request, response);
    }

}
