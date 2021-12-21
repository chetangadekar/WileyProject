package com.model.service;

import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bean.Station;
import com.model.dao.StationDao;
import com.model.exception.NotValidStationException;

@Service("stationService")
public class StationServiceImpl implements StationService {
	@Autowired
	StationDao stationDao;
	

	public StationServiceImpl(StationDao stationDao) {
		super();
		this.stationDao = stationDao;
	}

	@Override
	public ArrayList<Station> StationList() throws Exception {
		ArrayList<Station> station=(ArrayList<Station>)(stationDao.findAll());
		if(station==null)
		{
			throw new NotValidStationException("Not a Valid Station");
		}
		return station;
	}
	

	@Override
	public boolean isValidStationOfPassenger(int stationId) throws Exception {
		int station= stationDao.isValidStation(stationId);
		if(station==stationId) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public String passengerStationName(int stationId) throws Exception {
		return stationDao.stationName(stationId);
	}



}
