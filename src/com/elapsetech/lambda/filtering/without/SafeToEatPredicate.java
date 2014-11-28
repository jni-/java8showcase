package com.elapsetech.lambda.filtering.without;

import com.elapsetech.lambda.filtering.Potatoe;

public class SafeToEatPredicate implements FilterableListPredicate<Potatoe>{

	@Override
	public boolean isIncluded(Potatoe element) {
		return !element.isGreen();
	}

}
