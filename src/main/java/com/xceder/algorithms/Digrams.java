package com.xceder.algorithms;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class Digrams {
  public @Nullable
  DigramsDistance maxSameDigramsDistance(String content) {
    DigramsDistance maxDistance = new DigramsDistance("");
    Map<String, DigramsDistance> distanceMap = new HashMap<>();

    int[] indexAry = new int[2];

    for (int forwardIndex = 0, backwardIndex = content.length() - 2;
         forwardIndex <= backwardIndex;
         forwardIndex++, backwardIndex--) {

      indexAry[0] = forwardIndex;
      indexAry[1] = forwardIndex == backwardIndex ? -1 : backwardIndex;

      DigramsDistance distance = null;
      for (var index : indexAry) {
        if (index != -1) {
          var digrams = content.substring(index, index + 2);
          distance = addDistance(index, digrams, distanceMap);
        }
      }

      assert distance != null;

      if (distance.maxDistance() > maxDistance.maxDistance()) {
        maxDistance = distance;
        break;
      }

    }

    return maxDistance;
  }

  private DigramsDistance addDistance(int position,
                                      String digrams,
                                      Map<String, DigramsDistance> distanceMap) {
    var distance = distanceMap.get(digrams);

    if (distance == null) {
      distance = new DigramsDistance(digrams);
      distanceMap.put(digrams, distance);
    }

    distance.getOccurrenceIndexList().add(position + 1);

    return distance;
  }
}
