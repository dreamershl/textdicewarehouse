Feature: Text digrams operations

  Scenario Outline: calculate same digrams distance in text
    When the string is "<text>"
    Then the furthest same digrams "<digrams>" should be <distance> with positions "<positions>"

    Examples:
      | text         | digrams | distance | positions |
      | aakmaakmakda | ak      | 7        | 2,9       |
      | aaa          | aa      | 1        | 1,2       |
      | solidity     |         | -1       |           |
      | a            |         | -1       |           |
      | ab           |         | -1       |           |
      | abc          |         | -1       |           |
