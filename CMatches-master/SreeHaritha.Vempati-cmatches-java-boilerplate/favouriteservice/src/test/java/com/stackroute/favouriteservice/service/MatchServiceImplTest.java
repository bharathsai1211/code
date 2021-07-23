package com.stackroute.favouriteservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.favouriteservice.domain.Match;
import com.stackroute.favouriteservice.exception.MatchAlreadyExistsException;
import com.stackroute.favouriteservice.exception.MatchNotFoundException;
import com.stackroute.favouriteservice.repository.MatchRepository;


public class MatchServiceImplTest {
	@Mock
	private transient MatchRepository matchRepo;

	private transient Match match;

	@InjectMocks
	private transient MatchServiceImpl matchServiceImpl;

	transient Optional<Match> options;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		match = new Match(1, "India vs Pakistan","12345", "rohithakalla@gmail.com");
		options = Optional.of(match);
	}

	@Test
	public void testMockCreation() {
		assertNotNull("JpaRepository creation failed: use @InjectMocks on matchServiceImpl", match);
	}

	@Test
	public void testSavematchSuccess() throws MatchAlreadyExistsException {
		when(matchRepo.save(match)).thenReturn(match);
		final boolean flag = matchServiceImpl.saveMatch(match);
		assertTrue("saving match failed", flag);
		verify(matchRepo, times(1)).save(match);
	}
	@Test(expected = MatchAlreadyExistsException.class)
	public void testSaveMovieFailure() throws MatchAlreadyExistsException {
		when(matchRepo.findByUniqueIdAndUserId("12345", "rohithakalla@gmail.com")).thenReturn(options);
		when(matchRepo.save(match)).thenReturn(match);
		final boolean flag = matchServiceImpl.saveMatch(match);
		assertTrue("saving movie failed", flag);
		verify(matchRepo, times(1)).findByUniqueIdAndUserId(match.getUniqueId(),match.getUserId());
	}

	@Test
	public void testDeletematchById() throws MatchNotFoundException {
		when(matchRepo.findById(1)).thenReturn(options);
		doNothing().when(matchRepo).delete(match);
		final boolean flag = matchServiceImpl.deleteMatchById(1);
		assertTrue("deleting match failed", flag);
		verify(matchRepo, times(1)).delete(match);
		verify(matchRepo, times(1)).findById(match.getId());
	}


	@Test
	public void testGetAllmatches() throws MatchNotFoundException {
		final List<Match> matches = new ArrayList<>();
		matches.add(match);
		when(matchRepo.findByUserId(match.getUserId())).thenReturn(matches);
		final List<Match> matches1 = matchServiceImpl.getMyMatches("rohithakalla@gmail.com");
		assertEquals(matches, matches1);
		verify(matchRepo, times(1)).findByUserId("rohithakalla@gmail.com");
	}

}

