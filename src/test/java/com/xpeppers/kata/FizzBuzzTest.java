package com.xpeppers.kata;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.xpeppers.kata.rules.Rule;

@RunWith(Parameterized.class)
public class FizzBuzzTest {

	private FizzBuzz fizzBuzz;
	private Rule rule;
	
	private final int inputNumber;
	private final String outputString;
	private String ruleResult;

	public FizzBuzzTest(int inputNumber, String outputString, String ruleResult) {
		this.inputNumber = inputNumber;
		this.outputString = outputString;
		this.ruleResult = ruleResult;
		this.rule = mock(Rule.class);
	}
	
	@Parameters
    public static Collection<Object[]> validActions() {
        return asList(new Object[][] {
                { 1, "1", "" },
                { 3, "Fizz", "Fizz" },
                { 5, "Buzz", "Buzz" },
                { 15, "FizzBuzz", "FizzBuzz" },
        });
    }
	
	@Test
	public void transforms_input_number_according_to_rule() {
		fizzBuzz = new FizzBuzz();		
		fizzBuzz.add(rule);
		
		when(rule.run(inputNumber)).thenReturn(ruleResult);
		
		assertEquals(outputString, fizzBuzz.say(inputNumber));
	}
}