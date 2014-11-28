package com.elapsetech.lambda.filtering.with;

@FunctionalInterface
public interface FilterableListPredicate<T> {
	
	boolean isIncluded(T element);
	
}
