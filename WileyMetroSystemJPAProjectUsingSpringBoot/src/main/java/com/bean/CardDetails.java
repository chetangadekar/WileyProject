package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class CardDetails {
	
		@Id
		private int cardNumber;
		private int balance;

		public CardDetails() {
			
		}
		
		
		public CardDetails(int cardNumber, int balance) {
			super();
			this.cardNumber = cardNumber;
			this.balance = balance;
		}


		public int getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(int cardNumber) {
			this.cardNumber =cardNumber;
			
		}
		public void setBalance(int balance) {
			this.balance =balance;
			
		}
		
		public int getBalance() {
			return balance;
		}


		@Override
		public String toString() {
			return "CardDetails [cardNumber=" + cardNumber + ", balance=" + balance + "]";
		}
		

}
