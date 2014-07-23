package org.my.framework.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_MANAGER")
public class Manager implements java.io.Serializable {

	private static final long serialVersionUID = 4884602764204410773L;

	private int id;
	private String username;
	private String password;
	private int state;
	private Date createTime;
	private Manager createPersion;
	private Date updateTime;
	private Manager updatePerson;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length = 20, nullable = false, unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length = 20, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@OneToOne
	@JoinColumn(name = "create_persion_id")
	public Manager getCreatePersion() {
		return createPersion;
	}

	public void setCreatePersion(Manager createPersion) {
		this.createPersion = createPersion;
	}

	@Column(name = "update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@OneToOne
	@JoinColumn(name = "update_persion_id")
	public Manager getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(Manager updatePerson) {
		this.updatePerson = updatePerson;
	}

}