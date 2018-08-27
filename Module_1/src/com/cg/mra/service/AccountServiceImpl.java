package com.cg.mra.service;


import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.MobileRechargeException;

public class AccountServiceImpl implements AccountService{
	/**
	 * Class Name : AccountServiceImpl;
	 * Interface implement: AccountService;
	 * Number of Method: 3
	 * Name of Method : getAccountDetails(), rechargeAccount(), validateMobile();
	 * Purpose: Data Access operation from AccountDao for Getting Details of specific Mobile Number;
	 * 
	 * Author: SwetaRani_152936;
	 * Date of Creation : 11-july-2018;
	 * 
	 * Last Date Of Modification : 11-july-2018;
	 */
	AccountDao accountDao = new AccountDaoImpl();
	@Override
	public Account getAccountDetails(String mobileNo)
			throws MobileRechargeException {
		
		return accountDao.getAccountDetails(mobileNo);
	}

	@Override
	public int rechargeAccount(String mobileno, double rechargeAmount)
			throws MobileRechargeException {
		Account account = accountDao.getAccountDetails(mobileno);
		 
		
		return  (int) ((int) account.getAccountBalance()+rechargeAmount);
	}
public boolean validateMobile(String mobile) throws MobileRechargeException{
		
		if(!mobile.matches("\\d{10}")){
			throw new MobileRechargeException("Mobile Number should contain 10 digits");
		}
		return true;
	}

}
