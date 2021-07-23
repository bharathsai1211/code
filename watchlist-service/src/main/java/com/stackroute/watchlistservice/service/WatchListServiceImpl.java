package com.stackroute.watchlistservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.watchlistservice.model.WatchList;
import com.stackroute.watchlistservice.repository.WatchListRepository;

@Service
public class WatchListServiceImpl implements WatchListService {

	@Autowired
	private WatchListRepository watchListRepository;

	@Override
	public WatchList addWatchList(WatchList watchList) {
		return watchListRepository.save(watchList);
	}

	@Override
	public WatchList deleteWatchList(String name) {
		return watchListRepository.deleteByName(name);
	}

	

}
