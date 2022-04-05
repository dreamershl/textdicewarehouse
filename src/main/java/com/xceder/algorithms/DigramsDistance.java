package com.xceder.algorithms;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class DigramsDistance {
  private final String digrams;
  //  1 based
  private final List<Integer> occurrenceIndexList = new ArrayList<>();

  public int maxDistance() {
    int result = -1;

    if (occurrenceIndexList.size() > 1) {
      result = occurrenceIndexList.get(occurrenceIndexList.size() - 1) - occurrenceIndexList.get(0);
    }

    return result;
  }
}
