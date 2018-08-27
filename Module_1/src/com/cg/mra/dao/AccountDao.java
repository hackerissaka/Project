package com.cg.mra.dao;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileRechargeException;

public interface AccountDao {

	Account getAccountDetails(String mobileNo) throws MobileRechargeException;
	int rechargeAccount(String mobileno, double rechargeAmount) throws MobileRechargeException;
}
