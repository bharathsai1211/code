package com.stackroute.recommended.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.recommendation.model.Recommended;
import com.stackroute.recommendation.repository.RecommendedRepository;
import com.stackroute.recommendation.service.RecommendedService;

public class RecommendationServiceTest {

	@Mock
    RecommendedRepository recommendedRepository;
	
	Recommended recommended;
	
	@InjectMocks
   RecommendedService recommendedService;
	
	@Before
	public void setUp() {
       MockitoAnnotations.initMocks(this);
       recommended = new Recommended();
		recommended.setPid(1234);
		recommended.setName("Sachin");
		recommended.setFullName("Sachin Tendulkar");
		recommended.setCurrentAge("42 years");
		recommended.setCountry("India");
		recommended.setPlayingRole("Opener");
		recommended.setMajorTeams("India, Mumbai Indians");
		recommended.setImageURL("sampleimage.jpeg");
	}
	@Test
   public void addRecomSuccess(){
       when(recommendedRepository.save((Recommended) any())).thenReturn(recommended);
       Recommended recomSaved = recommendedRepository.save(recommended);
       assertEquals(recommended, recomSaved);
   }
}
