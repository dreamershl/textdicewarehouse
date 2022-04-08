@Sum
Feature: Sum operations

  Scenario Outline: find all possible combination for sum
    When the sum partial values is "<partial values>"
    And mean is <mean>
    And missing value length is <missing value length>
    And allowed value set is "1,2,3,4,5,6"
    Then the possible sum set is "<possible set>"

    Examples:
      | partial values | mean | missing value length | possible set                                    |
      | 3,2,4,3        | 4    | 2                    | 6,6                                             |
      | 1,5,6          | 3    | 4                    | 1,1,1,6;1,1,2,5;1,1,3,4;1,2,2,4;1,2,3,3;2,2,2,3 |
      | 1,2,3,4        | 6    | 4                    |                                                 |
      | 6,1            | 1    | 1                    |                                                 |


