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
@Table(name="DESIGNATION_TABLE")
@NamedQueries({@NamedQuery(name = "getAllDesig", query = "SELECT design FROM DesignationBean design"),
	@NamedQuery(name = "getDesigName", query = "SELECT desig FROM DesignationBean desig WHERE desig.desigId=:desigId") })
public class DesignationBean {

	@Id
	@Column(name="DESIGNATION_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="Designation_SEQUENCE")
	@SequenceGenerator(name="Designation_SEQUENCE", sequenceName="DESIGNATION_ID_SEQ")
	private int desigId;
	
	@Column(name="DESIGNATION_NAME")
	private String desigName;
	
	
	public int getDesigId() {
		return desigId;
	}
	public void setDesigId(int desigId) {
		this.desigId = desigId;
	}
	public String getDesigName() {
		return desigName;
	}
	public void setDesigName(String desigName) {
		this.desigName = desigName;
	}
	@Override
	public String toString() {
		return "DesignationBean [desigId=" + desigId + ", desigName="
				+ desigName + "]";
	}
	
	
	
}
