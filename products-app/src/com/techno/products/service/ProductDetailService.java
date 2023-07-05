package com.techno.products.service;

import com.techno.products.dao.ProductDao;
import com.techno.products.dao.ProductDetailDao;
import com.techno.products.entity.Product;
import com.techno.products.entity.ProductDetail;

import javax.sql.DataSource;
import java.util.List;

public class ProductDetailService {
    private ProductDetailDao productDetailDao;

    public ProductDetailService(DataSource dataSource) {
        this.productDetailDao = new ProductDetailDao(dataSource);
    }

    public void addProductDetail(ProductDetail productDetail) throws Exception {
        productDetailDao.addProductDetail(productDetail);
    }

    public List<ProductDetail> getProductDetails() throws Exception {
        return productDetailDao.getProductDetails();
    }

    public ProductDetail getProductDetail(String productDetailId) throws Exception {
        return  productDetailDao.getProductDetail(productDetailId);
    }

    public void updateProductDetail(ProductDetail productDetail) throws Exception {
        productDetailDao.updateProductDetail(productDetail);
    }
    public void deleteProductDetail(String productDetailId) throws Exception {
        productDetailDao.deleteProductDetail(productDetailId);
    }

}
