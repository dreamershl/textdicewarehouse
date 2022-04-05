package com.xceder.algorithms;

import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

@ScenarioScoped
public class DigramsSteps {
  private final Digrams digramsOperator = new Digrams();
  private transient String text;

  @When("the string is {string}")
  public void theStringIs(String text) {
    this.text = text;
  }

  @Then("the furthest same digrams {string} should be {int} with positions {string}")
  public void theFurthestSameDigramsShouldBeDistanceWithPositions(String digrams,
                                                                  int distance,
                                                                  String positions) {

    var result = digramsOperator.maxSameDigramsDistance(text);

    if (digrams == null) {
      Assertions.assertNull(result);
    } else {
      Assertions.assertNotNull(result);

      DigramsDistance expected = new DigramsDistance(digrams);

      if (!positions.isBlank()) {
        expected.getOccurrenceIndexList()
            .addAll(Arrays.stream(positions.split(",")).map(Integer::parseInt).toList());
      }

      Assertions.assertEquals(expected, result);
      Assertions.assertEquals(distance, result.maxDistance());
    }

  }
}
