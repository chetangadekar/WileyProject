package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Station {
	@Id
	public int stationId;
	public String stationName;
	
	public Station() {
		
	}
	public Station(int stationId, String stationName) {
		super();
		this.stationId = stationId;
		this.stationName = stationName;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Override
	public String toString() {
		return stationId +"." + stationName ;
	}
	
	
	

}
