package com.xpeppers.kata.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultipleRuleTest {

	@Test
	public void whenNumberIsMultipleReturnsMessage() {
		Rule rule = new MultipleRule(3, "Fizz");

		assertEquals("Fizz", rule.run(6));
	}

	@Test
	public void whenNumberIsNotMultipleReturnsEmptyString() {
		Rule rule = new MultipleRule(3, "Fizz");

		assertEquals("", rule.run(2));
	}

}
