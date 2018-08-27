package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileRechargeException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {
	Scanner sc = new  Scanner(System.in);
	AccountService accountService = new AccountServiceImpl();
	public static void main(String[] args) {
		MainUI main = new MainUI();
		
		String option="";
		while(true){
			System.out.println("1. Account Balance Enquiry");
			System.out.println("2.Rechage Account");
			System.out.println("3. Exit");
			option=main.sc.nextLine();
			switch(option){
			case "1":
				main.AccountBalanceEnquiry();
				break;
			case "2":
				main.RechargeAccount();
				break;
			case "3":
				main.sc.close();
				System.exit(0);
				break;
			}
		}

	}
private void AccountBalanceEnquiry() {
	System.out.println("Enter Mobile no :");
	String mobile=sc.nextLine();
	try {
		boolean validate = accountService.validateMobile(mobile);
		if(validate){
		Account account = accountService.getAccountDetails(mobile);
		System.out.println("Your Current Balance is Rs. "+account.getAccountBalance());
		}
	} catch (MobileRechargeException e) {
		System.out.println();
		System.err.println(e.getMessage());
		System.out.println();
	}
	
}
private void RechargeAccount(){
	System.out.println("Enter Mobile no :");
	String mobile=sc.nextLine();
	System.out.println("Enter Recharge Amount :");
	double rechargeAmount=sc.nextDouble();
	try {
		boolean validate = accountService.validateMobile(mobile);
		if(validate){
			Account account = accountService.getAccountDetails(mobile);
			System.out.println("Your Account Recharged Successfully");
			System.out.println("Hello "+account.getCustomerName()+" ,Available Balance is "+accountService.rechargeAccount(mobile, rechargeAmount));
		}
	} catch (MobileRechargeException e) {
		System.out.println();
		System.err.println("ERROR: Cannot Recharge Account as Given Mobile No Does Not Exist");
		System.out.println();
	}
}
}
