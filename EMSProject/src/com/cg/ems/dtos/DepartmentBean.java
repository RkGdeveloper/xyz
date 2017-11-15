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
@Table(name="DEPARTMENT_TABLE")
@NamedQueries({@NamedQuery(name = "getAllDept", query = "SELECT dept FROM DepartmentBean dept"),
@NamedQuery(name = "getDeptName", query = "SELECT dept FROM DepartmentBean dept WHERE dept.deptId=:deptId")})
public class DepartmentBean {

	@Id
	@Column(name="DEPARTMENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="department_SEQUENCE")
	@SequenceGenerator(name="department_SEQUENCE", sequenceName="DEPARTMENT_ID_SEQ")
	private int deptId;
	
	@Column(name="DEPARTMENT_NAME")
	private String deptName;
	
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "DepartmentBean [deptId=" + deptId + ", deptName=" + deptName
				+ "]";
	}
	
	
	
}

