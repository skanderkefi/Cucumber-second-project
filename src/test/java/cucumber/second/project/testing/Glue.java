package cucumber.second.project.testing;

import org.hamcrest.Matchers;
import org.junit.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.second.project.Calculator;

public class Glue {

	 private int total;

	    private Calculator calculator;

	    @Before
	    private void init() {
	        total = -999;
	    }

	    @Given("^I have a calculator$")
	    public void initializeCalculator() throws Throwable {
	        calculator = new Calculator();
	    }

	    @When("^I add (-?\\d+) and (-?\\d+)$")
	    public void testAdd(int num1, int num2) throws Throwable {
	        total = calculator.add(num1, num2);
	    }

	    @Then("^the result should be (-?\\d+)$")
	    public void validateResult(int result) throws Throwable {
	        Assert.assertThat(total, Matchers.equalTo(result));
	    
}}
