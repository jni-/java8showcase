package com.elapsetech.lambda.filtering.without;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.elapsetech.lambda.filtering.Potatoe;

public class FilterableListTest {
	
	private final static int NUMBER_OF_POTATOES = 50;
	private final static int NUMBER_NOT_GREEN_OF_POTATOES = 37;
	
	@Test
	public void canFilterListOfPotatoes() {
		FilterableList<Potatoe> potatoes = new FilterableList<Potatoe>(generateListOfPotatoes());
		
		List<Potatoe> safePotatoes = potatoes.filter(new SafeToEatPredicate());
		
		assertEquals(NUMBER_NOT_GREEN_OF_POTATOES, safePotatoes.size());
	}
	
	@Test
	public void canFilterListOfPotatoesEithAnonymousClass() {
		FilterableList<Potatoe> potatoes = new FilterableList<Potatoe>(generateListOfPotatoes());
		
		List<Potatoe> safePotatoes = potatoes.filter(new FilterableListPredicate<Potatoe>() {
			
			@Override
			public boolean isIncluded(Potatoe element) {
				return !element.isGreen();
			}
		});
		
		assertEquals(NUMBER_NOT_GREEN_OF_POTATOES, safePotatoes.size());
	}


	private List<Potatoe> generateListOfPotatoes() {
		List<Potatoe> potatoes = new LinkedList<>();
		for(int i = 0; i < NUMBER_OF_POTATOES; i++) {
			boolean isGreen = i % 4 == 0 ? true : false;
			potatoes.add(new Potatoe(isGreen));
		}
		return potatoes;
	}
	
}
