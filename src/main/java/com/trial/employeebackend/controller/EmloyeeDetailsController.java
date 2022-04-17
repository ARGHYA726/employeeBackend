/**
 * 
 */
package com.trial.employeebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trial.employeebackend.exceptions.DetailsNotFoundException;
import com.trial.employeebackend.model.Employee;
import com.trial.employeebackend.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author ARGSAHA
 *
 */
@RestController
@RequestMapping("/rest/employees")
public class EmloyeeDetailsController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.insertEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.listAllEmployees();
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Get an Employee Object by given id",
	  notes = "It returns an Employee object",
	  response = Employee.class)
	public ResponseEntity<Employee> getById(@ApiParam(value = "Id for Employee you need to retrieve", required=true) @PathVariable("id") int id) throws DetailsNotFoundException{
		return new ResponseEntity<Employee>(employeeService.getTheEmployee(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) throws DetailsNotFoundException{
		return new ResponseEntity<Employee>(employeeService.updateEmployeeDetails(id,employee),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) throws DetailsNotFoundException{
		
		// delete employee from DB
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}
	

}
