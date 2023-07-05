package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;

	private String orderNumber;

	private String statusChangedDiscription;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empId")
	private Employee employee;

	//bi-directional many-to-one association to Orderstatus
	@ManyToOne
	@JoinColumn(name="orderStatusId")
	private Orderstatus orderstatus;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="supplierId")
	private Supplier supplier;

	//bi-directional many-to-one association to Orderplaceditem
	@OneToMany(mappedBy="order")
	private List<Orderplaceditem> orderplaceditems;

	public Order() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getStatusChangedDiscription() {
		return this.statusChangedDiscription;
	}

	public void setStatusChangedDiscription(String statusChangedDiscription) {
		this.statusChangedDiscription = statusChangedDiscription;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Orderstatus getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(Orderstatus orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Orderplaceditem> getOrderplaceditems() {
		return this.orderplaceditems;
	}

	public void setOrderplaceditems(List<Orderplaceditem> orderplaceditems) {
		this.orderplaceditems = orderplaceditems;
	}

	public Orderplaceditem addOrderplaceditem(Orderplaceditem orderplaceditem) {
		getOrderplaceditems().add(orderplaceditem);
		orderplaceditem.setOrder(this);

		return orderplaceditem;
	}

	public Orderplaceditem removeOrderplaceditem(Orderplaceditem orderplaceditem) {
		getOrderplaceditems().remove(orderplaceditem);
		orderplaceditem.setOrder(null);

		return orderplaceditem;
	}

}
