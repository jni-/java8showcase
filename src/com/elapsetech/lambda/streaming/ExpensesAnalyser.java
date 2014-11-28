package com.elapsetech.lambda.streaming;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ExpensesAnalyser {

	public static void main(String[] args) {
		
		System.out.println("Sum of mileage : " + sumOfMileage());
		
		System.out.println("Mileage per month : " + averageMileagePerMonth());
		
		Entry<String, Integer> ateMostInRestaurants = mostRestaurants();
		System.out.println("Who ate the most in restaurants? " + ateMostInRestaurants.getKey() + " for " + ateMostInRestaurants.getValue() + "$");
		
	}
	
	private static int sumOfMileage() {
		String account = "Mileage";
		return ExpensesTestData.expenses.stream().
				filter((e) -> e.account.equals(account)).
				mapToInt((e) -> e.amount).
				reduce(0, (a, b) -> a + b);
	}
	
	private static Map<String, Integer> averageMileagePerMonth() {
		String account = "Mileage";
		return ExpensesTestData.expenses.stream().
				filter((e) -> e.account.equals(account)).
				collect(Collectors.groupingBy(Expense::getMonthName,
						Collectors.summingInt(Expense::getAmount)));
	}
	
	private static Entry<String, Integer> mostRestaurants() {
		String account = "Restaurants";
		return ExpensesTestData.expenses.stream().
				filter((e) -> e.account.equals(account)).
				collect(Collectors.groupingBy(Expense::getEmployee,
						Collectors.summingInt(Expense::getAmount))).
			    entrySet().stream().
			    sorted((a, b) -> b.getValue().compareTo(a.getValue())).
			    findFirst().get();
	}

}
