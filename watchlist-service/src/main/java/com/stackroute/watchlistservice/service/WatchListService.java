package com.stackroute.watchlistservice.service;

import com.stackroute.watchlistservice.model.WatchList;

public interface WatchListService {
	WatchList addWatchList(WatchList watchList);

	WatchList deleteWatchList(String name);
	
}
