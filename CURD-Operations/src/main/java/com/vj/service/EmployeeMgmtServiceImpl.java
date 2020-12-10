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
}//class
