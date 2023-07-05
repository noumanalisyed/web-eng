package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the orderstatus database table.
 * 
 */
@Entity
@NamedQuery(name="Orderstatus.findAll", query="SELECT o FROM Orderstatus o")
public class Orderstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderStatusId;

	private String statusDiscription;

	private String statusName;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="orderstatus")
	private List<Order> orders;

	public Orderstatus() {
	}

	public int getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getStatusDiscription() {
		return this.statusDiscription;
	}

	public void setStatusDiscription(String statusDiscription) {
		this.statusDiscription = statusDiscription;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
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
		order.setOrderstatus(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setOrderstatus(null);

		return order;
	}

}
