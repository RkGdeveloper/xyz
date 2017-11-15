package com.cg.ems.service;

import com.cg.ems.dtos.LoginDetailsBean;

public interface ICommonService {

	LoginDetailsBean validateLogin(LoginDetailsBean logBean);

}
