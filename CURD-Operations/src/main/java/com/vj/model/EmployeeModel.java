package com.vj.model;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeModel {
	private Integer empNo;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hireDate;
    private Float sal=10000.0f;
    private Float comm;
    private Integer deptNo=10;
    private String  vflag="no";

}
