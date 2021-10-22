package com.example.demo.controller;


import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.citas;
import com.example.demo.repository.CitasRepository;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/")
public class CitasController {
	
	//LA CLASE ES citas

	@Autowired
	private  CitasRepository citasRepository;
	
	// get all 
	@GetMapping("/citas")
	public List<citas> getAllcitas(){
		return citasRepository.findAll();
	}	

	
	@PostMapping("/citas")
    public citas createCitas(@Validated @RequestBody citas cita ) {
		System.out.println(cita);
    	return citasRepository.save(cita);
    	
    }
	
	//get 
	@GetMapping("/citas/{id}")
    public ResponseEntity< citas >getcitasById(@PathVariable Long id) {
		
		citas cita = citasRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("La cita no existe with id :"+ id)); 	
    	return ResponseEntity.ok(cita);
    }

 // update employee rest api
	
 	@PutMapping("/citas/{id}")
 	public ResponseEntity<citas> updateEmployee(@PathVariable Long id, @RequestBody citas citaDetails){
 		citas cita = citasRepository.findById(id)
 				.orElseThrow(() -> new ResourceNotFoundException("cita not exist with id :" + id));
 		
 		
 		cita.setTipocita(citaDetails.getTipocita());
 		
 		citas updatedCita = citasRepository.save(cita);
 		return ResponseEntity.ok(updatedCita);
 	}
 	
 // delete employee rest api
 	@DeleteMapping("/citas/{idcita}")
 	public ResponseEntity<Map<String, Boolean>> borrarcita(@PathVariable Long idcita){
 		citas cita = citasRepository.findById(idcita)
 				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + idcita));
 		
 		citasRepository.delete(cita);
 		Map<String, Boolean> response = new HashMap<>();
 		response.put("deleted", Boolean.TRUE);
 		return ResponseEntity.ok(response);
 	}
 	
 	
 	
}


