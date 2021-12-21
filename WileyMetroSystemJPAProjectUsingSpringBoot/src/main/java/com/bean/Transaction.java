package com.bean;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private int cardNumber;
	@OneToOne
	@JoinColumn(name = "SwipeInId")
	private Station SwipeInId;
	private LocalTime swipeInTime;
	private LocalDate swipeInDate;
	@OneToOne
	@JoinColumn(name="swipeOutId")
	private Station swipeOutId;
	private LocalTime swipeOutTime;
	private LocalDate swipeOutDate;
	@Column(insertable = false)
	private int fare;
	@Column(insertable = false)
	private int fine;
	
	public Transaction() {
		
	}
	
	
	public Transaction( int cardNumber, Station swipeInId, LocalTime swipeInTime, LocalDate swipeInDate) {
		super();
		this.cardNumber = cardNumber;
		SwipeInId = swipeInId;
		this.swipeInTime = swipeInTime;
		this.swipeInDate = swipeInDate;
	}
	
	

	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Station getSwipeInId() {
		return SwipeInId;
	}
	public void setSwipeInId(Station swipeInId) {
		SwipeInId = swipeInId;
	}
	public LocalTime getSwipeInTime() {
		return swipeInTime;
	}
	public void setSwipeInTime(LocalTime swipeInTime) {
		this.swipeInTime = swipeInTime;
	}
	public LocalDate getSwipeInDate() {
		return swipeInDate;
	}
	public void setSwipeInDate(LocalDate swipeInDate) {
		this.swipeInDate = swipeInDate;
	}
	public Station getSwipeOutId() {
		return swipeOutId;
	}
	public void setSwipeOutId(Station swipeOutId) {
		this.swipeOutId = swipeOutId;
	}
	public LocalTime getSwipeOutTime() {
		return swipeOutTime;
	}
	public void setSwipeOutTime(LocalTime swipeOutTime) {
		this.swipeOutTime = swipeOutTime;
	}
	public LocalDate getSwipeOutDate() {
		return swipeOutDate;
	}
	public void setSwipeOutDate(LocalDate swipeOutDate) {
		this.swipeOutDate = swipeOutDate;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", cardNumber=" + cardNumber + ", SwipeInId=" + SwipeInId
				+ ", swipeInTime=" + swipeInTime + ", swipeInDate=" + swipeInDate + ", swipeOutId=" + swipeOutId
				+ ", swipeOutTime=" + swipeOutTime + ", swipeOutDate=" + swipeOutDate + ", fare=" + fare + ", fine="
				+ fine + "]";
	}

	
	
}