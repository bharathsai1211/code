package com.stackroute.favouriteservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.favouriteservice.domain.Match;

public interface MatchRepository extends JpaRepository<Match, Integer>{

	Optional<Match> findByUniqueId(String uniqueId);

	List<Match> findByUserId(String userId);

	Optional<Match> findByUniqueIdAndUserId(String uniqueId, String getUserId);


}
