package com.stackroute.favourites.service;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.favourites.model.Favourites;
import com.stackroute.favourites.repository.FavouritesRepository;

public class FavouritesServiceTest {

	@Mock
    FavouritesRepository favouritesRepository;
	
	Favourites favourites;
	
	@InjectMocks
   FavouritesService favouritesService;
	
	@Before
	public void setUp() {
       MockitoAnnotations.initMocks(this);
       favourites = new Favourites();
		favourites.setPid(1234);
		favourites.setName("Sachin");
		favourites.setFullName("Sachin Tendulkar");
		favourites.setCurrentAge("42 years");
		favourites.setCountry("India");
		favourites.setPlayingRole("Opener");
		favourites.setMajorTeams("India, Mumbai Indians");
		favourites.setImageURL("sampleimage.jpeg");
		favourites.setUsername("shivaagn@in.ibm.com");
		favourites.setStatus(true);
	}
	@Test
   public void addFavSuccess(){
       when(favouritesRepository.save((Favourites) any())).thenReturn(favourites);
       Favourites favSaved = favouritesRepository.save(favourites);
       assertEquals(favourites, favSaved);
   }
}
