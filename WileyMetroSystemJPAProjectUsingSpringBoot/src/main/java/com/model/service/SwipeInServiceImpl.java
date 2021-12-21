package com.model.service;

import java.sql.Date;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bean.Station;
import com.bean.Transaction;
import com.model.dao.RegisterDao;
import com.model.dao.StationDao;
import com.model.dao.SwipeInDao;

@Service("swipeInService")
public class SwipeInServiceImpl implements SwipeInService {
	@Autowired
	SwipeInDao swipeInDao;
	@Autowired
	RegisterDao registerDao;
	@Autowired
	StationDao stationDao;
	
	public SwipeInServiceImpl() {
		
	}

	

	public SwipeInServiceImpl(SwipeInDao swipeInDao, RegisterDao registerDao, StationDao stationDao) {
		super();
		this.swipeInDao = swipeInDao;
		this.registerDao = registerDao;
		this.stationDao = stationDao;
	}



	@Override
	public boolean swipeInCheckStatusOfPassenger(int cardNumber) throws Exception {
		Integer transaction= swipeInDao.swipeInCheckStatus(cardNumber);
		if(transaction!=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean swipeInPassenger(int cardNumber, Station station_id) throws Exception {
		LocalDateTime localDateTime=LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate date=localDateTime.toLocalDate();
		LocalTime time=localDateTime.toLocalTime();
		int balance=registerDao.checkBalance(cardNumber);
		int fine=0;
		if(balance>25) {
		Transaction transaction=new Transaction(cardNumber, station_id, time, date);
		Transaction swipeInPassengerStatus=swipeInDao.save(transaction);
		if(transaction!=null) {
		return true;
		}
	}
		
		throw new Exception("You dont Have Sufficent Balance to travel Please Recharge");
		
		
	}

	@Override
	public int checkPassengerBalance(int cardNumber) throws Exception {
		return registerDao.checkBalance(cardNumber);
	}


	

}
