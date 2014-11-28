package com.elapsetech.lambda.streaming;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class Expense {
	public final String account;
	public final String employee;
	public final LocalDateTime date;
	public final Integer amount;

	public Expense(String account, String employee, LocalDateTime date, int amount) {
		this.account = account;
		this.employee = employee;
		this.date = date;
		this.amount = amount;
	}

	public String getEmployee() {
		return employee;
	}
	
	public String getMonthName() {
		return date.getMonth().getDisplayName(TextStyle.FULL, Locale.CANADA);
	}
	
	public Integer getAmount() {
		return amount;
	}
}
