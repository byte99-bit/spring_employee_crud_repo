package com.monotechie.EmpDetails.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.monotechie.EmpDetails.exception.ResourceNotFoundException;
import com.monotechie.EmpDetails.model.Employee;
import com.monotechie.EmpDetails.repo.EmpRepo;


@Service
public class ServiceImpl implements empservinterface {

	
	
	 @Autowired
	 public EmpRepo repo;
	 
	@Override
	public Employee addEmp(Employee emp) {
		// TODO Auto-generated method stub
		
		
		return  repo.save(emp);
	}

	@Override
	public Employee editEmp(long empid) {
		// TODO Auto-generated method stub
		
		Employee emp=repo.findById(empid).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+empid));
		return emp;
	}

	@Override
	public List<Employee> displayEmp() {
		// TODO Auto-generated method stub
		
		List<Employee> emplist=repo.findAll();
		return emplist;
	}

	@Override
	public Map<String,Boolean> delete(long empid) {
		// TODO Auto-generated method stub
		Employee emp=repo.findById(empid).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+empid));
		repo.delete(emp);
		Map<String,Boolean> response=new  HashMap<>();
		response.put("Employee Record Deleted Successfully", Boolean.TRUE);
		return response;
	}

	public Employee updateEmp(long id,Employee emp) {
		Employee emp1=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
			
			emp1.setFirstname(emp.getFirstname());
			emp1.setLastname(emp.getLastname());
			emp1.setEmail(emp.getEmail());
		    repo.save(emp1);
		    return emp1;
	
	}

}
