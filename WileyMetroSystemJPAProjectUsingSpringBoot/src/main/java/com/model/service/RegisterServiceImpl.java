package com.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bean.CardDetails;
import com.model.dao.RegisterDao;
import com.model.dao.SwipeInDao;
import com.model.exception.CardNumberNotFoundException;


@Service("registerService")
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	RegisterDao registerDao;
	
	public RegisterServiceImpl(RegisterDao registerDao) {
		super();
		this.registerDao = registerDao;
	}

	@Override
	public int registerPassenger() throws Exception {
		int maxCardNumber=registerDao.getMaxCardNumber();
		int cardNumber=maxCardNumber+1;
		int balance=100;
		CardDetails cardDetails=new CardDetails(cardNumber,balance);
		 CardDetails card=registerDao.save(cardDetails);
		 if(card!=null) {
			 return cardNumber;
		 }else {
			 return 0;
		 }
}

	@Override
	public boolean isValidCardOfPassenger(int cardNumber) throws Exception {
		int isValidCardStatus=registerDao.isValidCard(cardNumber);
		if(isValidCardStatus==cardNumber) {
			return true;
		}else {
		return false;
	}
	}

	@Override
	public int checkBalance(int cardNumber) throws CardNumberNotFoundException{
		return registerDao.checkBalance(cardNumber);
	}

	@Override
	public boolean updateBalance(int cardNumber, int balance) throws CardNumberNotFoundException {
		int fetchedbalance=registerDao.checkBalance(cardNumber);
		int updatebal=fetchedbalance+balance;
		int updated= registerDao.updateBalance(updatebal, cardNumber);
		if(updated>0) {
			return true;
		}else {
			return false;
		}
	}

	

}
