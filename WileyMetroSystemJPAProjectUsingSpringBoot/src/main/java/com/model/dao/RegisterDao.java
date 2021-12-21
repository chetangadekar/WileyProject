package com.model.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.CardDetails;

@Repository("registerDao")
public interface RegisterDao extends  JpaRepository<CardDetails, Integer> {
	
	@Query("SELECT MAX(cardNumber) FROM CardDetails")
	public int getMaxCardNumber();
	
	@Query("SELECT cardNumber FROM CardDetails WHERE cardNumber=:cardNumber")
	public int isValidCard(@Param("cardNumber")int cardNumber);
	
	@Query("select balance from CardDetails where cardNumber=:cardNumber")
	public int checkBalance(@Param("cardNumber") int cardNumber);


	@Transactional
	@Modifying
	@Query("update CardDetails set balance=:balance where cardNumber=:cardNumber")
	public int updateBalance(@Param("balance") int balance,@Param("cardNumber") int cardNumber);

}
