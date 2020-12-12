package com.vj.service;

import java.util.List;

import com.vj.dto.EmployeeDTO;

public interface EmployeeMgmtService {
	public abstract List<EmployeeDTO> fetchAllEmployees();
	public abstract String registerEmployeeData(EmployeeDTO dto);
	public abstract String removeEmployeeById(int id);

}
