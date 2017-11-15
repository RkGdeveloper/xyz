package com.cg.ems.dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="login_details")
@NamedQueries({@NamedQuery(name = "validateLogin", query = "SELECT log FROM LoginDetailsBean log WHERE log.userName = :username AND log.password = :pwd AND log.role = :role")})
public class LoginDetailsBean {

	@Id
	@Column(name="LOGIN_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="login_SEQUENCE")
	@SequenceGenerator(name="login_SEQUENCE", sequenceName="LOGIN_ID_SEQ")
	private int loginId;
	
	@Column(name="login_username")
	private String userName;
	
	@Column(name="login_password")
	private String password;
	
	@Column(name="login_role")
	private String role;
	
	@Column(name="emp_id_ref")
	private int empId;
	
	public LoginDetailsBean() {
		
	}

	public LoginDetailsBean(int loginId, String userName, String password,
			String role, int empId) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.empId = empId;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "LoginDetailsBean [loginId=" + loginId + ", userName="
				+ userName + ", password=" + password + ", role=" + role
				+ ", empId=" + empId + "]";
	}
	
}
