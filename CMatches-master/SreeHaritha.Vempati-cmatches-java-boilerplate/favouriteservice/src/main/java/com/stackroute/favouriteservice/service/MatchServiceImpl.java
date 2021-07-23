package com.stackroute.favouriteservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.favouriteservice.domain.Match;
import com.stackroute.favouriteservice.exception.MatchAlreadyExistsException;
import com.stackroute.favouriteservice.exception.MatchNotFoundException;
import com.stackroute.favouriteservice.repository.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService {
	private final transient MatchRepository matchRepository;

	@Autowired
	public MatchServiceImpl(MatchRepository matchRepository) {
		super();
		this.matchRepository = matchRepository;
	}

	@Override
	public boolean saveMatch(Match match) throws MatchAlreadyExistsException {
		final Optional<Match> object = matchRepository.findByUniqueIdAndUserId(match.getUniqueId(), match.getUserId());
		if (object.isPresent()) {
			throw new MatchAlreadyExistsException("Could not save match, Match already exists");
		}
		matchRepository.save(match);
		return true;
	}

	@Override
	public boolean deleteMatchById(int  id) throws MatchNotFoundException {
		final Match match = matchRepository.findById(id).orElse(null);
		if (match == null) {
			throw new MatchNotFoundException("Could not delete. Match not found");
		}
		matchRepository.delete(match);
		return true;
	}
	

	@Override
	public List<Match> getMyMatches(String userId) {
		return matchRepository.findByUserId(userId);
	}

}
