package com.techno.products.dao;

import com.techno.products.entity.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

	private DataSource dataSource;

	public ProductDao(DataSource theDataSource) {
		System.out.println("Data Source -- Db Connection Start !!!");
		dataSource = theDataSource;
		System.out.println("Data Source -- Db Connection -- "+dataSource);
	}
	
	public List<Product> getProducts() throws Exception {
		
		List<Product> products = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from product order by name";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int product_id = myRs.getInt("product_id");
				String name = myRs.getString("name");
				String description = myRs.getString("description");
				String brand = myRs.getString("brand");
				
				// create new student object
				Product tempProduct = new Product(product_id, name,description, brand);
				
				// add it to the list of students
				products.add(tempProduct);
			}
			
			return products;
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

	public void addProduct(Product theProduct) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into product "
					   + "(name, description, brand) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theProduct.getName());
			myStmt.setString(2, theProduct.getDescription());
			myStmt.setString(3, theProduct.getBrand());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Product getProduct(String theProductId) throws Exception {

		Product theProduct = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int productId;
		
		try {
			// convert student id to int
			productId = Integer.parseInt(theProductId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from product where product_id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, productId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String name = myRs.getString("name");
				String description = myRs.getString("description");
				String brand = myRs.getString("brand");
				
				// use the studentId during construction
				theProduct = new Product(productId, name, description, brand);
			}
			else {
				throw new Exception("Could not find product id: " + theProduct);
			}				
			
			return theProduct;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updateProduct(Product theProduct) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update product "
						+ "set name=?, description=?, brand=? "
						+ "where product_id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theProduct.getName());
			myStmt.setString(2, theProduct.getDescription());
			myStmt.setString(3, theProduct.getBrand());
			myStmt.setInt(4, theProduct.getProductId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteProduct(String theProductId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int productId = Integer.parseInt(theProductId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from product where product_id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, productId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















