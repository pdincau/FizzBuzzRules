package com.xpeppers.kata;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.xpeppers.kata.rules.Rule;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzTest {

	private FizzBuzz fizzBuzz;
	@Mock private Rule rule;

	@Before
	public void setUp() {
		fizzBuzz = new FizzBuzz();		
	}


	@Test
	public void runsAddedRule() {
		fizzBuzz.add(rule);

		fizzBuzz.say(1);

		verify(rule).run(1);
	}
	
	@Test
	public void oneIsOne() {
		assertEquals("1", fizzBuzz.say(1));
	}

	@Test
	public void multipleOfThreeIsFizz() {
		fizzBuzz.add(rule);
		when(rule.run(3)).thenReturn("Fizz");

		assertEquals("Fizz", fizzBuzz.say(3));
	}

	@Test
	public void multipleOfFiveIsBuzz() {
		fizzBuzz.add(rule);
		when(rule.run(5)).thenReturn("Buzz");

		assertEquals("Buzz", fizzBuzz.say(5));
	}

	@Test
	public void multipleOfThreeAndFiveIsFizzBuzz() {
		fizzBuzz.add(rule);
		when(rule.run(15)).thenReturn("FizzBuzz");

		assertEquals("FizzBuzz", fizzBuzz.say(15));
	}
}