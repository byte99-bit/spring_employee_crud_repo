package com.monotechie.EmpDetails.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monotechie.EmpDetails.model.Employee;
import com.monotechie.EmpDetails.serviceimp.ServiceImpl;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class EmpController {
	
	@Autowired
	private ServiceImpl servimp;
	
	//add emp to db
	@PostMapping("/addEmp")
	public Employee addEmployee(@RequestBody Employee emp)
	{
		/*if(emp.getFirstname().isBlank() || emp.getLastname().isBlank() || emp.getEmail().isBlank())
		{
			return "Please enter all details correctly to add employee successfully";
		}*/
		return servimp.addEmp(emp);
		
	}
	
	//get a emp by id
	@GetMapping("/FetchEmp/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable long id)
    {
		Employee emp= servimp.editEmp(id);
		return ResponseEntity.ok(emp);
		
    }
	
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable long id,@RequestBody Employee emp)
	{ 
		
		Employee emp1= servimp.updateEmp(id,emp);
		return ResponseEntity.ok(emp1);
	}
	
	
	//get list of employees 
	@GetMapping("/displayEmp")
	public List<Employee> displayEmp()
	{
		return servimp.displayEmp();
	}
	
	
	//Delete empl by id
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmp(@PathVariable Long id)
	{
		Map<String,Boolean> response= servimp.delete(id);
		return ResponseEntity.ok(response);
	}

}
