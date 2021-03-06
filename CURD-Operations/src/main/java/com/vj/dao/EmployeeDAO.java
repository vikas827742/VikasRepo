package com.vj.dao;

import java.util.List;

import com.vj.bo.EmployeeBO;

public interface EmployeeDAO {
	public abstract List<EmployeeBO> getAllEmployees();	
	public abstract int insertEmployeeData(EmployeeBO bo);
	public abstract int deleteEmployeeById(int id);
	public abstract int updateEmployee(EmployeeBO bo);
	public abstract EmployeeBO getEmployeeById(int id);
	public abstract List<Integer> getAllDeptNos();

}
