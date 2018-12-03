package com.abhi.java.core;

import java.util.List;

public class GeneriMethodClass {

	public <T> T add(T a, T b) {
		return (T) (a.toString() + b.toString());
	}

	public void checkUpperBound(List<? extends Number> a) {
		// below will not work, we can't add anything to upper bounded parameter
		// except 'null'
		// list. only read
		// a.add(2);

		a.add(null);
		System.out.println(a.get(0));
	}

	public void checkLowerBound(List<? super Integer> a) {
		a.get(0);
		a.add(10);
		// we can add lower bound Integer item to it at any time because we know
		// for sure list will take Integer can have any item above its hierarchy
		// but Integer will definitely be inserted
		// a.(10L);

	}

}
