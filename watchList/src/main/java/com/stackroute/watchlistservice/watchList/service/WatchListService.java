package com.stackroute.watchlistservice.watchList.service;

import java.util.List;
import java.util.Map;

import com.stackroute.watchlistservice.watchList.model.WatchList;

public interface WatchListService {
	

	public WatchList createWatchList(String userName,String place,int infections,int deaths);

	
	public Map deleteWatchList(String userName, String place);

	

	public List<WatchList> getAllWatchList();
	public List<WatchList> findByName(String userName);
	

}
