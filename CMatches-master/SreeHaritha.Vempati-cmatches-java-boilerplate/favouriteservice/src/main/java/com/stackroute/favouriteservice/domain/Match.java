package com.stackroute.favouriteservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="cricket")
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "match_description")
	private String description;
	@Column(name = "name")
	private String name;
	@Column(name = "date")
	private String date;
	@Column(name = "team1")
	@JsonProperty("team-1")
	private String team1;
	@JsonProperty("team-2")

	@Column(name = "team2")
	private String team2;
	@Column(name="uniqueid")
	@JsonProperty("unique_id")

	private String uniqueId;
	@Transient
	private boolean favourite;
	@Column(name="userId")
	private String userId;
	

	public Match() {
		super();
	}
	
	public Match(int id, String description, String name, String date, String team1, String team2, String uniqueId,
			boolean favourite, String userId) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.date = date;
		this.team1 = team1;
		this.team2 = team2;
		this.uniqueId = uniqueId;
		this.favourite = favourite;
		this.userId = userId;
	}

	public Match(int id, String description, String uniqueId, String userId) {
		super();
		this.id = id;
		this.description = description;
		this.uniqueId = uniqueId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isFavourite() {
		return favourite;
	}
	public void setFavourite(boolean favourite) {
		this.favourite = favourite;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", description=" + description + ", uniqueId=" + uniqueId + ", userId="
				+ userId + "]";
	}
	
}

