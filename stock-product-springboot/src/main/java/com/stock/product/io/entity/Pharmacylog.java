package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the pharmacylog database table.
 * 
 */
@Entity
@NamedQuery(name="Pharmacylog.findAll", query="SELECT p FROM Pharmacylog p")
public class Pharmacylog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pharmacyLogId;

	private String actionPerformed;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String discription;

	private String tableName;

	private Timestamp updateTime;

	private String userName;

	public Pharmacylog() {
	}

	public int getPharmacyLogId() {
		return this.pharmacyLogId;
	}

	public void setPharmacyLogId(int pharmacyLogId) {
		this.pharmacyLogId = pharmacyLogId;
	}

	public String getActionPerformed() {
		return this.actionPerformed;
	}

	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
