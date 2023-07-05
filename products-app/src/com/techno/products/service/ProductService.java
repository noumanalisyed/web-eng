package com.techno.products.service;

import com.techno.products.dao.ProductDao;
import com.techno.products.entity.Product;

import javax.sql.DataSource;
import java.util.List;

public class ProductService {
    private ProductDao productDao;

    public ProductService(DataSource dataSource) {
        this.productDao = new ProductDao(dataSource);
    }

    public void addProduct(Product product) throws Exception {
        productDao.addProduct(product);
    }

    public List<Product> getProducts() throws Exception {
        return productDao.getProducts();
    }

    public Product getProduct(String productId) throws Exception {
        return  productDao.getProduct(productId);
    }

    public void updateProduct(Product product) throws Exception {
        productDao.updateProduct(product);
    }
    public void deleteProduct(String productId) throws Exception {
        productDao.deleteProduct(productId);
    }

}
