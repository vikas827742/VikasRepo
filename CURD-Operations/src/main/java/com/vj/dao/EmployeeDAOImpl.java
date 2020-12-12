package com.vj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.vj.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_ALL_EMPLOYEES = "SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP";
	private static final String INSERT_EMPLOYEE_DATA = "INSERT INTO EMP(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) VALUES(?,?,?,?,?,?,?,?)";
	private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM EMP WHERE EMPNO=?";
	
	@Autowired
	private  JdbcTemplate jt;

	@Override
	public List<EmployeeBO> getAllEmployees() {
		List<EmployeeBO> listBO = null;
		listBO = jt.query(GET_ALL_EMPLOYEES, new ListEmployeeRowMapper());
		
		return listBO;
	}//method
	
	private class ListEmployeeRowMapper implements ResultSetExtractor<List<EmployeeBO>> {

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBO = new ArrayList();
			//copy rs record to bo
			while(rs.next()) {
				EmployeeBO bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEmpName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setMgr(rs.getInt(4));
				bo.setHireDate(rs.getDate(5));
				bo.setSal(rs.getFloat(6));
				bo.setComm(rs.getFloat(7));
				bo.setDeptNo(rs.getInt(8));
				listBO.add(bo);
			}//while
			
			return listBO;
		}//innerclassmethod
	}//innerclass

	@Override
	public int insertEmployeeData(EmployeeBO bo) {
		int count = 0;
		count = jt.update(INSERT_EMPLOYEE_DATA, bo.getEmpNo(),
				                                                                       bo.getEmpName(),
				                                                                       bo.getJob(),
				                                                                       bo.getMgr(),
				                                                                       bo.getHireDate(),
				                                                                       bo.getSal(),
				                                                                       bo.getComm(),
				                                                                       bo.getDeptNo());
		
		return count;
	}

	@Override
	public int deleteEmployeeById(int id) {
		int count = 0;
		count = jt.update(DELETE_EMPLOYEE_BY_ID, id);
		
		return count;
	}//method
}//outerclass
