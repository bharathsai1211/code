package com.stackroute.watchlistservice.watchList.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.watchlistservice.watchList.model.WatchList;
import com.stackroute.watchlistservice.watchList.service.WatchListServiceImpl;
/**
 * RestController annotation is used to create Restful web services.
 * It combines @Controller and @ResponseBody and eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping("api/v1")
public class WatchListController {
	/**
	 * Injecting the object dependency implicity
	 */
	@Autowired
	private WatchListServiceImpl watchListServiceImpl;


	/**
	 *  GetAllThe List of WatchList in the db.
	 */


	// Get requests matched with given URL expression
	@GetMapping("/WatchLists")
	public ResponseEntity<List<WatchList>> getAllWatchList() {
		return new ResponseEntity<List<WatchList>>(
				(List<WatchList>) watchListServiceImpl.getAllWatchList(), HttpStatus.OK);
	}

	/*
	 * Method to get WatchList of a particular user
	 */

	@GetMapping("/WatchList")
	public ResponseEntity<?> getWatchListOfParticularUser(@RequestParam String userName)
	{
		return new ResponseEntity<>(watchListServiceImpl.getWatchListBasedOnUserName(userName), HttpStatus.OK);
	}



	/**
	 *  save addWatchList in the db.
	 */
	// POST requests matched with given URL expression
	@PostMapping("/watchList")
	public ResponseEntity<?> addWatchList(@RequestParam String userName, @RequestParam String city,@RequestParam String totalInfections,@RequestParam String totalDeaths)
			 {
			 	int totalInfection1=Integer.parseInt(totalInfections);
			 	int totalDeath1=Integer.parseInt(totalDeaths);

		return new ResponseEntity<>(watchListServiceImpl.createWatchList(userName, city, totalInfection1, totalDeath1),
				HttpStatus.OK);

	}

	/**
	 *
	 * deleting a watchlist of a particular username
	 * if deleted data succesfully returning status
	 */
	//maps Http Delete request onto specific userName
	@DeleteMapping("/watchList/{userName}")
	public ResponseEntity<?> getBlogAfterDeleting(@PathVariable String userName, @RequestParam String city) {

		return new ResponseEntity<>(watchListServiceImpl.deleteWatchList(userName, city), HttpStatus.OK);
	}

}
