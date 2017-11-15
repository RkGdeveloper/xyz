package com.cg.ems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.cg.ems.dtos.DepartmentBean;
import com.cg.ems.dtos.DesignationBean;
import com.cg.ems.dtos.EmployeeBean;
import com.cg.ems.dtos.LoginDetailsBean;

@Repository
@Transactional
public class EMSAdminDAOImpl implements IEMSAdminDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DepartmentBean> getAllDepartment() {
		Query q = entityManager.createNamedQuery("getAllDept");
		List<DepartmentBean> listDept = q.getResultList();
		System.out.println("in DAO"+listDept);
		return listDept;
	}

	@Override
	public List<DesignationBean> getAllDesig() {
		Query q = entityManager.createNamedQuery("getAllDesig");
		List<DesignationBean> listDesig = q.getResultList();
		System.out.println("in DAO"+listDesig);
		return listDesig;
	}

	@Override
	public EmployeeBean insertNewEmployee(EmployeeBean empBean) {
		System.out.println("in DAO =>"+empBean);
		
		entityManager.persist(empBean);
		
		System.out.println("in DAO data inserted");
		return empBean;
	}

	@Override
	public LoginDetailsBean insertLoginDetails(LoginDetailsBean logBean) {
		
		if(logBean != null)
		{
			entityManager.persist(logBean);
		}

		return logBean;
	}

	@Override
	public EmployeeBean searchById(int empId) {
		EmployeeBean empList=null;
		
		Query query = (Query) entityManager.createNamedQuery("getEmployeeById", EmployeeBean.class).setParameter("eId", empId);
		 empList = (EmployeeBean) query.getSingleResult();
		
		
		return empList;
	}

	@Override
	public void update(EmployeeBean empBean) {
		entityManager.merge(empBean);
		
	}

	@Override
	public void updateLoginDetails(LoginDetailsBean logBean) {
		entityManager.merge(logBean);
	}

	@Override
	public List<EmployeeBean> retrieveAllDetails() {

		Query query = (Query) entityManager.createNamedQuery("getAllEmployees");
		@SuppressWarnings("unchecked")
		List<EmployeeBean> empList= query.getResultList();
		
		return empList;
	}

	@Override
	public DepartmentBean getDeptName(int deptId) {
		Query query = (Query) entityManager.createNamedQuery("getDeptName", DepartmentBean.class).setParameter("deptId", deptId);
		DepartmentBean dept  =  (DepartmentBean) query.getSingleResult();
		return dept;
	}

	@Override
	public DesignationBean getDesigName(int desigId) {
		Query query = (Query) entityManager.createNamedQuery("getDesigName", DesignationBean.class).setParameter("desigId", desigId);
		DesignationBean desig  =  (DesignationBean) query.getSingleResult();
		return desig;
	}

	@Override
	public Long getEmployeeCount() {
		
		Query query = (Query) entityManager.createNamedQuery("getAllEmployeeNumber", Long.class);
		Long numRows =   (Long) query.getSingleResult();
		System.out.println("Number of rows "+numRows);
		return numRows;
	}



}
