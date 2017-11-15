package com.cg.ems.dao;

import com.cg.ems.dtos.LoginDetailsBean;

public interface ICommonDAO {

	LoginDetailsBean validateLogin(LoginDetailsBean logBean);

}
