package com.model.service;

import java.sql.Date;
import java.sql.Time;

import com.bean.Station;

public interface SwipeInService {
	public boolean swipeInCheckStatusOfPassenger(int cardNumber) throws Exception;
	public boolean swipeInPassenger(int cardNumber,Station station_id) throws Exception;
	public int checkPassengerBalance(int cardNumber) throws Exception;
	

}
