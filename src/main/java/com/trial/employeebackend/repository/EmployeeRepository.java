/**
 * 
 */
package com.trial.employeebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trial.employeebackend.model.Employee;

/**
 * @author ARGSAHA
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
