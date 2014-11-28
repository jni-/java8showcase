package com.elapsetech.lambda.filtering.without;

public interface FilterableListPredicate<T> {
	
	boolean isIncluded(T element);

}
