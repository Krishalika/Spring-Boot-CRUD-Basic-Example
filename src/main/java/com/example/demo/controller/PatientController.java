package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/patients")
	public List<Patient> list() {
		return service.listAll();
	}

	// RESTful API method for Create operation
	@PostMapping("/patients")
	public void add(@RequestBody Patient patient) {
		service.save(patient);
	}

	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient> get(@PathVariable Integer id) {
		try {
			Patient patient = service.get(id);
			return new ResponseEntity<Patient>(patient, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Update operation
	@PutMapping("/patients/{id}")
	public ResponseEntity<?> update(@RequestBody Patient patient, @PathVariable Integer id) {
		try {
			Patient existPatient = service.get(id);
			service.save(patient);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/patients/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}
