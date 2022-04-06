package com.algorithms;

public class Sorter {
  static int findShortestSubsequence(int[] array) {
    int length = array.length;
    int leftIndex = 0;
    int rightIndex = length - 1;

    while (leftIndex < rightIndex && array[leftIndex] <= array[leftIndex + 1]) {
      leftIndex++;
    }

    int result = 0;

    if (leftIndex != rightIndex) {
      while (rightIndex > 0 && array[rightIndex] >= array[rightIndex - 1]) {
        rightIndex--;
      }

      if (rightIndex != 0) {
        result = Math.min(length - 1 - leftIndex, rightIndex);

        int subIndex = 0;

        while (subIndex <= leftIndex && rightIndex < length) {
          if (array[subIndex] <= array[rightIndex]) {
            result = Math.min(result, rightIndex - subIndex - 1);
            subIndex++;
          } else {
            rightIndex++;
          }
        }

      }
    }

    return result;
  }
}
