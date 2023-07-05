package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stockId;

	private String barCode;

	private String batchNO;

	private double discountPercentage;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

	private int itemSold;

	private int orderPartialsId;

	private int packSize;

	private double pricePrItem;

	private int quantity;

	private int quantityReceived;

	private double sellingPricePrItem;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Soldstock
	@OneToMany(mappedBy="stock")
	private List<Soldstock> soldstocks;

	//bi-directional many-to-one association to Productsupplied
	@ManyToOne
	@JoinColumn(name="productSuppliedId")
	private Productsupplied productsupplied;

	public Stock() {
	}

	public int getStockId() {
		return this.stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getBatchNO() {
		return this.batchNO;
	}

	public void setBatchNO(String batchNO) {
		this.batchNO = batchNO;
	}

	public double getDiscountPercentage() {
		return this.discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getItemSold() {
		return this.itemSold;
	}

	public void setItemSold(int itemSold) {
		this.itemSold = itemSold;
	}

	public int getOrderPartialsId() {
		return this.orderPartialsId;
	}

	public void setOrderPartialsId(int orderPartialsId) {
		this.orderPartialsId = orderPartialsId;
	}

	public int getPackSize() {
		return this.packSize;
	}

	public void setPackSize(int packSize) {
		this.packSize = packSize;
	}

	public double getPricePrItem() {
		return this.pricePrItem;
	}

	public void setPricePrItem(double pricePrItem) {
		this.pricePrItem = pricePrItem;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantityReceived() {
		return this.quantityReceived;
	}

	public void setQuantityReceived(int quantityReceived) {
		this.quantityReceived = quantityReceived;
	}

	public double getSellingPricePrItem() {
		return this.sellingPricePrItem;
	}

	public void setSellingPricePrItem(double sellingPricePrItem) {
		this.sellingPricePrItem = sellingPricePrItem;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Soldstock> getSoldstocks() {
		return this.soldstocks;
	}

	public void setSoldstocks(List<Soldstock> soldstocks) {
		this.soldstocks = soldstocks;
	}

	public Soldstock addSoldstock(Soldstock soldstock) {
		getSoldstocks().add(soldstock);
		soldstock.setStock(this);

		return soldstock;
	}

	public Soldstock removeSoldstock(Soldstock soldstock) {
		getSoldstocks().remove(soldstock);
		soldstock.setStock(null);

		return soldstock;
	}

	public Productsupplied getProductsupplied() {
		return this.productsupplied;
	}

	public void setProductsupplied(Productsupplied productsupplied) {
		this.productsupplied = productsupplied;
	}

}
