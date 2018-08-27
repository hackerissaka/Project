package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileRechargeException;

public interface AccountService {
 
	Account getAccountDetails(String mobileNo) throws MobileRechargeException;
	int rechargeAccount(String mobileno, double rechargeAmount) throws MobileRechargeException;
	boolean validateMobile(String mobile) throws MobileRechargeException;
}