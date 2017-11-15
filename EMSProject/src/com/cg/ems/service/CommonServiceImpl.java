package com.cg.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.ICommonDAO;
import com.cg.ems.dtos.LoginDetailsBean;

@Service
public class CommonServiceImpl implements ICommonService{

	@Autowired
	private ICommonDAO daoRef;
	
	
	
	public ICommonDAO getDaoRef() {
		return daoRef;
	}



	public void setDaoRef(ICommonDAO daoRef) {
		this.daoRef = daoRef;
	}



	@Override
	public LoginDetailsBean validateLogin(LoginDetailsBean logBean) {
		
		return daoRef.validateLogin(logBean);
	}
	
	
}
