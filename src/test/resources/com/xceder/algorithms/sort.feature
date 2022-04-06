@Sort
Feature: Sort operations

  Scenario Outline: find shortest subsequence to be removed to make the array non decreasing order
    When the array is "<array>"
    Then the shortest subsequence to be removed should be <length>

    Examples:
      | array       | length |
      | 1           | 0      |
      | 1,2,3,1,1,5 | 2      |

