package com.cg.ems.dtos;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="EMPLOYEE_TABLE")
@NamedQueries({@NamedQuery(name = "getAllEmployee", query = "SELECT Emp FROM EmployeeBean Emp"),
@NamedQuery(name = "getEmployeeById", query = "SELECT Emp FROM EmployeeBean Emp WHERE Emp.empId =:eId"),
@NamedQuery(name = "getAllEmployees" ,query = "SELECT Emp FROM EmployeeBean Emp ORDER BY Emp.empId"),
@NamedQuery(name = "getAllEmployeeNumber" ,query = "SELECT COUNT(Emp) FROM EmployeeBean Emp")
})  
public class EmployeeBean {

	@Id
	@Column(name="EMP_ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="employee_SEQUENCE")
	@SequenceGenerator(name="employee_SEQUENCE", sequenceName="EMPLOYEE_ID_SEQ")
	private int empId;
	
	@Column(name="EMP_FIRSTNAME")
	//@NotEmpty(message="Employee firstName is Required")
	private String firstName;
	
	@Column(name="EMP_LASTNAME")
	//@NotEmpty(message="Employee Lastname is Required")
	private String lastName;
	
	
	@Column(name="EMP_DATE_OF_JOIN")
	//@NotNull(message="Date is required")
	//@DateTimeFormat(pattern="dd/MM/yyyy")
	//@Past 
	private Date dateOfJoining;
	
	@Column(name="EMP_DATE_OF_BIRTH")
	//@NotNull(message="date of birth is required")
	private Date dateOfBirth;
	
	@Column(name="EMP_DEPT_ID")
	private int deptId;
	
	@Column(name="EMP_DESIGNATION_ID")
	private int designationId;
	
	
	@Column(name="EMP_GRADE")
	//@NotEmpty(message="Grade is required")
	private String grade;
	
	
	@Column(name="EMP_GENDER")
	//@NotEmpty(message="Gender is required")
	private String gender;
	
	//@NotNull(message="Salary Required")
	
	@Column(name="EMP_SALARY")
/*	@NotNull(message="Salary is Required")
*/	//@Digits(long=7,fraction=0,integer=0)
	//@Range(min=5, max=5,message="Please enter valid salary")
	//@Size(min = 10,max = 10,message="contact number should be 10 digits")
	private long salary;
	
	@Column(name="EMP_MARITAL_STATUS")
	//@NotEmpty(message="Marital status is required")
	private String maritalStatus;
	
	
//	@NotNull(message="Contact no. is Required")
	//@Size(min = 10,max = 10,message="contact number should be 10 digits")
	//@Range(min=10, max=10,message="contact number should be 10 digits")
	@Column(name="EMP_CONTACT")
	private long contactNo;
	
	
	//@NotEmpty(message="address is required")

	
	//@NotEmpty(message="addressline1 is required")
	@Column(name="ADDRESS_LINE1")
	private String addressline1;
	
	//@NotEmpty(message="addressline2 is required")
	@Column(name="ADDRESS_LINE2")
	private String addressline2;
	
	//@NotEmpty(message="city is required")
	private String city;
	//@Range(min=6, max=6,message="pincode should be 6 digits")
	//@NotNull(message="pincode is Required")
	private int pincode;
	
	
	//@NotEmpty(message="state is required")
	private String state;
	

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getDateOfJoining() {
			return dateOfJoining;
		}

		public void setDateOfJoining(Date dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public int getDeptId() {
			return deptId;
		}

		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}

		public int getDesignationId() {
			return designationId;
		}

		public void setDesignationId(int designationId) {
			this.designationId = designationId;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public long getSalary() {
			return salary;
		}

		public void setSalary(long salary) {
			this.salary = salary;
		}

		public String getMartialStatus() {
			return maritalStatus;
		}

		public void setMartialStatus(String martialStatus) {
			this.maritalStatus = martialStatus;
		}


		public long getContactNo() {
			return contactNo;
		}

		public void setContactNo(long contactNo) {
			this.contactNo = contactNo;
		}

		public String getAddressline1() {
			return addressline1;
		}

		public void setAddressline1(String addressline1) {
			this.addressline1 = addressline1;
		}

		public String getAddressline2() {
			return addressline2;
		}

		public void setAddressline2(String addressline2) {
			this.addressline2 = addressline2;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public int getPincode() {
			return pincode;
		}

		public void setPincode(int pincode) {
			this.pincode = pincode;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		@Override
		public String toString() {
			return "EmployeeBean [empId=" + empId + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", dateOfJoining="
					+ dateOfJoining + ", dateOfBirth=" + dateOfBirth
					+ ", deptId=" + deptId + ", designationId=" + designationId
					+ ", grade=" + grade + ", gender=" + gender + ", salary="
					+ salary + ", maritalStatus=" + maritalStatus
					+ ", contactNo=" + contactNo + ", addressline1="
					+ addressline1 + ", addressline2=" + addressline2
					+ ", city=" + city + ", pincode=" + pincode + ", state="
					+ state + "]";
		}

}

