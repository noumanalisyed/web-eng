package com.techno.products.controller;

import com.techno.products.entity.Product;
import com.techno.products.entity.ProductDetail;
import com.techno.products.service.ProductDetailService;
import com.techno.products.service.ProductService;
import jdk.nashorn.internal.ir.RuntimeNode;

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
import javax.servlet.http.HttpSession;

@WebServlet("/ProductDetailController")
public class ProductDetailController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductDetailService productDetailService;
    private ProductService productService;
    HttpSession session;

    @Resource(name="jdbc/products")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();


        // create our student db util ... and pass in the conn pool / datasource
        try {
            productDetailService = new ProductDetailService(dataSource);
            productService = new ProductService(dataSource);
        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // read the "command" parameter
            String theCommand = request.getParameter("command");
            System.out.println("Product Controller -- Called ...... ");

            // if the command is missing, then default to listing students
            if (theCommand == null) {
                theCommand = "LIST";
            }

            // route to the appropriate method
            switch (theCommand) {

                case "LIST":
                    listProductsDetails(request, response);
                    break;

                case "ADD":
                    addProductDetail(request, response);
                    break;

                case "LOAD":
                    loadProductDetail(request, response);
                    break;

                case "UPDATE":
                    updateProductDetail(request, response);
                    break;

                case "DELETE":
                    deleteProductDetail(request, response);
                    break;

                case "NEW":
                    loadProductDetail(request, response);
                    break;

                default:
                    listProductsDetails(request, response);
            }

        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }

    }

    private void deleteProductDetail(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student id from form data
        String productDetailId = request.getParameter("productDetailId");

        // delete student from database
        productDetailService.deleteProductDetail(productDetailId);

        // send them back to "list students" page
        listProductsDetails(request, response);
    }

    private void updateProductDetail(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student info from form data
        int productDetailId = Integer.parseInt(request.getParameter("productDetailId"));
        int price = Integer.parseInt(request.getParameter("price"));
        String size = request.getParameter("size");
        String productId = request.getParameter("productId");
        Product product = productService.getProduct(productId);
        // create a new student object
        ProductDetail theProductDetail = new ProductDetail(productDetailId, price, size,product);

        // perform update on database
        productDetailService.updateProductDetail(theProductDetail);

        // send them back to the "list students" page
        listProductsDetails(request, response);

    }

    private void loadProductDetail(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // read student id from form data
        String productDetailId = request.getParameter("productDetailId");

        // get student from database (db util)
        ProductDetail theProductDetail = productDetailService.getProductDetail(productDetailId);

        // place student in the request attribute
        request.setAttribute("THE_PRODUCT_DETAIL", theProductDetail);

        // send to jsp page: update-product-form.jsp
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/update-product-detail-form.jsp");
        dispatcher.forward(request, response);
    }
    private void loadProductDetailNew(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<Product> productList = productService.getProducts();
        // get student from database (db util)

        // place student in the request attribute
        request.setAttribute("PRODUCTLIST", productList);

        // send to jsp page: update-product-form.jsp
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/add-product-detail-form.jsp");
        dispatcher.forward(request, response);
    }

    private void addProductDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // read student info from form data
        Integer price = Integer.parseInt(request.getParameter("price"));
        double size = Double.parseDouble(request.getParameter("size"));
        String productId = request.getParameter("productId");

        // create a new student object
        ProductDetail theProductDetail = new ProductDetail(price,size,productId);

        // add the student to the database
        productDetailService.addProductDetail(theProductDetail);

        // send back to main page (the student list)
        listProductsDetails(request, response);
    }

    private void listProductsDetails(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // get students from db util
        List<ProductDetail> productDetailList = productDetailService.getProductDetails();
        session = request.getSession();
        // add students to the request
        //request.setAttribute("PRODUCT_DETAIL_LIST", productDetailList);
        session.setAttribute("PRODUCT_DETAIL_LIST", productDetailList);

        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-product-details.jsp");
        dispatcher.forward(request, response);
    }

}













