package com.example.demo.repo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MetroStations")
public class MetroStations {
	
	@Id
	@Column(nullable=false)
	private int StationId;
	
	@Column(nullable=false)
	private String StationName;
	
	public int getStationID() {
		return StationId;
	}
	
	public String getStationName() {
		return StationName;
	}
	

}
