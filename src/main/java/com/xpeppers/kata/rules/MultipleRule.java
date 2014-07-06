package com.xpeppers.kata.rules;


public class MultipleRule implements Rule {

	private String message;
	private int number;

	public MultipleRule(int number, String message) {
		this.number = number;
		this.message = message;
	}

	@Override
	public String run(int input) {
		if (input % number == 0)
			return message;
		else
			return "";
	}

}
