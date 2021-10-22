package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante;

import com.example.demo.repository.EstudianteRepository;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v3/")
public class EstudianteController {
	
	@Autowired
	private  EstudianteRepository estu;

	
	@GetMapping("/estudiante/{id}")
	public Estudiante getEstudiante(@PathVariable int id){
		return estu.findById(id).orElse(null);
	}	

}
