package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arithmetic {
  /**
   * calculate the sum set for the specified mean value.
   *
   * @param partialValueAry       existing value array
   * @param missingValueCount     length for the return array
   * @param mean                  total sum/ total count
   * @param sortedAllowedValueAry sorted allowed values
   * @return possible combination of the missing values
   */
  public static List<int[]> findSumSetForMean(int[] partialValueAry,
                                              int missingValueCount,
                                              int mean,
                                              int[] sortedAllowedValueAry) {

    int sum = mean * (partialValueAry.length + missingValueCount);
    int missValueSum = sum - Arrays.stream(partialValueAry).sum();

    int[] remainingValueAry = new int[missingValueCount];

    return
        combinationForSum(remainingValueAry, 0, sortedAllowedValueAry, missValueSum);
  }

  private static boolean isOutRange(int targetSum,
                                    int remainingCount,
                                    int minAllowedValue,
                                    int maxAllowedValue) {
    int minRemainingSum = remainingCount * minAllowedValue;
    int maxRemainingSum = remainingCount * maxAllowedValue;
    return targetSum > maxRemainingSum || targetSum < minRemainingSum;
  }

  private static List<int[]> combinationForSum(int[] valueAry,
                                               int beginIndex,
                                               int[] sortedAllowedValueAry,
                                               int sum) {

    List<int[]> matchedValueList = new ArrayList<>();

    var minAllowedValue = sortedAllowedValueAry[0];
    var maxAllowedValue = sortedAllowedValueAry[sortedAllowedValueAry.length - 1];

    var remainingLength = valueAry.length - beginIndex;

    var isOutRange = isOutRange(sum, remainingLength, minAllowedValue, maxAllowedValue);

    if (!isOutRange) {
      for (var allowedValue : sortedAllowedValueAry) {
        int remainSum = sum - allowedValue;
        if (!isOutRange(remainSum, remainingLength - 1, minAllowedValue, maxAllowedValue)) {
          valueAry[beginIndex] = allowedValue;

          if (beginIndex < valueAry.length - 1) {
            var innerResultList = combinationForSum(valueAry,
                beginIndex + 1,
                sortedAllowedValueAry,
                remainSum);
            matchedValueList.addAll(innerResultList);

          } else if (remainSum == 0) {
            matchedValueList.add(Arrays.copyOf(valueAry, valueAry.length));
          }
        }
      }
    }

    return matchedValueList;
  }
}
