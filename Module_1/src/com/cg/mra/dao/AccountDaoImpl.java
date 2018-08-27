package com.cg.mra.dao;

import java.util.HashMap;

import com.cg.mra.beans.Account;
import com.cg.mra.db.AccountEntryMap;
import com.cg.mra.exception.MobileRechargeException;

public class AccountDaoImpl implements AccountDao {
	/**
	 * Class Name : AccountDaoImpl;
	 * Interface implement: AccountDao;
	 * Number of Method: 2;
	 * Name of Method : getAccountDetails(), rechargeAccount();
	 * Purpose: Data Access operation from AccountEntryMap for Getting Details of specific Mobile Number;
	 * 
	 * Author: SwetaRani_152936;
	 * Date of Creation : 11-july-2018;
	 * 
	 * Last Date Of Modification : 11-july-2018;
	 */

	static HashMap<String, Account> accountEntryMap = AccountEntryMap.getAccountDb();
	
	@Override
	public Account getAccountDetails(String mobileNo)
			throws MobileRechargeException {
	/**
	 * Name of Method: getAccountDetails()
	 * Parameter Expected: MobileNo
	 * Return Type: Account object;
	 * 
	 * Author: SwetaRani_152936;
	 * Date of Creation : 11-july-2018;
	 * 
	 * Last Date Of Modification : 11-july-2018;
	 * 
	 * purpose: To accept Mobile Number from user and display details
	 */
		Account account = accountEntryMap.get(mobileNo);
		if(account==null){
			throw new MobileRechargeException("ERROR: Given Account id Does Not Exist");
		}
		return account;
	}

	@Override
	public int rechargeAccount(String mobileno, double rechargeAmount)
			throws MobileRechargeException {
		/**
		 * Name of Method: rechargeAccount()
		 * Parameter Expected: MobileNo, rechargeAmount
		 * Return Type: int;
		 * 
		 * Author: SwetaRani_152936;
		 * Date of Creation : 11-july-2018;
		 * 
		 * Last Date Of Modification : 11-july-2018;
		 * 
		 * purpose: To accept Mobile Number from user and update accountbalance and add rechargeamount
		 */
		Account account = accountEntryMap.get(mobileno);
		if(account==null){
			throw new MobileRechargeException("ERROR: Cannot Recharge Account as Given Mobile No Does Not Exist");
		}
		return (int) account.getAccountBalance();
		
		
	}

}
