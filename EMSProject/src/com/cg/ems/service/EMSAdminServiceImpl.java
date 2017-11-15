package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.IEMSAdminDAO;
import com.cg.ems.dtos.DepartmentBean;
import com.cg.ems.dtos.DesignationBean;
import com.cg.ems.dtos.EmployeeBean;
import com.cg.ems.dtos.LoginDetailsBean;

@Service
public class EMSAdminServiceImpl implements IEMSAdminService{

	@Autowired
	private IEMSAdminDAO adminDao;
	
	
	public IEMSAdminDAO getAdminDao() {
		return adminDao;
	}


	public void setAdminDao(IEMSAdminDAO adminDao) {
		this.adminDao = adminDao;
	}


	@Override
	public List<DepartmentBean> getAllDepartment() {
		return adminDao.getAllDepartment();
	}


	@Override
	public List<DesignationBean> getAllDesig() {
		
		return adminDao.getAllDesig();
	}

	
	
	

	@Override
	public EmployeeBean insertNewEmployee(EmployeeBean empBean) {
		long salary = empBean.getSalary();
		String grade= null;
	
		grade = getGrade(salary);
		
		
		empBean.setGrade(grade);
		
		return adminDao.insertNewEmployee(empBean);
	}
	
	
	


	private String getGrade(long salary) {
		String grade= null;
		
		if(salary>10000 && salary<=20000)
		{
			 grade="M7";
		}
		else if(salary>20000 && salary<=30000)
		{
			 grade="M6";
		}
		else if(salary>30000 && salary<=40000)
		{
			 grade="M5";
		}
		else if(salary>40000 && salary<=50000)
		{
			 grade="M4";
		}
		else if(salary>50000 && salary<=60000)
		{
			 grade="M3"; 
		}
		else if(salary>60000 && salary<=70000)
		{
			 grade="M2"; 
		}
		else
		{
			grade="M1";
		}
		
		return grade;
	}


	@Override
	public LoginDetailsBean insertLoginDetails(LoginDetailsBean logBean) {
		return adminDao.insertLoginDetails(logBean);
	}


	@Override
	public EmployeeBean searchById(int empId) {
		return adminDao.searchById(empId);
	}


	@Override
	public void update(EmployeeBean empBean) {
		long salary = empBean.getSalary();
		String grade= null;
	
		grade = getGrade(salary);
		
		
		empBean.setGrade(grade);
		adminDao.update(empBean);
	}


	@Override
	public void updateLoginDetails(LoginDetailsBean logBean) {
		
		adminDao.updateLoginDetails(logBean);
	}


	@Override
	public List<EmployeeBean> retrieveAllDetails() {
		return adminDao.retrieveAllDetails();
	}


	@Override
	public DepartmentBean getDeptName(int deptId) {
		return adminDao.getDeptName(deptId);
	}


	@Override
	public DesignationBean getDesigName(int desigId) {
		return adminDao.getDesigName(desigId);
	}


	@Override
	public Long getEmployeeCount() {
		return adminDao.getEmployeeCount();
	}
	

}
