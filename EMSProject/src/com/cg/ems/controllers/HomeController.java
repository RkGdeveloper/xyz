package com.cg.ems.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.ems.dtos.LoginDetailsBean;
import com.cg.ems.service.ICommonService;



@Controller
public class HomeController {

	@Autowired
	private ICommonService serviceRef;
	
	
	public ICommonService getServiceRef() {
		return serviceRef;
	}

	public void setServiceRef(ICommonService serviceRef) {
		this.serviceRef = serviceRef;
	}

	@RequestMapping("/index")
	public String goToIndex(Model m){
			m.addAttribute("appTitle","Employee Maintenance System");
			m.addAttribute("msg", null);
			
			return "index";
	}
	
	@RequestMapping("/validateAdminLogin")
	public String validateLogin(Model m,@RequestParam("usrname") String username,@RequestParam("psw") String password,@RequestParam("msg") String msg,HttpServletRequest req){
		
		System.out.println("in validate login function"+username + "   "+password);
		String pageToRedirect = "index";
		LoginDetailsBean logBean = new LoginDetailsBean();
		logBean.setUserName(username);
		logBean.setPassword(password);
		logBean.setRole("Admin");
		
		try{
		logBean = serviceRef.validateLogin(logBean);
		System.out.println("in Contoller"+logBean);
		
		HttpSession session = req.getSession(true);
		System.out.println(session.getId());
		
		session.setAttribute("sessionId", session.getId());
		session.setAttribute("logDetails", logBean);
		
		return "redirect:admin/dashboard.ems";
		}
		
		catch(Exception e){
			
			if(!username.equals("121"))
			{
			
			String name = " Invalid Username.... ";
			String pass = " Invalid PassWord.... ";
			m.addAttribute("name",name);
			m.addAttribute("pass",pass);
			m.addAttribute("msg",null);	
			}
			else
			{
				m.addAttribute("name",null);
				m.addAttribute("pass",null);
				m.addAttribute("msg",msg);	
					
			}
			}
		
		return pageToRedirect; 
	}
	
	
}
