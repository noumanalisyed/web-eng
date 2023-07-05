package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the soldstock database table.
 * 
 */
@Entity
@NamedQuery(name="Soldstock.findAll", query="SELECT s FROM Soldstock s")
public class Soldstock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int soldStokId;

	private int rowQuantity;

	private double singleItemPrice;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Solditem
	@ManyToOne
	@JoinColumn(name="soldItemId")
	private Solditem solditem;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="stockId")
	private Stock stock;

	public Soldstock() {
	}

	public int getSoldStokId() {
		return this.soldStokId;
	}

	public void setSoldStokId(int soldStokId) {
		this.soldStokId = soldStokId;
	}

	public int getRowQuantity() {
		return this.rowQuantity;
	}

	public void setRowQuantity(int rowQuantity) {
		this.rowQuantity = rowQuantity;
	}

	public double getSingleItemPrice() {
		return this.singleItemPrice;
	}

	public void setSingleItemPrice(double singleItemPrice) {
		this.singleItemPrice = singleItemPrice;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Solditem getSolditem() {
		return this.solditem;
	}

	public void setSolditem(Solditem solditem) {
		this.solditem = solditem;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
