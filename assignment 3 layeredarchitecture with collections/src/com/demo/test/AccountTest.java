package com.demo.test;

import java.util.Scanner;

import com.demo.bean.Account;
import com.demo.bean.current;
import com.demo.bean.savings;
import com.demo.exception.InsufficientBalanceException;
import com.demo.exception.LimitExceedException;
import com.demo.exception.UserNotFoundException;
import com.demo.service.AccountService;
import com.demo.service.AccountServiceImpl;

public class AccountTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		AccountService accountService=new AccountServiceImpl();
	

		//customer menu
		int choice;
		do{			
			System.out.println("Enter the number: \n"
					+ "(1) create account \n "
					+ "(2) withdraw \n"
					+ "(3) deposit\n "
					+ "(4) display account by id\n"
					+ " (5) transfer \n"
					+ "(6) change pin \n"
					+ "(0) exit"); 
			choice=sc.nextInt();
			switch(choice) {
			case 1: 
				try {
					accountService.acceptAccountData();
				} catch (LimitExceedException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2: 
				System.out.println("Enter account id");
				String id=sc.next();
				System.out.println("Enter withdraw amount");
				Double amt=sc.nextDouble();
				try {
					accountService.withdraw(id,amt);
				} catch (InsufficientBalanceException e) {
					System.out.println(e.getMessage());
				} catch (UserNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3: 
				System.out.println("Enter account id");
				id=sc.next();
				System.out.println("Enter deposit amount");
				amt=sc.nextDouble();
				try {
					accountService.deposit(id,amt);
				} catch (UserNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 4: 
				System.out.println("Enter account id");
				id=sc.next();
				try {
					accountService.displayAccount(id);
				} catch (UserNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 5: 
				System.out.println("Enter your account id");
				id=sc.next();
				System.out.println("Enter transfer amount");
				amt=sc.nextDouble();
				try {
					accountService.transfer(id,amt);
				} catch (InsufficientBalanceException e) {
					System.out.println(e.getMessage());
				} catch (UserNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6: 
				System.out.println("Enter account id");
				id=sc.next();
				try {
					accountService.changePin(id);
				} catch (UserNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (LimitExceedException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 0: 
				System.out.println("exited");
				System.exit(0);
				break;
			default: System.out.println("wrong option");
			}
		}while(choice!=7);
		sc.close();

	}

}
