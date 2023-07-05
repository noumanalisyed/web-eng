package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;

	private String productName;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Category category;

	//bi-directional many-to-one association to Productdetail
	@OneToMany(mappedBy="product")
	private List<Productdetail> productdetails;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Productdetail> getProductdetails() {
		return this.productdetails;
	}

	public void setProductdetails(List<Productdetail> productdetails) {
		this.productdetails = productdetails;
	}

	public Productdetail addProductdetail(Productdetail productdetail) {
		getProductdetails().add(productdetail);
		productdetail.setProduct(this);

		return productdetail;
	}

	public Productdetail removeProductdetail(Productdetail productdetail) {
		getProductdetails().remove(productdetail);
		productdetail.setProduct(null);

		return productdetail;
	}

}
