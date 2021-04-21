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
import com.learning.springboot.model.Dependents;
import com.learning.springboot.model.Employee;
import com.learning.springboot.repository.DependentsRepository;
import com.learning.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v2/")
public class DependentsController {

	@Autowired
	private DependentsRepository dependentsRepository;

	@GetMapping("dependents")
	public List<Dependents> getAllDependents() {
		return this.dependentsRepository.findAll();
	}

	@GetMapping("/dependents/{id}")
	public ResponseEntity<Dependents> getDependentsById(@PathVariable(value = "id") Long dependentsId)
			throws ResourceNotFoundException {
		Dependents dependents = dependentsRepository.findById(dependentsId).orElseThrow(
				() -> new ResourceNotFoundException("Dependents not found for this id :: " + dependentsId));
		return ResponseEntity.ok().body(dependents);

	}

	public Dependents createDependents(@RequestBody Dependents dependents) {
		return this.dependentsRepository.save(dependents);
	}

	@PutMapping("dependents/{id}")
	public ResponseEntity<Dependents> updateDependents(@PathVariable(value = "id") Long dependentsId,
			@Validated @RequestBody Dependents dependentsDetails) throws ResourceNotFoundException {

		Dependents dependents = dependentsRepository.findById(dependentsId).orElseThrow(
				() -> new ResourceNotFoundException("Dependents not found for this id :: " + dependentsId));

		dependents.setFirstname(dependentsDetails.getFirstname());
		dependents.setLastname(dependentsDetails.getLastname());
		dependents.setDob(dependentsDetails.getDob());
		dependents.setGender(dependentsDetails.getGender());
		dependents.setRelationship(dependentsDetails.getRelationship());

		return ResponseEntity.ok(this.dependentsRepository.save(dependents));
	}

	@DeleteMapping("dependents/{id}")
	public Map<String, Boolean> deleteDependents(@PathVariable(value = "id") Long dependentsId)
			throws ResourceNotFoundException {

		Dependents dependents = dependentsRepository.findById(dependentsId).orElseThrow(
				() -> new ResourceNotFoundException("Dependents not found for this id :: " + dependentsId));

		this.dependentsRepository.delete(dependents);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;

	}

}
