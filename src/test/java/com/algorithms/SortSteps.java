package com.algorithms;

import com.algorithms.Sorter;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

@ScenarioScoped
public class SortSteps {
  private transient int[] valueList;

  @When("the array is {string}")
  public void theArrayIs(String arrayValues) {
    if (!arrayValues.isBlank()) {
      valueList = Arrays.stream(arrayValues.split(",")).mapToInt(Integer::parseInt).toArray();
    } else {
      valueList = null;
    }
  }

  @Then("the shortest subsequence to be removed should be {int}")
  public void theShortestSubsequenceToBeRemovedShouldBeLength(int length) {
    var result = Sorter.findShortestSubsequence(valueList);

    Assertions.assertEquals(length, result);
  }
}
