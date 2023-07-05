package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;

	@Lob
	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	private byte deleted;

	private int departmentId;

	private String firstName;

	private String gender;

	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	private String lastName;

	private String mobile;

	private String remarks;

	private Timestamp updateTime;

	//bi-directional many-to-one association to Designation
	@ManyToOne
	@JoinColumn(name="designationId")
	private Designation designation;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="managerId")
	private Employee employee;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employee")
	private List<Employee> employees;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userName")
	private User user;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="employee")
	private List<Order> orders;

	//bi-directional many-to-one association to Returnofborrow
	@OneToMany(mappedBy="employee")
	private List<Returnofborrow> returnofborrows;

	//bi-directional many-to-one association to Sale
	@OneToMany(mappedBy="employee")
	private List<Sale> sales;

	public Employee() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public byte getDeleted() {
		return this.deleted;
	}

	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoiningDate() {
		return this.joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Designation getDesignation() {
		return this.designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEmployee(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEmployee(null);

		return employee;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setEmployee(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setEmployee(null);

		return order;
	}

	public List<Returnofborrow> getReturnofborrows() {
		return this.returnofborrows;
	}

	public void setReturnofborrows(List<Returnofborrow> returnofborrows) {
		this.returnofborrows = returnofborrows;
	}

	public Returnofborrow addReturnofborrow(Returnofborrow returnofborrow) {
		getReturnofborrows().add(returnofborrow);
		returnofborrow.setEmployee(this);

		return returnofborrow;
	}

	public Returnofborrow removeReturnofborrow(Returnofborrow returnofborrow) {
		getReturnofborrows().remove(returnofborrow);
		returnofborrow.setEmployee(null);

		return returnofborrow;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Sale addSale(Sale sale) {
		getSales().add(sale);
		sale.setEmployee(this);

		return sale;
	}

	public Sale removeSale(Sale sale) {
		getSales().remove(sale);
		sale.setEmployee(null);

		return sale;
	}

}
