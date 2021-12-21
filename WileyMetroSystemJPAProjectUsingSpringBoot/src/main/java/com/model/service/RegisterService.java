package com.model.service;

import com.model.exception.CardNumberNotFoundException;

public interface RegisterService {
	public int registerPassenger() throws Exception;
	public boolean isValidCardOfPassenger(int cardNumber) throws CardNumberNotFoundException, Exception;
	public int checkBalance(int cardNumber) throws CardNumberNotFoundException;
	public boolean updateBalance(int balance,int cardNumber) throws CardNumberNotFoundException;
}
