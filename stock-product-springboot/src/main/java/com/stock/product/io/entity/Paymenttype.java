package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the paymenttype database table.
 * 
 */
@Entity
@NamedQuery(name="Paymenttype.findAll", query="SELECT p FROM Paymenttype p")
public class Paymenttype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private short paymentTypeId;

	private String paymentTypeDisc;

	private String paymentTypeName;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="paymenttype")
	private List<Sale> sales;

	public Paymenttype() {
	}

	public short getPaymentTypeId() {
		return this.paymentTypeId;
	}

	public void setPaymentTypeId(short paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPaymentTypeDisc() {
		return this.paymentTypeDisc;
	}

	public void setPaymentTypeDisc(String paymentTypeDisc) {
		this.paymentTypeDisc = paymentTypeDisc;
	}

	public String getPaymentTypeName() {
		return this.paymentTypeName;
	}

	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Sale addSale(Sale sale) {
		getSales().add(sale);
		sale.setPaymenttype(this);

		return sale;
	}

	public Sale removeSale(Sale sale) {
		getSales().remove(sale);
		sale.setPaymenttype(null);

		return sale;
	}

}
