package com.model.service;

import java.util.ArrayList;

import com.bean.Station;

public interface StationService {
	public ArrayList<Station> StationList() throws Exception;
	public boolean isValidStationOfPassenger(int stationId) throws Exception;
	public String passengerStationName(int stationId) throws Exception;

}
