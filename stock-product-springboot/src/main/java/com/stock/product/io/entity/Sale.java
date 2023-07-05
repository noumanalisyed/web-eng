package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the sales database table.
 * 
 */
@Entity
@Table(name="sales")
@NamedQuery(name="Sale.findAll", query="SELECT s FROM Sale s")
public class Sale implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int salesId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private double discounPercentage;

	private double netAmount;

	private int patientsId;

	private int returnOfSalesId;

	private double saleAmount;

	private int salesmanSaleDayId;

	private int salesNumber;

	private String salesStatus;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empId")
	private Employee employee;

	//bi-directional many-to-one association to Paymenttype
	@ManyToOne
	@JoinColumn(name="paymentTypeId")
	private Paymenttype paymenttype;

	//bi-directional many-to-one association to Solditem
	@OneToMany(mappedBy="sale")
	private List<Solditem> solditems;

	public Sale() {
	}

	public int getSalesId() {
		return this.salesId;
	}

	public void setSalesId(int salesId) {
		this.salesId = salesId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getDiscounPercentage() {
		return this.discounPercentage;
	}

	public void setDiscounPercentage(double discounPercentage) {
		this.discounPercentage = discounPercentage;
	}

	public double getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public int getPatientsId() {
		return this.patientsId;
	}

	public void setPatientsId(int patientsId) {
		this.patientsId = patientsId;
	}

	public int getReturnOfSalesId() {
		return this.returnOfSalesId;
	}

	public void setReturnOfSalesId(int returnOfSalesId) {
		this.returnOfSalesId = returnOfSalesId;
	}

	public double getSaleAmount() {
		return this.saleAmount;
	}

	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}

	public int getSalesmanSaleDayId() {
		return this.salesmanSaleDayId;
	}

	public void setSalesmanSaleDayId(int salesmanSaleDayId) {
		this.salesmanSaleDayId = salesmanSaleDayId;
	}

	public int getSalesNumber() {
		return this.salesNumber;
	}

	public void setSalesNumber(int salesNumber) {
		this.salesNumber = salesNumber;
	}

	public String getSalesStatus() {
		return this.salesStatus;
	}

	public void setSalesStatus(String salesStatus) {
		this.salesStatus = salesStatus;
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

	public Paymenttype getPaymenttype() {
		return this.paymenttype;
	}

	public void setPaymenttype(Paymenttype paymenttype) {
		this.paymenttype = paymenttype;
	}

	public List<Solditem> getSolditems() {
		return this.solditems;
	}

	public void setSolditems(List<Solditem> solditems) {
		this.solditems = solditems;
	}

	public Solditem addSolditem(Solditem solditem) {
		getSolditems().add(solditem);
		solditem.setSale(this);

		return solditem;
	}

	public Solditem removeSolditem(Solditem solditem) {
		getSolditems().remove(solditem);
		solditem.setSale(null);

		return solditem;
	}

}
