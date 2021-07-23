package com.stackroute.recommendation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.recommendation.model.Recommended;
import com.stackroute.recommendation.service.RecommendedService;


@RestController							 //This annotation is applied to a class to mark it as a request handler.
@RequestMapping("/api/recom")           //We can use it with class definition to create the base URI
@CrossOrigin(value = "*") 			   // This annotation marks the annotated method or type as permitting cross origin requests
public class RecommendedController {
	
	@Autowired

	//This can be used to Auto wire bean on the setter method
	private RecommendedService recommendedService;


	/*
	 * http://localhost:8003/api/recom (Get)
	 * End point for getting list of all recommended players from the DB
	 * If retrieved data successfully returning status as OK
	 * Otherwise returning status as Conflict
	 */
	
	@GetMapping
	public ResponseEntity<?> getAllPlayers() {
		try {
			return new ResponseEntity<List<Recommended>>(recommendedService.getAllData(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("no", HttpStatus.CONFLICT);
		}
	}
	
	/*
	 * http://localhost:8003/api/recom (Post)
	 * End point for increasing the player recommended count by 1 in the DB
	 * If increased successfully returning status as Created (201)
	 * Otherwise returning status as Conflict
	 */
	
	@PostMapping    
	public ResponseEntity<String> addData(@RequestBody Recommended recoms) {
		try {
			if (recommendedService.addData(recoms)) {
				return new ResponseEntity<String>("ok", HttpStatus.CREATED);
			} else
				return new ResponseEntity<String>("no", HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);
		}
	}
	

	/*
	 * http://localhost:8003/api/recom (Delete)
	 * End point for decreasing the count of a player from the DB
	 * If decreased successfully returning status as Created (201)
	 * Otherwise returning status as Not_found
	 */
	
	@DeleteMapping
	public ResponseEntity<String> deleteData(@RequestParam("id") int id) {
		try {
			if (recommendedService.removeData(id)) {
				return new ResponseEntity<String>("ok", HttpStatus.OK);
			} else
				return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("no", HttpStatus.NOT_FOUND);

		}
	}
}
