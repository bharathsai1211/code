package com.stackroute.watchlistservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.watchlistservice.model.WatchList;

public interface WatchListRepository extends JpaRepository<WatchList, String> {

	WatchListRepository findByCity(String city);

	WatchList deleteByCity(String city);

	WatchList deleteByName(String name);

}
