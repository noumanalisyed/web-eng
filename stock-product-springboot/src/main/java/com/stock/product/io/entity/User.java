package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String userName;

	private byte enabled;

	private String password;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="user")
	private List<Employee> employees;

	//bi-directional many-to-one association to Authority
	@ManyToOne
	@JoinColumn(name="authorityId")
	private Authority authority;

	public User() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setUser(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setUser(null);

		return employee;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}
