package com.cg.ems.service;

import java.util.List;

import com.cg.ems.dtos.DepartmentBean;
import com.cg.ems.dtos.DesignationBean;
import com.cg.ems.dtos.EmployeeBean;
import com.cg.ems.dtos.LoginDetailsBean;

public interface IEMSAdminService {

	List<DepartmentBean> getAllDepartment();

	List<DesignationBean> getAllDesig();

	EmployeeBean insertNewEmployee(EmployeeBean empBean);

	LoginDetailsBean insertLoginDetails(LoginDetailsBean logBean);

	EmployeeBean searchById(int empId);


	void update(EmployeeBean empBean);

	void updateLoginDetails(LoginDetailsBean logBean);

	List<EmployeeBean> retrieveAllDetails();

	DepartmentBean getDeptName(int deptId);

	DesignationBean getDesigName(int desigId);

	Long getEmployeeCount();

}
