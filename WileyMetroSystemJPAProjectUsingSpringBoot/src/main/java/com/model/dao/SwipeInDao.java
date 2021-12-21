package com.model.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bean.Transaction;

@Repository("swipeInDao")
public interface SwipeInDao extends JpaRepository<Transaction, Integer> {
	
	@Query("SELECT cardNumber  FROM Transaction where cardNumber=:cardNumber and SwipeInId is not null and swipeOutId is null")
	public Integer swipeInCheckStatus(@Param("cardNumber") int cardNumber);
//
//	@Query("select MAX(transactionId) from Transaction")
//	public int maxTransaction();
	
	

}
