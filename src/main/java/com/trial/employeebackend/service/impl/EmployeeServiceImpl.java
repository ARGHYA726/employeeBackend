/**
 * 
 */
package com.trial.employeebackend.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.trial.employeebackend.exceptions.DetailsNotFoundException;
import com.trial.employeebackend.model.Address;
import com.trial.employeebackend.model.Employee;
import com.trial.employeebackend.repository.AddressRepository;
import com.trial.employeebackend.repository.EmployeeRepository;
import com.trial.employeebackend.service.EmployeeService;

/**
 * @author ARGSAHA
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Employee insertEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> listAllEmployees() {
		return employeeRepo.findAll();
	}
	@Override
	public Employee getTheEmployee(int id) throws DetailsNotFoundException {
		if(employeeRepo.existsById(id))
			return employeeRepo.findById(id).get();
		throw new DetailsNotFoundException("Not Found");
	}

	@Override
	public Employee updateEmployeeDetails(int id,Employee employee) throws DetailsNotFoundException {
		Optional<Employee> existingEmployee = employeeRepo.findById(id);
		if(existingEmployee!=null) {
			Employee oldEmployee = existingEmployee.get();
			//oldEmployee.setId(employee.getId());
			oldEmployee.setFirstName(employee.getFirstName());
			oldEmployee.setLastName(employee.getLastName());
			oldEmployee.setFatherName(employee.getFatherName());
			oldEmployee.setEmail(employee.getEmail());
			oldEmployee.setDateOfBirth(employee.getDateOfBirth());
			Iterator<Address> oldAddresses = oldEmployee.getAddress().iterator();
			Iterator<Address> newAddresses = employee.getAddress().iterator();
			while(newAddresses.hasNext()) {
				Address add = newAddresses.next();
				add.setAddressPrimaryKey(oldAddresses.next().getAddressPrimaryKey());
				addressRepo.save(add);
			}
			oldEmployee.setPhoneNumber(employee.getPhoneNumber());
			return employeeRepo.save(oldEmployee);
		}
		throw new DetailsNotFoundException("Not Found");
		
		
	}

	@Override
	public void deleteEmployee(int id) throws DetailsNotFoundException {
		
		// check whether a employee exist in a DB or not
		employeeRepo.findById(id).orElseThrow(() -> 
								new DetailsNotFoundException("Not Found"));
		employeeRepo.deleteById(id);
	}
	

}
