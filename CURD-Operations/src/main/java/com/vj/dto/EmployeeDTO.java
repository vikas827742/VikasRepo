package com.vj.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EmployeeDTO implements Serializable {
	private Integer serialNo;
	private Integer empNo;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hireDate;
	private Float sal;
	private Float comm;
	private Integer deptNo;
	private Float grossSal;
	private Float netSal;

}
