package com.vj.bo;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeBO {
	private Integer empNo;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hireDate;
	private Float sal;
	private Float comm;
	private Integer deptNo;

}
