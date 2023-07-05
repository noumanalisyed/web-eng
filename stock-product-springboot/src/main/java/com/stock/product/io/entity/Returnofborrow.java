package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the returnofborrow database table.
 * 
 */
@Entity
@NamedQuery(name="Returnofborrow.findAll", query="SELECT r FROM Returnofborrow r")
public class Returnofborrow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int returnOfBorrowId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private double netAmountReturn;

	private String status;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empId")
	private Employee employee;

	public Returnofborrow() {
	}

	public int getReturnOfBorrowId() {
		return this.returnOfBorrowId;
	}

	public void setReturnOfBorrowId(int returnOfBorrowId) {
		this.returnOfBorrowId = returnOfBorrowId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getNetAmountReturn() {
		return this.netAmountReturn;
	}

	public void setNetAmountReturn(double netAmountReturn) {
		this.netAmountReturn = netAmountReturn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
