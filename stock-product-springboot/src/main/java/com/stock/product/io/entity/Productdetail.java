package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the productdetails database table.
 * 
 */
@Entity
@Table(name="productdetails")
@NamedQuery(name="Productdetail.findAll", query="SELECT p FROM Productdetail p")
public class Productdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productDetailId;

	private int alertBFExpiryDays;

	private String barcode;

	private double productSize;

	private int thresholdLevel;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;

	//bi-directional many-to-one association to Productsupplied
	@OneToMany(mappedBy="productdetail")
	private List<Productsupplied> productsupplieds;

	//bi-directional many-to-one association to Solditem
	@OneToMany(mappedBy="productdetail")
	private List<Solditem> solditems;

	public Productdetail() {
	}

	public int getProductDetailId() {
		return this.productDetailId;
	}

	public void setProductDetailId(int productDetailId) {
		this.productDetailId = productDetailId;
	}

	public int getAlertBFExpiryDays() {
		return this.alertBFExpiryDays;
	}

	public void setAlertBFExpiryDays(int alertBFExpiryDays) {
		this.alertBFExpiryDays = alertBFExpiryDays;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getProductSize() {
		return this.productSize;
	}

	public void setProductSize(double productSize) {
		this.productSize = productSize;
	}

	public int getThresholdLevel() {
		return this.thresholdLevel;
	}

	public void setThresholdLevel(int thresholdLevel) {
		this.thresholdLevel = thresholdLevel;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Productsupplied> getProductsupplieds() {
		return this.productsupplieds;
	}

	public void setProductsupplieds(List<Productsupplied> productsupplieds) {
		this.productsupplieds = productsupplieds;
	}

	public Productsupplied addProductsupplied(Productsupplied productsupplied) {
		getProductsupplieds().add(productsupplied);
		productsupplied.setProductdetail(this);

		return productsupplied;
	}

	public Productsupplied removeProductsupplied(Productsupplied productsupplied) {
		getProductsupplieds().remove(productsupplied);
		productsupplied.setProductdetail(null);

		return productsupplied;
	}

	public List<Solditem> getSolditems() {
		return this.solditems;
	}

	public void setSolditems(List<Solditem> solditems) {
		this.solditems = solditems;
	}

	public Solditem addSolditem(Solditem solditem) {
		getSolditems().add(solditem);
		solditem.setProductdetail(this);

		return solditem;
	}

	public Solditem removeSolditem(Solditem solditem) {
		getSolditems().remove(solditem);
		solditem.setProductdetail(null);

		return solditem;
	}

}
