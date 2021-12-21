package com.model.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bean.Station;
import com.bean.Transaction;

public interface SwipeOutDao extends JpaRepository<Transaction, Integer> {
//
//	@Query("select transactionId from Transaction where cardNumber=:cardNumber and swipeInTime is not null and swipeOutTime is null")
//	public int getTransactionId(@Param("cardNumber") int cardNumber);

	@Transactional
	@Modifying
	@Query(value="Update Transaction set swipeOutId=:stationId,SwipeOutTime=:swipeOutTime,swipeOutDate=:swipeOutDate,fare=:fare,fine=:fine where transactionId=:transactionId")
	public int UpdateTransaction(@Param("stationId")Station stationId,@Param("swipeOutTime")LocalTime time,@Param("swipeOutDate")LocalDate date,@Param("fare")int fare,@Param("fine")int fine,@Param("transactionId")int transactionId);

	@Query("select transactionId from Transaction where cardNumber=:cardNumber and swipeInTime is not null and swipeOutTime is null")
	public int transactionId(@Param("cardNumber")int cardNumber);
	
	@Query(value="select swipeInId from Transaction where cardNumber=:cardNumber and swipeInId is not null and swipeOutId is null", nativeQuery = true)
	public Integer swipeInId(@Param("cardNumber") int cardNumber);
	
	@Query(value="select fare from transaction where cardNumber=:cardNumber order by swipeOutTime desc limit 1",nativeQuery = true)
	public int getFare(@Param("cardNumber") int cardNumber);

}
