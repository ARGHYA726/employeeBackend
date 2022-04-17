/**
 * 
 */
package com.trial.employeebackend.service;

import java.util.List;

import com.trial.employeebackend.exceptions.DetailsNotFoundException;
import com.trial.employeebackend.model.Employee;

/**
 * @author ARGSAHA
 *
 */
public interface EmployeeService {

	Employee insertEmployee(Employee employee);

	List<Employee> listAllEmployees();

	Employee getTheEmployee(int id) throws DetailsNotFoundException;

	Employee updateEmployeeDetails(int id,Employee employee) throws DetailsNotFoundException;

	void deleteEmployee(int id) throws DetailsNotFoundException;
	

}
