package com.elapsetech.lambda.streaming;

import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ExpensesTestData {
	
	public final static List<Expense> expenses;

	private final static String[] availableAccounts = {"Restaurants", "Mileage", "Training", "Hotels", "Sports club", "Consultants"};
	private final static String[] availableEmployees = {"John", "Mike", "Jack", "Paul", "Fred", "Tim", "Josh", "Melissa", "Jennifer", "Erika"};
	
	static {
		List<Expense> writableList = new LinkedList<>();
		Random generator = new Random();
		
		for(int i = 0; i < 1000000; i++) {
			writableList.add(new Expense(availableAccounts[generator.nextInt(availableAccounts.length)],
							  availableEmployees[generator.nextInt(availableEmployees.length)],
							  LocalDate.of(2014,1,1).atStartOfDay().plusDays(generator.nextInt(365)),
						      generator.nextInt(500)));
		}
		
		expenses = Collections.unmodifiableList(writableList);
	}

}
