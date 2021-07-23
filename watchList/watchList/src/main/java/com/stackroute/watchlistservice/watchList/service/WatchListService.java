package com.stackroute.watchlistservice.watchList.service;

import java.util.List;
import java.util.Map;

import com.stackroute.watchlistservice.watchList.model.WatchList;

public interface WatchListService {
	/**
	 * AbstractMethod to createWatchList
	 */
	public WatchList createWatchList(String userName,String city,int totalInfections,int totalDeaths);
	/**
	 * AbstractMethod to deleteWatchList
	 */
	public Map deleteWatchList(String userName, String city);
	/**
	 * AbstractMethod to getAllWatchList
	 */
	public List<WatchList> getAllWatchList();

	/*
	 * this method is to get WatchList of a particular user
	 */
	public List<Map> getWatchListBasedOnUserName(String userName);


}
