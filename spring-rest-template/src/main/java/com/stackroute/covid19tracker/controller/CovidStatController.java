package com.stackroute.covid19tracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.covid19tracker.model.CovidStat;
import com.stackroute.covid19tracker.model.Data;
import com.stackroute.covid19tracker.model.Regional;
import com.stackroute.covid19tracker.service.CovidStatService;

@RestController
@RequestMapping(value = "/api/v1/")
public class CovidStatController {

	private static final Logger logger = LoggerFactory.getLogger(CovidStatController.class);
	private CovidStatService covidStatService;

	@Autowired
	public CovidStatController(CovidStatService covidStatService) {
		this.covidStatService = covidStatService;
	}

	/*
	 * To retrieve the external api data
	 */
	@GetMapping("covidstat")
	public ResponseEntity<CovidStat> getCovidStat() {
		logger.info(".... Fetching the Covid Stat");
		ResponseEntity responseEntity;
		CovidStat retrievedCovidStat = covidStatService.getCovidStat();
		responseEntity = new ResponseEntity<CovidStat>(retrievedCovidStat, HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("covidstat/{loc}")
	public ResponseEntity<Regional> getCovidState(@PathVariable("loc") String loc) {
		logger.info(".... Fetching the Covid Stat by State");
		ResponseEntity responseEntity;
		CovidStat retrievedCovidStat = covidStatService.getCovidStat();
		Data data = retrievedCovidStat.getData();
		Regional[] regional = data.getRegional();
		for (Regional retrived : regional) {
			if (retrived.getLoc().equals(loc)) {
				responseEntity = new ResponseEntity<Regional>(retrived, HttpStatus.OK);
				return responseEntity;
			}
		}
		responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return responseEntity;
	}

}