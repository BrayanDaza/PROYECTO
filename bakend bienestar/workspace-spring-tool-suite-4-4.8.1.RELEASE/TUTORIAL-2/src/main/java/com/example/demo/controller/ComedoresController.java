package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.model.Comedores;

import com.example.demo.repository.ComedoresRepository;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/")
public class ComedoresController {
	
	@Autowired
	private  ComedoresRepository ComedoresRepository;
	
	// get all 
		@GetMapping("/comedores")
		public List<Comedores> getAllexcusas(){
			return ComedoresRepository.findAll();
		}
		
		
//
		@PostMapping("/comedores")
	    public Comedores createExcusa(@RequestBody  Comedores comedores) {
	    	return ComedoresRepository.save(comedores);
	    	
	    }
		
		//get 
		@GetMapping("/comedores/{ide}")
	    public ResponseEntity< Comedores >getexcusasById(@PathVariable Long ide) {
			
			Comedores comedores = ComedoresRepository.findById(ide)
					.orElseThrow(() -> new ResourceNotFoundException("La cita no existe with id :"+ ide)); 	
	    	return ResponseEntity.ok(comedores);
	    }

	 // update employee rest api
		
	 	@PutMapping("/comedores/{ide}")
	 	public ResponseEntity<Comedores> updateExcusa(@PathVariable Long ide, @RequestBody Comedores exDetails){
	 		Comedores comedores = ComedoresRepository.findById(ide)
	 				.orElseThrow(() -> new ResourceNotFoundException("cita not exist with id :" + ide));
	 		
	 		
	 		comedores.setMotivoe(exDetails.getMotivoe());
	 		comedores.setFecha(exDetails.getFecha());
	 		comedores.setServiciotipo(exDetails.getServiciotipo());
	 		Comedores updatedExcusa = ComedoresRepository.save(comedores);
	 		return ResponseEntity.ok(updatedExcusa);
	 	}
	 	
	 // delete employee rest api
	 	@DeleteMapping("/comedores/{ide}")
	 	public ResponseEntity<Map<String, Boolean>> borrare(@PathVariable Long ide){
	 		Comedores comedores = ComedoresRepository.findById(ide)
	 				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + ide));
	 		
	 		ComedoresRepository.delete(comedores);
	 		Map<String, Boolean> response = new HashMap<>();
	 		response.put("deleted", Boolean.TRUE);
	 		return ResponseEntity.ok(response);
	 	}
	 	
	 	

}
