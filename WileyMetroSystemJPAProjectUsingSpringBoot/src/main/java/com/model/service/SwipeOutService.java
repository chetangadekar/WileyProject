package com.model.service;

import java.sql.Date;
import java.sql.Time;

import com.bean.Station;

public interface SwipeOutService {
	public boolean swipeOutPassenger(int cardNumber,Station station_id) throws Exception;
	public int getFare(int cardNumber);
	}


