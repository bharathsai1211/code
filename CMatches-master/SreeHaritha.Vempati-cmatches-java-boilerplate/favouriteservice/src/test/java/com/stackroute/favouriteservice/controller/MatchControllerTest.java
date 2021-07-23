package com.stackroute.favouriteservice.controller;



import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.favouriteservice.domain.Match;
import com.stackroute.favouriteservice.exception.MatchAlreadyExistsException;
import com.stackroute.favouriteservice.exception.MatchNotFoundException;
import com.stackroute.favouriteservice.service.MatchService;



@RunWith(SpringRunner.class)
@WebMvcTest(MatchController.class)
public class MatchControllerTest {
	@Autowired
	private transient MockMvc mvc;

	@MockBean
	private transient MatchService service;

	private transient Match match;

	@InjectMocks
	private MatchController controller;

	static List<Match> matches;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		matches = new ArrayList<>();
		match = new Match(1, "India vs Pakistan","12345", "rohithakalla@gmail.com");
		matches.add(match);
		match = new Match(2, "India vs austrila",  "123456","rohithakalla@gmail.com");
		matches.add(match);
	}

	@Test
	public void testSaveNewmatchSuccess() throws Exception {
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxMjM0NTYiLCJpYXQiOjE1MzY2NDIzNjh9.hWxT0EugLV4MG7NgL7roVR7fouzp3YVHuLEkCS3Mzb9O67eLC8Ulv6Qbg2vDOUv9";
		
		when(service.saveMatch(match)).thenReturn(true);
		mvc.perform(post("/api/v1/favouriteservice/match").header("authorization", "Bearer " + token).
				contentType(MediaType.APPLICATION_JSON).content(jsonToString(match)))
		.andExpect(status().isCreated());
		verify(service, times(1)).saveMatch(Mockito.any(Match.class));
		verifyNoMoreInteractions(service);
	}
	@Test
     public void testSaveNewmatchUnSuccessful() throws Exception{
		 
     when(service.saveMatch(Mockito.any(Match.class))).thenThrow(new MatchAlreadyExistsException("Match Already Exist"));
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxMjM0NTYiLCJpYXQiOjE1MzY2NDIzNjh9.hWxT0EugLV4MG7NgL7roVR7fouzp3YVHuLEkCS3Mzb9O67eLC8Ulv6Qbg2vDOUv9";
                                   
     mvc.perform(post("/api/v1/favouriteservice/match").header("authorization", "Bearer " + token)
                    .contentType(MediaType.APPLICATION_JSON).content(jsonToString(match))).andExpect(status().isConflict());
     verify(service, times(1)).saveMatch(Mockito.any(Match.class));
     verifyNoMoreInteractions(service);
                }



	@Test
	public void testDeletematchById() throws Exception {
		when(service.deleteMatchById(1)).thenReturn(true);
		mvc.perform(delete("/api/v1/favouriteservice/match/{id}", 1)).andExpect(status().isOk());
		verify(service, times(1)).deleteMatchById(1);
		verifyNoMoreInteractions(service);
	}
	@Test
     public void testDeleteMatchByIdUnsuccessful() throws Exception {
     when(service.deleteMatchById(278)).thenThrow(new MatchNotFoundException("Match Not Found"));
     mvc.perform(delete("/api/v1/favouriteservice/match/{id}",278)).andExpect(status().isNotFound());
     verify(service, times(1)).deleteMatchById(278);
     verifyNoMoreInteractions(service);
                }



	@Test
	public void testGetMyMatches() throws Exception {
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIxMjM0NTYiLCJpYXQiOjE1MzY2NDIzNjh9.hWxT0EugLV4MG7NgL7roVR7fouzp3YVHuLEkCS3Mzb9O67eLC8Ulv6Qbg2vDOUv9";
		when(service.getMyMatches("123456")).thenReturn(null);
		mvc.perform(get("/api/v1/favouriteservice/match").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(service, times(1)).getMyMatches("123456");
		verifyNoMoreInteractions(service);
	}

	private String jsonToString(final Object object) {
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			result = "Json processing error";
		}
		return result;
	}
}
