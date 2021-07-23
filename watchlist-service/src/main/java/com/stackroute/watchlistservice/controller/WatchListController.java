package com.stackroute.watchlistservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.watchlistservice.model.WatchList;
import com.stackroute.watchlistservice.service.WatchListServiceImpl;

@RestController
@RequestMapping("api/v1")
public class WatchListController {
	@Autowired
	private WatchListServiceImpl watchListServiceList;

	@PostMapping("/addWatchList/{name}")
	public ResponseEntity<WatchList> saveWatchList(@PathVariable("name") String name,@RequestBody WatchList watchList) {
		return new ResponseEntity<>(watchListServiceList.addWatchList(watchList), HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteWatchList/{name}")
	public ResponseEntity<WatchList> delteWatchList(@PathVariable("name") String name) {
		return new ResponseEntity<>(watchListServiceList.deleteWatchList(name), HttpStatus.OK);
	}

}
