package com.example.entity;

public class Account {

	String num;
	double balance;

	public Account() {
	}

	public Account(String number, double balance) {
		this.balance = balance;
		this.num = number;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
