package com.techno.products.dao;

import com.techno.products.entity.Product;
import com.techno.products.entity.ProductDetail;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailDao {

	private DataSource dataSource;

	private ProductDao productDao;

	public ProductDetailDao(DataSource theDataSource) {
		dataSource = theDataSource;
		productDao = new ProductDao(dataSource);
	}
	
	public List<ProductDetail> getProductDetails() throws Exception {
		
		List<ProductDetail> productDetails = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from product_detail order by price";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int productDetailId = myRs.getInt("product_detail_id");
				double price = myRs.getDouble("price");
				String size = myRs.getString("size");
				int productId = myRs.getInt("product_id");
				Product tempProduct = productDao.getProduct(String.valueOf(productId));
				// create new student object
				ProductDetail tempProductDetail = new ProductDetail(productDetailId, price, size,tempProduct);

				// add it to the list of students
				productDetails.add(tempProductDetail);
			}
			
			return productDetails;
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

	public void addProductDetail(ProductDetail theProductDetail) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into product_detail "
					   + "(price, size, product_id) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setDouble(1, theProductDetail.getPrice());
			myStmt.setString(2, theProductDetail.getSize());
			myStmt.setInt(3, theProductDetail.getProduct().getProductId());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public ProductDetail getProductDetail(String theProductDetailId) throws Exception {

		ProductDetail theProductDetail = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int productDetailId;
		
		try {
			// convert student id to int
			productDetailId = Integer.parseInt(theProductDetailId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from product_detail where product_detail_id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, productDetailId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				double price = myRs.getDouble("price");
				String size = myRs.getString("size");
				int productId = myRs.getInt("product_id");
				Product product = productDao.getProduct(String.valueOf(productId));
				// use the studentId during construction
				theProductDetail = new ProductDetail(productDetailId, price, size, product);
			}
			else {
				throw new Exception("Could not find Product Detail id: " + productDetailId);
			}				
			
			return theProductDetail;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateProductDetail(ProductDetail theProductDetail) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update product_detail "
						+ "set price=?, size=?, product_id=? "
						+ "where product_detail_id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setDouble(1, theProductDetail.getPrice());
			myStmt.setString(2, theProductDetail.getSize());
			myStmt.setInt(3, theProductDetail.getProduct().getProductId());
			myStmt.setInt(4, theProductDetail.getProductDetailId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteProductDetail(String theProductDetailId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int productDetailId = Integer.parseInt(theProductDetailId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from product_detail where product_detail_id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, productDetailId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















