package com.vj.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vj.model.EmployeeModel;

@Component("empValidator")
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//useful to check whether expected command/model is recieved to validator class or not
        
		return clazz.isAssignableFrom(EmployeeModel.class);
	}//method

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("EmployeeValidator.validate(-,-)");
		EmployeeModel model=null;
		//type casting on command class obj
		model = (EmployeeModel)target;
		//write form validation logic
		
		if(model.getEname()==null ||  model.getEname().isEmpty()) {   //required rule
			errors.rejectValue("ename","emp.ename.required");   //errors obj hods property name, error message collected proepries file
		}
		else if(model.getEname().length()<5 || model.getEname().length()>10) {   //length
			errors.rejectValue("ename","emp.ename.length");
		}
		
		if(model.getJob()==null || model.getJob().isEmpty()) {   //required rule
			errors.rejectValue("job","emp.job.required");
		}
		else if(model.getJob().length()<5 || model.getJob().length()>10) {   //length
			errors.rejectValue("job","emp.job.length");
		}
		
		if(model.getSal()==null ) {   //required rule
			errors.rejectValue("sal","emp.sal.required");
		}
		else if(model.getSal()<10000 || model.getSal()>100000) {   //length
			errors.rejectValue("sal","emp.sal.range");
		}
		
	}//method
}//class
