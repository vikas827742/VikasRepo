package com.vj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeMgmtService service;
    
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
	public String removeEmployeeData(RedirectAttributes redirect,@RequestParam int empNo) {
		String result = null;
		//use service
		result = service.removeEmployeeById(empNo);
		//add result to flash attribute
		redirect.addFlashAttribute("resultMsg", result);
		
		return "redirect:list_emps.htm";
	}
}//class
