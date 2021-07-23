package com.stackroute.watchlistservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WatchList {
	
	private String name;
	private String city;
	private int totalInfections;
	private int totalDeaths;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public String getName() { return name; } public void setName(String name) {
	 * this.name = name; }
	 */
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getTotalInfections() {
		return totalInfections;
	}

	public void setTotalInfections(int totalInfections) {
		this.totalInfections = totalInfections;
	}

	public int getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(int totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

}
