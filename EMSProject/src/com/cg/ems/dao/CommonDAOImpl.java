package com.cg.ems.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.ems.dtos.LoginDetailsBean;

@Repository
@Transactional
public class CommonDAOImpl implements ICommonDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public LoginDetailsBean validateLogin(LoginDetailsBean logBean) {

		
		Query q = entityManager.createNamedQuery("validateLogin");
		q.setParameter("username", logBean.getUserName());
		q.setParameter("pwd", logBean.getPassword());
		q.setParameter("role", logBean.getRole());
		
		logBean = (LoginDetailsBean) q.getSingleResult();
		System.out.println("in DAO"+logBean);
		
		return logBean;
		
	}

	
}
