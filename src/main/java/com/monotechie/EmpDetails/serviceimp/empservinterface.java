package com.monotechie.EmpDetails.serviceimp;

import java.util.List;
import java.util.Map;

import com.monotechie.EmpDetails.model.Employee;

public interface empservinterface {
	
	
	
	public Employee addEmp(Employee emp);
	public Employee editEmp(long id);
	public Employee updateEmp(long id,Employee emp);
	public List<Employee> displayEmp();
	public Map<String,Boolean> delete(long id);

}
