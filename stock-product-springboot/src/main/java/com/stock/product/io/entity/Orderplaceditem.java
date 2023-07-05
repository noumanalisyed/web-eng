package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the orderplaceditems database table.
 * 
 */
@Entity
@Table(name="orderplaceditems")
@NamedQuery(name="Orderplaceditem.findAll", query="SELECT o FROM Orderplaceditem o")
public class Orderplaceditem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderPlacedItemsId;

	private int packSize;

	private int quantityOrderd;

	private double ratePrUnit;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;

	//bi-directional many-to-one association to Productsupplied
	@ManyToOne
	@JoinColumn(name="productSuppliedId")
	private Productsupplied productsupplied;

	public Orderplaceditem() {
	}

	public int getOrderPlacedItemsId() {
		return this.orderPlacedItemsId;
	}

	public void setOrderPlacedItemsId(int orderPlacedItemsId) {
		this.orderPlacedItemsId = orderPlacedItemsId;
	}

	public int getPackSize() {
		return this.packSize;
	}

	public void setPackSize(int packSize) {
		this.packSize = packSize;
	}

	public int getQuantityOrderd() {
		return this.quantityOrderd;
	}

	public void setQuantityOrderd(int quantityOrderd) {
		this.quantityOrderd = quantityOrderd;
	}

	public double getRatePrUnit() {
		return this.ratePrUnit;
	}

	public void setRatePrUnit(double ratePrUnit) {
		this.ratePrUnit = ratePrUnit;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Productsupplied getProductsupplied() {
		return this.productsupplied;
	}

	public void setProductsupplied(Productsupplied productsupplied) {
		this.productsupplied = productsupplied;
	}

}
