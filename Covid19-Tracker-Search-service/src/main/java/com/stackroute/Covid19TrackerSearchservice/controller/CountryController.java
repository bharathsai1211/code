package com.stackroute.Covid19TrackerSearchservice.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.stackroute.Covid19TrackerSearchservice.model.Country;
import com.stackroute.Covid19TrackerSearchservice.model.service.CovidTrackerService;

@RestController
@RequestMapping("/country")
@CrossOrigin(value = "*")
public class CountryController {
//	@Autowired
//	private CovidTrackerService serviceImpl;
//	@Autowired
//    RestTemplate restTemplate = new RestTemplate();
//	@Autowired
//	public CountryController(com.stackroute.Covid19TrackerSearchservice.model.service.CovidTrackerService serviceImpl,RestTemplate restTemplate)
//	{
//		this.restTemplate=restTemplate;
//		this.serviceImpl=serviceImpl;
//	}
//	@GetMapping("/details")
//	public ResponseEntity<?> getInfo(@RequestParam(value = "country") String country) throws Exception
//	{
//		try {
//            String sym = this.serviceImpl.getCountry(country);
//            String url="https://api.covid19api.com/live/country/"+sym+"/status/confirmed";
//            
//            Country objects = restTemplate.getForObject(url, Country.class);
//            return new ResponseEntity<>(Arrays.asList(objects), HttpStatus.OK);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>("Country Not Found", HttpStatus.NOT_FOUND);
//        }
//	}
	@GetMapping("/hi")
	public ResponseEntity<String> print()
	{
		return new ResponseEntity<>("hi",HttpStatus.OK);
	}

}
