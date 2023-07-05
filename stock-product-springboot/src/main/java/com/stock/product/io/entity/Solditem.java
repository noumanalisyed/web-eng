package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the solditems database table.
 * 
 */
@Entity
@Table(name="solditems")
@NamedQuery(name="Solditem.findAll", query="SELECT s FROM Solditem s")
public class Solditem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int soldItemId;

	private double amount;

	private double discountpercent;

	private int quantity;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Productdetail
	@ManyToOne
	@JoinColumn(name="productDetailId")
	private Productdetail productdetail;

	//bi-directional many-to-one association to Sale
	@ManyToOne
	@JoinColumn(name="salesId")
	private Sale sale;

	//bi-directional many-to-one association to Soldstock
	@OneToMany(mappedBy="solditem")
	private List<Soldstock> soldstocks;

	public Solditem() {
	}

	public int getSoldItemId() {
		return this.soldItemId;
	}

	public void setSoldItemId(int soldItemId) {
		this.soldItemId = soldItemId;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getDiscountpercent() {
		return this.discountpercent;
	}

	public void setDiscountpercent(double discountpercent) {
		this.discountpercent = discountpercent;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Productdetail getProductdetail() {
		return this.productdetail;
	}

	public void setProductdetail(Productdetail productdetail) {
		this.productdetail = productdetail;
	}

	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public List<Soldstock> getSoldstocks() {
		return this.soldstocks;
	}

	public void setSoldstocks(List<Soldstock> soldstocks) {
		this.soldstocks = soldstocks;
	}

	public Soldstock addSoldstock(Soldstock soldstock) {
		getSoldstocks().add(soldstock);
		soldstock.setSolditem(this);

		return soldstock;
	}

	public Soldstock removeSoldstock(Soldstock soldstock) {
		getSoldstocks().remove(soldstock);
		soldstock.setSolditem(null);

		return soldstock;
	}

}
