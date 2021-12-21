package com.model.service;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.CardDetails;
import com.bean.Station;
import com.bean.Transaction;
import com.model.dao.RegisterDao;
import com.model.dao.StationDao;
import com.model.dao.SwipeOutDao;

@Service("swipeOutService")
public class SwipeOutServiceImpl implements SwipeOutService {
	@Autowired
	SwipeOutDao swipeOutDao;
	@Autowired
	RegisterDao registerDao;
	@Autowired
	StationDao stationDao;


	public SwipeOutServiceImpl(SwipeOutDao swipeOutDao) {
		super();
		this.swipeOutDao = swipeOutDao;
	}


	@Override
	public boolean swipeOutPassenger(int cardNumber, Station station) throws Exception {
//		int transactionId = swipeOutDao.getTransactionId(cardNumber);
		LocalDateTime localDateTime=LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate date=localDateTime.toLocalDate();
		LocalTime time=localDateTime.toLocalTime();
		int transactionId=swipeOutDao.transactionId(cardNumber);
		int swipeInId=swipeOutDao.swipeInId(cardNumber);
		int fare=Math.abs(station.getStationId()-swipeInId)*10;
		int fine=0;
		int rows=swipeOutDao.UpdateTransaction(station, time, date, fare, fine,transactionId);
		if(rows>0) {
			int balance=registerDao.checkBalance(cardNumber);
		int finalbalance=balance-(fare+fine);
		CardDetails card=new CardDetails(cardNumber,finalbalance);
		registerDao.save(card);
		
			return true;
		}
	return false;	
	}


	@Override
	public int getFare(int cardNumber) {
		return swipeOutDao.getFare(cardNumber);
	}


	
	



}
