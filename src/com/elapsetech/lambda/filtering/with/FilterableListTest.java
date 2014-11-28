package com.elapsetech.lambda.filtering.with;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import com.elapsetech.lambda.filtering.Potatoe;

public class FilterableListTest {
	
	private final static int NUMBER_OF_POTATOES = 50;
	private final static int NUMBER_NOT_GREEN_OF_POTATOES = 37;
	
	@Test
	public void canFilterListOfPotatoes() {
		FilterableList<Potatoe> potatoes = new FilterableList<Potatoe>(generateListOfPotatoes());
		
		List<Potatoe> safePotatoes = potatoes.filter((x) -> !x.isGreen());
		
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
	
	// Or
	protected List<Potatoe> generateListOfPotatoesWithStream() {
		Function<Integer, Boolean> isGreen = (x) -> x % 4 == 0;
		
		return IntStream.range(0, NUMBER_OF_POTATOES).
				mapToObj((x) -> new Potatoe(isGreen.apply(x))).
				collect(Collectors.toList());
	}
}
