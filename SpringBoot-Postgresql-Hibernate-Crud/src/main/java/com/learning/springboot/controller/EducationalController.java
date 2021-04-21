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
import com.learning.springboot.model.Educational;
import com.learning.springboot.repository.EducationalRepository;
import com.learning.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v3/")
public class EducationalController {
	
	@Autowired
	private EducationalRepository educationalRepository;
	
	@GetMapping("educational")
	public List<Educational> getAllEducational() {
		return this.educationalRepository.findAll();
	
	}
	
	@GetMapping("/educational/{id}")
	public ResponseEntity<Educational> geteducationalById(@PathVariable(value = "id") Long educationalId)
			throws ResourceNotFoundException {
		Educational educational = (Educational) educationalRepository.findById(educationalId).orElseThrow(
				() -> new ResourceNotFoundException("Educational not found for this id :: " + educationalId));
		return ResponseEntity.ok().body(educational);

	}

	public Educational createEducational(@RequestBody Educational educational) {
		return this.educationalRepository.save(educational);
	}


	@PutMapping("educational/{id}")
	public ResponseEntity<Educational> updateEducational(@PathVariable(value = "id") Long educationalId,
			@Validated @RequestBody Educational educationalDetails) throws ResourceNotFoundException {

		Educational educational = (Educational) educationalRepository.findById(educationalId).orElseThrow(
				() -> new ResourceNotFoundException("Educational not found for this id :: " + educationalId));

		educational.setType(educationalDetails.getType());
		educational.setStartdate(educationalDetails.getStartdate());
		educational.setEnddate(educationalDetails.getEnddate());
		educational.setInstitution(educationalDetails.getInstitution());
		educational.setAddress(educationalDetails.getAddress());
		educational.setPercentage(educationalDetails.getPercentage());

		return ResponseEntity.ok(this.educationalRepository.save(educational));
	}

	@DeleteMapping("educational/{id}")
	public Map<String, Boolean> deleteeducational(@PathVariable(value = "id") Long educationalId)
			throws ResourceNotFoundException {

		Educational educational = (Educational) educationalRepository.findById(educationalId).orElseThrow(
				() -> new ResourceNotFoundException("Educational not found for this id :: " + educationalId));

		this.educationalRepository.delete(educational);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);

		return response;

	}

}
