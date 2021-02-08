
Feature: Problem 1
			@Problem1
			Scenario: this feature file is to testa and verify values and total  Balance
			Given User in on values Page
			And User verify right count of values appear on screen
			Then User verify the value on the screen are greater then 0
			And User verify total balance is correct based on listed values
			Then User verify values are formmated as currencies
			