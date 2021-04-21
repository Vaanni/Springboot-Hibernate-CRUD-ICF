package com.learning.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.exception.ResourceNotFoundException;
import com.learning.springboot.model.Employee;
import com.learning.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("employee")
	public List<Employee> getAllEmployee() {
		return this.employeeRepository.findAll();
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);

	}

	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@PutMapping("employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Validated@RequestBody Employee employeeDetails) throws ResourceNotFoundException
	{
		
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		
		employee.setFirstname(employeeDetails.getFirstname());
		employee.setLastname(employeeDetails.getLastname());
		employee.setEmplyomentid(employeeDetails.getEmplyomentid());
		employee.setStartdate(employeeDetails.getStartdate());
		employee.setDesignation(employeeDetails.getDesignation());
		employee.setDepartment(employeeDetails.getDepartment());
		employee.setEnddate(employeeDetails.getEnddate());
		employee.setStatus(employeeDetails.getStatus());
		employee.setDob(employeeDetails.getDob());
		employee.setReportingmanager(employeeDetails.getReportingmanager());
		employee.setGender(employeeDetails.getGender());
		employee.setBloodgroup(employeeDetails.getBloodgroup());
		employee.setAddress(employeeDetails.getAddress());
		
		
		return ResponseEntity.ok(this.employeeRepository.save(employee));
	}
		@DeleteMapping("employee/{id}")
		public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException
		{
			
			Employee employee = employeeRepository.findById(employeeId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
			
			this.employeeRepository.delete(employee);
			
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			
			return response;
				
		}
			
	}



