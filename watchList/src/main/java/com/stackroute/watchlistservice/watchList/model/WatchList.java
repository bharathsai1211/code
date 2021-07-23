package com.stackroute.watchlistservice.watchList.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class WatchList {
	@Id
    private String userName;
    private List<Map> watchListArray = new ArrayList<Map>();
    private LocalDateTime createdAt;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Map> getWatchListArray() {
		return watchListArray;
	}
	public void setWatchListArray(List<Map> watchListArray) {
		this.watchListArray = watchListArray;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
