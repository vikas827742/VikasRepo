package com.vj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.vj.dto.EmployeeDTO;
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

}//class
