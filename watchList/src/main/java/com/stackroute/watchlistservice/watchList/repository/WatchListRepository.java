package com.stackroute.watchlistservice.watchList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.watchlistservice.watchList.model.WatchList;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, String>{

	 List<WatchList> findByUserName(String userName);
}
