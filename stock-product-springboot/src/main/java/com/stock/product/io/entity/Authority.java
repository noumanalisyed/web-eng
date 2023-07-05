package com.stock.product.io.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the authorities database table.
 * 
 */
@Entity
@Table(name="authorities")
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private short authorityId;

	private String authority;

	private Timestamp updateTime;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="authority")
	private List<User> users;

	public Authority() {
	}

	public short getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(short authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAuthority(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAuthority(null);

		return user;
	}

}
