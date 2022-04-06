package com.algorithms;

import com.google.common.base.Joiner;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;

@ScenarioScoped
public class SumSteps {
  private transient int[] partialValues;
  private transient int mean;
  private transient int missingValueCount;

  private int[] allowedValues;

  private static int applyAsInt(String v) {
    return Integer.parseInt(v.trim());
  }

  private int[] fromString(String values) {
    var parts = values.split(",");
    return Arrays.stream(parts).mapToInt(SumSteps::applyAsInt).toArray();
  }

  @And("missing value length is {int}")
  public void missingValueLengthIsMissingValueLength(int missingValueCount) {
    this.missingValueCount = missingValueCount;
  }

  @When("the sum partial values is {string}")
  public void theSumPartialValuesIs(String values) {
    partialValues = fromString(values);
  }

  @And("mean is {int}")
  public void meanIsMean(int mean) {
    this.mean = mean;
  }

  @And("allowed value set is {string}")
  public void allowedValueSetIs(String allowedValues) {
    this.allowedValues = fromString(allowedValues);
  }

  @Then("the possible sum set is {string}")
  public void thePossibleSumSetIs(String values) {
    var result =
        Arithmetic.findSumSetForMean(partialValues, missingValueCount, mean, allowedValues);


    var resultSet = result.stream()
        .map(a -> IntStream.of(a).boxed().sorted().collect(Collectors.toList()))
        .collect(Collectors.toSet());

    var resultStringList = resultSet.stream()
        .map(a -> Joiner.on(",").join(a.stream().map(String::valueOf).toList()))
        .sorted()
        .toList();

    Assertions.assertEquals(values, Joiner.on(';').join(resultStringList));
  }
}
