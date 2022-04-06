package com.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Digrams {
  public static DigramsDistance maxSameDigramsDistance(String content) {
    DigramsDistance maxDistance = new DigramsDistance("");
    Map<String, DigramsDistance> distanceMap = new HashMap<>();

    int[] indexAry = new int[2];

    for (int leftIndex = 0, rightIndex = content.length() - 2;
         leftIndex <= rightIndex;
         leftIndex++, rightIndex--) {

      indexAry[0] = leftIndex;
      indexAry[1] = leftIndex == rightIndex ? -1 : rightIndex;

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

  private static DigramsDistance addDistance(int position,
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
