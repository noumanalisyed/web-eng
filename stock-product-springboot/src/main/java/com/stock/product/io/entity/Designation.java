package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the designation database table.
 * 
 */
@Entity
@NamedQuery(name="Designation.findAll", query="SELECT d FROM Designation d")
public class Designation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int designationId;

	private String designation;

	private int level;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Designation
	@ManyToOne
	@JoinColumn(name="parentDesignationId")
	private Designation designationBean;

	//bi-directional many-to-one association to Designation
	@OneToMany(mappedBy="designationBean")
	private List<Designation> designations;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="designation")
	private List<Employee> employees;

	public Designation() {
	}

	public int getDesignationId() {
		return this.designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Designation getDesignationBean() {
		return this.designationBean;
	}

	public void setDesignationBean(Designation designationBean) {
		this.designationBean = designationBean;
	}

	public List<Designation> getDesignations() {
		return this.designations;
	}

	public void setDesignations(List<Designation> designations) {
		this.designations = designations;
	}

	public Designation addDesignation(Designation designation) {
		getDesignations().add(designation);
		designation.setDesignationBean(this);

		return designation;
	}

	public Designation removeDesignation(Designation designation) {
		getDesignations().remove(designation);
		designation.setDesignationBean(null);

		return designation;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setDesignation(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setDesignation(null);

		return employee;
	}

}
