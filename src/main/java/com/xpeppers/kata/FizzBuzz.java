package com.xpeppers.kata;

import java.util.ArrayList;
import java.util.List;

import com.xpeppers.kata.rules.Rule;

public class FizzBuzz {

	private List<Rule> rules = new ArrayList<Rule>();
	private String result = "";

	public String say(int number) {
		for (Rule rule : rules) {
			result += rule.run(number);	
		}
		if (result.equals("")) {
			result = Integer.toString(number);
		}
		return result; 
	}

	public void add(Rule rule) {
		rules.add(rule);
	}

}
