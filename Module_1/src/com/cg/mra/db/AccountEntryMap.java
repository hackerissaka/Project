package com.cg.mra.db;

import java.util.HashMap;

import com.cg.mra.beans.Account;

public class AccountEntryMap {
private static HashMap<String, Account> accountDb = new HashMap<String, Account>();

public static HashMap<String, Account> getAccountDb() {
	return accountDb;
}
	
	static{
		accountDb.put("9167891237", new Account("9167891237","Airtel","Rekha",245.56));
		accountDb.put("7167891237", new Account("7167891237","Idea","Rohit",128.56));
		accountDb.put("8167891237", new Account("8167891237","Reliance","Rama",125.56));
		accountDb.put("8967891237", new Account("8967891237","Aircel","Rita",456.56));
		accountDb.put("9867891237", new Account("9867891237","BSNL","Roshni",423.56));
		accountDb.put("9932012345", new Account("9932012345","BSNL","Manish",478.56));
	}

}
