package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the productsupplied database table.
 * 
 */
@Entity
@NamedQuery(name="Productsupplied.findAll", query="SELECT p FROM Productsupplied p")
public class Productsupplied implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productSuppliedId;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Orderplaceditem
	@OneToMany(mappedBy="productsupplied")
	private List<Orderplaceditem> orderplaceditems;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplierId")
	private Supplier supplier;

	//bi-directional many-to-one association to Productdetail
	@ManyToOne
	@JoinColumn(name="productDetailId")
	private Productdetail productdetail;

	//bi-directional many-to-one association to Stock
	@OneToMany(mappedBy="productsupplied")
	private List<Stock> stocks;

	public Productsupplied() {
	}

	public int getProductSuppliedId() {
		return this.productSuppliedId;
	}

	public void setProductSuppliedId(int productSuppliedId) {
		this.productSuppliedId = productSuppliedId;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Orderplaceditem> getOrderplaceditems() {
		return this.orderplaceditems;
	}

	public void setOrderplaceditems(List<Orderplaceditem> orderplaceditems) {
		this.orderplaceditems = orderplaceditems;
	}

	public Orderplaceditem addOrderplaceditem(Orderplaceditem orderplaceditem) {
		getOrderplaceditems().add(orderplaceditem);
		orderplaceditem.setProductsupplied(this);

		return orderplaceditem;
	}

	public Orderplaceditem removeOrderplaceditem(Orderplaceditem orderplaceditem) {
		getOrderplaceditems().remove(orderplaceditem);
		orderplaceditem.setProductsupplied(null);

		return orderplaceditem;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Productdetail getProductdetail() {
		return this.productdetail;
	}

	public void setProductdetail(Productdetail productdetail) {
		this.productdetail = productdetail;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setProductsupplied(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setProductsupplied(null);

		return stock;
	}

}
