package com.algorithms;

import com.algorithms.Digrams;
import com.algorithms.DigramsDistance;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

@ScenarioScoped
public class DigramsSteps {
  private transient String text;

  @When("the string is {string}")
  public void theStringIs(String text) {
    this.text = text;
  }

  @Then("the furthest same digrams {string} should be {int} with positions {string}")
  public void theFurthestSameDigramsShouldBeDistanceWithPositions(String digrams,
                                                                  int distance,
                                                                  String positions) {

    var result = Digrams.maxSameDigramsDistance(text);

    DigramsDistance expected = new DigramsDistance(digrams);

    if (!positions.isBlank()) {
      expected.getOccurrenceIndexList()
          .addAll(Arrays.stream(positions.split(",")).map(Integer::parseInt).toList());
    }

    Assertions.assertEquals(expected, result);
    Assertions.assertEquals(distance, result.maxDistance());
  }
}
