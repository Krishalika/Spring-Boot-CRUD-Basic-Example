package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

@Service
@Transactional
public class PatientService {

	@Autowired
	private PatientRepository repo;

	public List<Patient> listAll() {
		return repo.findAll();
	}

	public void save(Patient patient) {
		repo.save(patient);
	}

	public Patient get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
}