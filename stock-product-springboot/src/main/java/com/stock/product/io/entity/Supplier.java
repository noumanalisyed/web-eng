package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int supplierId;

	private String address;

	private String manufecture;

	private String supplierContactNumber;

	private String supplierEmail;

	private String supplierName;

	private String type;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="supplier")
	private List<Order> orders;

	//bi-directional many-to-one association to Productsupplied
	@OneToMany(mappedBy="supplier")
	private List<Productsupplied> productsupplieds;

	public Supplier() {
	}

	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getManufecture() {
		return this.manufecture;
	}

	public void setManufecture(String manufecture) {
		this.manufecture = manufecture;
	}

	public String getSupplierContactNumber() {
		return this.supplierContactNumber;
	}

	public void setSupplierContactNumber(String supplierContactNumber) {
		this.supplierContactNumber = supplierContactNumber;
	}

	public String getSupplierEmail() {
		return this.supplierEmail;
	}

	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setSupplier(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setSupplier(null);

		return order;
	}

	public List<Productsupplied> getProductsupplieds() {
		return this.productsupplieds;
	}

	public void setProductsupplieds(List<Productsupplied> productsupplieds) {
		this.productsupplieds = productsupplieds;
	}

	public Productsupplied addProductsupplied(Productsupplied productsupplied) {
		getProductsupplieds().add(productsupplied);
		productsupplied.setSupplier(this);

		return productsupplied;
	}

	public Productsupplied removeProductsupplied(Productsupplied productsupplied) {
		getProductsupplieds().remove(productsupplied);
		productsupplied.setSupplier(null);

		return productsupplied;
	}

}
