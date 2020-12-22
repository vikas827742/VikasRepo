package com.vj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vj.bo.EmployeeBO;
import com.vj.dao.EmployeeDAO;
import com.vj.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {
	@Autowired
	private EmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchAllEmployees() {
		List<EmployeeBO> listBO = null;
		List<EmployeeDTO> listDTO = new ArrayList();
		//use dao
		listBO = dao.getAllEmployees();
		//convert listbo to listdto
		listBO.forEach(bo->{
			EmployeeDTO dto = new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialNo(listDTO.size()+1);
			dto.setGrossSal(dto.getSal()+dto.getSal()*0.3f);
			dto.setNetSal(dto.getGrossSal()-dto.getGrossSal()*0.1f);
			
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method

	@Override
	public String registerEmployeeData(EmployeeDTO dto) {
		EmployeeBO bo = new EmployeeBO();
		int count = 0;
		String msg = null;
		//convert dto to bo
		BeanUtils.copyProperties(dto, bo);
		count = dao.insertEmployeeData(bo);
		if(count == 0) {
			msg = "Employee data is not registered";
		}
		else {
			msg = "Employee data is registered";
		}
		
		return msg;
	}//method

	@Override
	public String removeEmployeeById(int id) {
		int count = 0;
		String msg = null;
		//use dao
		count = dao.deleteEmployeeById(id);
		if(count == 0) {
			msg = "Employee data is not deleted";
		}
		else {
			msg = "Employee data is deleted";
		}
		
		return msg;
	}//method

	@Override
	public String modifyEmployeeByNo(EmployeeDTO dto) {
		int count = 0;
		String msg = null;
		EmployeeBO bo = null;
		//create obj
		bo = new EmployeeBO();
		//copy
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count = dao.updateEmployee(bo);
		if(count==0) {
			msg = "Employee data is not updated";
		}
		else {
			msg = "Employee data is updated";
		}
		
		return msg;
	}//method

	@Override
	public EmployeeDTO fetchEmployeeById(int id) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
	    //use DAO
		bo=dao.getEmployeeById(id);
		System.out.println(bo);
		// convert bo  to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		
		return dto;
	}//method
}//class
