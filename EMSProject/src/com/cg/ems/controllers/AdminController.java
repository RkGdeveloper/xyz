package com.cg.ems.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.ems.dtos.DepartmentBean;
import com.cg.ems.dtos.DesignationBean;
import com.cg.ems.dtos.EmployeeBean;
import com.cg.ems.dtos.LoginDetailsBean;
import com.cg.ems.service.IEMSAdminService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IEMSAdminService adminService;
	
	
	public IEMSAdminService getAdminService() {
		return adminService;
	}


	public void setAdminService(IEMSAdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("/dashboard")
	public String getDashBoard(Model m,HttpServletRequest req){
		
			HttpSession session = req.getSession();
		
		if(session.getAttribute("logDetails") != null){

			return "pages/admin/dashboard";
		}
		else
		{
			m.addAttribute("usrname","121");
			m.addAttribute("psw","121");
			m.addAttribute("msg","Login first to get Dashboard");
			System.out.println("session invalidate");
			return "redirect:../validateAdminLogin.ems";
		}
		
		
	}
	
	// to set data in model
	
	
	Model setDataInModel(Model m){
		List<DepartmentBean> listDept = adminService.getAllDepartment();
		System.out.println(listDept);
		Map<Integer,String> mapDept = new LinkedHashMap<Integer,String>();
		
		for(DepartmentBean deptBean : listDept){
		mapDept.put(deptBean.getDeptId(),deptBean.getDeptName());
		}
		
		m.addAttribute("deptSet",mapDept);
	/*	=================================================================*/
		
		List<DesignationBean> listDesig = adminService.getAllDesig();
		System.out.println(listDesig);
		
		Map<Integer,String> mapDesign = new LinkedHashMap<Integer,String>();
		
		for(DesignationBean designBean : listDesig){
			mapDesign.put(designBean.getDesigId(),designBean.getDesigName());
			}
		
		m.addAttribute("designSet",mapDesign);
		
		List<String> maritalStatus = new ArrayList<String>();
		
		maritalStatus.add("Single");
		maritalStatus.add("Married");
		maritalStatus.add("Divorced");
		maritalStatus.add("Separated");
		maritalStatus.add("Widowed");
		
		m.addAttribute("maritalSet",maritalStatus);
		
		return m;
	}
	

	
	@RequestMapping("/prepareAddEmplForm")
	public String prepareAddEmplForm(Model m){
		
		
		m = setDataInModel(m);
		
		m.addAttribute("EmployeeDetails",new EmployeeBean());
		
		return "pages/admin/AddEmployee";
	}
	
	
	@RequestMapping("/insertEmployeeDetails")
	public String insertNewEmployee(@ModelAttribute("EmployeeDetails")@Valid EmployeeBean empBean,BindingResult result,Model m){
	
		
		/*if(result.hasErrors()){
			System.out.println("In validation");
			m = setDataInModel(m);
			return "pages/admin/AddEmployee";		
		}
		
		else{*/
		System.out.println("Before Inserting"+empBean);
		empBean = adminService.insertNewEmployee(empBean);
		
		
		LoginDetailsBean logBean =  new LoginDetailsBean();
		logBean.setUserName(empBean.getFirstName()+empBean.getDeptId());
		String password = empBean.getLastName() + empBean.getDesignationId();
		logBean.setPassword(password);
		logBean.setRole("Employee");
		logBean.setEmpId(empBean.getEmpId());
		
		logBean = adminService.insertLoginDetails(logBean);
		
		m.addAttribute("loginDetails",logBean);
		System.out.println("After Inserting"+empBean);
		
		return "pages/admin/SuccessOnInsert";
		//}
		
	}
	
	@RequestMapping("/searchEmployee")
	public String findById(Model model){
		model.addAttribute("empBean",new EmployeeBean());
		model.addAttribute("key",null);
		return "pages/admin/SearchEmployee";
	}


@RequestMapping("/find")
	public String findByEmpId(@RequestParam("empId") int empId,Model m)
			{
	
	String pageToRedirect = "pages/admin/ErrorPage";
		/*System.out.println(empId);
			EmployeeBean empBean = adminService.searchById(empId) ;
			System.out.println(empBean);
			return new ModelAndView("pages/admin/SearchEmployee", "key", empBean); */
		
		try{
		EmployeeBean empBean = adminService.searchById(empId);
		System.out.println(empBean);
		int deptId=empBean.getDeptId();
		DepartmentBean dept=adminService.getDeptName(deptId);
		int desigId=empBean.getDesignationId();
		DesignationBean desig=adminService.getDesigName(desigId);
		
		
		
		m.addAttribute("key", empBean);
		m.addAttribute("d",dept);
		m.addAttribute("e", desig);
		pageToRedirect =  "pages/admin/SearchEmployee";
	
		}
		
		catch(Exception e){
				String msg = "Id does not Exist";
			m.addAttribute("errorMsg", msg);
		}
		
		return pageToRedirect;
	    
	}

	
	
	
	 @RequestMapping("/updateEmployee")
     public String getId(Model model){
	   //model.addAttribute("empBean",new EmployeeBean());
	   return "pages/admin/UpdateEmployee";
}
     
     @RequestMapping("/update")
 	public String updateById(@RequestParam("empId") int empId,Model m){
    	 
    	 String pageToRedirect = "pages/admin/ErrorPage";
    	 try{
    	 EmployeeBean empBean = adminService.searchById(empId) ;
 		System.out.println(empBean);
 		m.addAttribute("empBean", empBean);
 		
      // m.addAttribute("EmployeeDetails",new EmployeeBean());
		
		List<DepartmentBean> listDept = adminService.getAllDepartment();
		System.out.println(listDept);
		Map<Integer,String> mapDept = new LinkedHashMap<Integer,String>();
		
		for(DepartmentBean deptBean : listDept){
		mapDept.put(deptBean.getDeptId(),deptBean.getDeptName());
		
		}
		
		m.addAttribute("deptSet",mapDept);
	/*	=================================================================*/
		
		List<DesignationBean> listDesig = adminService.getAllDesig();
		System.out.println(listDesig);
		
		Map<Integer,String> mapDesign = new LinkedHashMap<Integer,String>();
		
		for(DesignationBean designBean : listDesig){
			mapDesign.put(designBean.getDesigId(),designBean.getDesigName());
			}
		
		m.addAttribute("designSet",mapDesign);
		
       List<String> maritalStatus = new ArrayList<String>();
		
		maritalStatus.add("Single");
		maritalStatus.add("Married");
		maritalStatus.add("Divorced");
		maritalStatus.add("Separated");
		maritalStatus.add("Widowed");
		
		m.addAttribute("maritalSet",maritalStatus);
		
 		return "pages/admin/UpdateDetailsForm"; 
    	 }
    	 catch(Exception e){
				String msg = "Id does not Exist";
			m.addAttribute("errorMsg", msg);
		}
		
		return pageToRedirect;
	    
	
     }
     
     @RequestMapping("/doUpdation")
  	public String updateDetails(@ModelAttribute("empBean")@Valid EmployeeBean empBean,BindingResult result, Model model){
  		
  	     	adminService.update(empBean);
  		
  			return "pages/admin/UpdateSuccess";
  		}
     
     @RequestMapping("/getAllEmployees")
     public String findAll(Model m){
     	
    	Long numOfRows = adminService.getEmployeeCount();

    	System.out.println("In Controller Number of rows "+numOfRows);
    	String numRows = String.valueOf(numOfRows);
    	int nr = Integer.parseInt(numRows);
    	
     	List<EmployeeBean> empList = adminService.retrieveAllDetails();
     	List<DepartmentBean> deptList = adminService.getAllDepartment();
     	List<DesignationBean> designList = adminService.getAllDesig();
     	
     	
     	for(EmployeeBean empBean : empList){
     		System.out.println("in controller"+empBean);
     		
     	}
     	
     	m.addAttribute("numOfRows",nr);
     	m.addAttribute("listofEmpl", empList);
     	m.addAttribute("listDept",deptList);
     	m.addAttribute("listDesig",designList);
     	
     	return ("pages/admin/SearchSuccess");
     }

     

	@RequestMapping("/logoutAdmin")
	public String logoutAction(HttpServletRequest req,Model m){
		
		System.out.println("in session logout function");
		HttpSession session = req.getSession();
		
		session.removeAttribute("logDetails");
		session.invalidate();
		
		return "redirect:../index.ems";
	}
	
	
}
