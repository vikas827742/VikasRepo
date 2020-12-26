package com.vj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.dto.EmployeeDTO;
import com.vj.model.EmployeeModel;
import com.vj.service.EmployeeMgmtService;
import com.vj.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeMgmtService service;
	@Autowired
	private EmployeeValidator validator;
    
	@GetMapping("/welcome.htm")
	public String showHome() {
		//return logical view name
		return "home";
	}//method
	
	@GetMapping("/list_emps.htm")
	public String showEmployess(Map<String, Object> map) {
		List<EmployeeDTO> listDTO = null;
		//use service
		listDTO = service.fetchAllEmployees();
		//keep result in model attribute
		map.put("empList", listDTO);
		
		return "show_report";
	}//method
	
	@GetMapping("/saveEmp.htm")
	public String showEmployeRegistrationForm(@ModelAttribute("empForm") EmployeeModel model) {
		System.out.println("EmployeeController.showEmployeRegistrationForm()");
		
		return "employee_register";
	}//method
	
	@PostMapping("/saveEmp.htm")
	public String saveEmployeeData(RedirectAttributes redirect,@ModelAttribute("empForm") EmployeeModel model,BindingResult error) {
		System.out.println("EmployeeController.saveEmployeeData()");
		EmployeeDTO dto = null;
		String result = null;
		
		System.out.println("vflag ::"+model.getVflag());
		if(model.getVflag().equalsIgnoreCase("no")) {  //enable server side form validations only when client form   validations are not done
		   //peform form validations
		   if(validator.supports(model.getClass()))
			    validator.validate(model, error);
		}
		
		// b.logic errors or application logic errors
		if (model.getJob().equalsIgnoreCase("netaji") || model.getJob().equalsIgnoreCase("actor"))
			error.rejectValue("job", "blocked.jobs");

		// if form validation errors are there.. launch form page
		if (error.hasErrors())
			return "employee_register";

		//convert to model data to dto
		dto = new EmployeeDTO();
		BeanUtils.copyProperties(model, dto);
		//use service
		result = service.registerEmployeeData(dto);
		//keep in results in flash attribute (Special map object)
		redirect.addFlashAttribute("resultMsg", result);
		
		return "redirect:list_emps.htm";
	}//method
	
	@GetMapping("/deleteEmp.htm")
	public String removeEmployeeData(RedirectAttributes redirect,@RequestParam int eno) {
		String result = null;
		//use service
		result = service.removeEmployeeById(eno);
		//add result to flash attribute
		redirect.addFlashAttribute("resultMsg", result);
		
		return "redirect:list_emps.htm";
	}//method
	
	@GetMapping("/editEmp.htm")
	public String showEditForm(@ModelAttribute("empForm") EmployeeModel model,@RequestParam int empNo) {
		EmployeeDTO dto=null;
		//use service
		dto=service.fetchEmployeeById(empNo);
		//convert dto to model
		 BeanUtils.copyProperties(dto, model);
		
		return "employee_edit";
	}
	
	@PostMapping("/editEmp.htm")
	public String updateEmployee(RedirectAttributes redirect,@ModelAttribute("empForm") EmployeeModel model,BindingResult error) {
		System.out.println(model.toString());
		EmployeeDTO dto = null;
		String result = null;
		
		System.out.println("vflag ::"+model.getVflag());
		if(model.getVflag().equalsIgnoreCase("no")) {  //enable server side form validations only when client form   validations are not done
		   //peform form validations
		   if(validator.supports(model.getClass()))
			    validator.validate(model, error);
		}
		
		// b.logic errors or application logic errors
		if (model.getJob().equalsIgnoreCase("netaji") || model.getJob().equalsIgnoreCase("actor"))
			error.rejectValue("job", "blocked.jobs");

		// if form validation errors are there.. launch form page
		if (error.hasErrors())
			return "employee_edit";

		//convert to model data to dto
		dto = new EmployeeDTO();
		BeanUtils.copyProperties(model, dto);
		/*dto.setEmpNo(model.getEmpNo());
		dto.setEname(model.getEname());
		dto.setJob(model.getJob());
		dto.setMgr(model.getMgr());
		dto.setHireDate(model.getHireDate());
		dto.setSal(model.getSal());
		dto.setComm(model.getComm());
		dto.setDeptNo(model.getDeptNo());*/
		//use service
		result = service.modifyEmployeeByNo(dto);
		//keep in results in flash attribute (Special map object)
		redirect.addFlashAttribute("resultMsg", result);
		
		return "redirect:list_emps.htm";
	}//method
	
	@ModelAttribute("deptInfo")  //constructing reference data/initial for select box
	public List<Integer>  populateDeptNos(){
		System.out.println("EmployeeController.populateDeptNos()");
		//use service
			return service.fetchAllDeptNos();
	}
}//class
