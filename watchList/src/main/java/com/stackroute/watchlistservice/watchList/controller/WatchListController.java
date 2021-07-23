package com.stackroute.watchlistservice.watchList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.watchlistservice.watchList.model.WatchList;
import com.stackroute.watchlistservice.watchList.service.WatchListServiceImpl;

@RestController
@RequestMapping("api/v1")
public class WatchListController {
	private WatchListServiceImpl watchListServiceImpl;
	



	@GetMapping("/getAllWatchList")
	public ResponseEntity<List<WatchList>> getAllWatchList() {
		return new ResponseEntity<List<WatchList>>(
				(List<WatchList>) watchListServiceImpl.getAllWatchList(), HttpStatus.OK);
	}

	

	@PostMapping("/addWatchList")
	public ResponseEntity<?> addTheStockToFavourite(@RequestParam String userName, @RequestParam String place,@RequestParam int infections,@RequestParam int deaths) 
			 {

		
		return new ResponseEntity<>(watchListServiceImpl.createWatchList(userName, place, infections, deaths),
				HttpStatus.CREATED);

	}

	

	@DeleteMapping("/deleteFavouriteStock/{userName}")
	public ResponseEntity<?> getBlogAfterDeleting(@PathVariable String userName, @RequestParam String place) {

		return new ResponseEntity<>(watchListServiceImpl.deleteWatchList(userName, place), HttpStatus.OK);
	}
	@GetMapping("/byusername/{username}")
	public ResponseEntity<?> getByUserName(@PathVariable String userName)
	{
		return new ResponseEntity<>(watchListServiceImpl.findByName(userName),HttpStatus.OK);
	}

}
