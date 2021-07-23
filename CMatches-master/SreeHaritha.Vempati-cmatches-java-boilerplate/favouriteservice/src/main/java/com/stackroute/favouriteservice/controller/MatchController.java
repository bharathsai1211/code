package com.stackroute.favouriteservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favouriteservice.domain.Match;
import com.stackroute.favouriteservice.exception.MatchAlreadyExistsException;
import com.stackroute.favouriteservice.exception.MatchNotFoundException;
import com.stackroute.favouriteservice.service.MatchService;

import io.jsonwebtoken.Jwts;

@RestController
@RequestMapping("/api/v1/favouriteservice")
@CrossOrigin
public class MatchController {
	private MatchService matchService;

	@Autowired
	public MatchController(MatchService matchService) {
		super();
		this.matchService = matchService;
	}

	@PostMapping("/match")
	public ResponseEntity<?> saveNewMatch(@RequestBody final Match match, final HttpServletRequest request,
			final HttpServletResponse response) {
		ResponseEntity<?> responseEntity;
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userId = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		try {
			match.setUserId(userId);
			match.setFavourite(true);
			System.out.println(match.getUserId());
			System.out.println(match.getUniqueId());

			matchService.saveMatch(match);
			responseEntity = new ResponseEntity<Match>(match, HttpStatus.CREATED);
		} catch (MatchAlreadyExistsException e) {
			responseEntity = new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}",
					HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	@DeleteMapping(path = "/match/{id}")
	public ResponseEntity<?> deleteMatchById(@PathVariable("id") final int id) {
		ResponseEntity<?> responseEntity;
		try {
			matchService.deleteMatchById(id);
			responseEntity = new ResponseEntity<String>("{ \" message\": \"Match deleted successfully\"}", HttpStatus.OK);
		} catch (MatchNotFoundException e) {
			responseEntity = new ResponseEntity<String>("{ \"message\": \"" + e.getMessage() + "\"}",
					HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	

	@GetMapping("/match")
	public ResponseEntity<?> getMyMatches(final HttpServletRequest request, final HttpServletResponse response) {
		final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String userEmail = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		List<Match> matches = matchService.getMyMatches(userEmail);
		ResponseEntity<?> responseEntity = new ResponseEntity<List<Match>>(matches, HttpStatus.OK);
		return responseEntity;
	}
}
