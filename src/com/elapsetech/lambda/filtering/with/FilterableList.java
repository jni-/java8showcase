package com.elapsetech.lambda.filtering.with;

import java.util.LinkedList;
import java.util.List;

public class FilterableList<T> {
	
	private List<T> list;

	public FilterableList(List<T> list) {
		this.list = list;
	}
	
	public List<T> filter(FilterableListPredicate<T> predicate) {
		List<T> result = new LinkedList<>();
		for (T element : list) {
			if(predicate.isIncluded(element)) {
				result.add(element);
			}
		}
		return result;
	}

}
