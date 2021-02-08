$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/problem1.feature");
formatter.feature({
  "line": 2,
  "name": "Problem 1",
  "description": "",
  "id": "problem-1",
  "keyword": "Feature"
});
formatter.before({
  "duration": 621500,
  "status": "passed"
});
formatter.before({
  "duration": 13677614900,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "this feature file is to testa and verify values and total  Balance",
  "description": "",
  "id": "problem-1;this-feature-file-is-to-testa-and-verify-values-and-total--balance",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Problem1"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User in on values Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User verify right count of values appear on screen",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "User verify the value on the screen are greater then 0",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "User verify total balance is correct based on listed values",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User verify values are formmated as currencies",
  "keyword": "Then "
});
formatter.match({
  "location": "Problem1StepDefinition.user_in_on_values_Page()"
});
formatter.result({
  "duration": 1366708400,
  "status": "passed"
});
formatter.match({
  "location": "Problem1StepDefinition.User_verify_right_count_of_values_appear_on_screen()"
});
formatter.result({
  "duration": 41600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0",
      "offset": 53
    }
  ],
  "location": "Problem1StepDefinition.user_verify_the_value_on_the_screen_are_greater_then(int)"
});
formatter.result({
  "duration": 4083300,
  "status": "passed"
});
formatter.match({
  "location": "Problem1StepDefinition.user_verify_total_balance_is_correct_based_on_listed_values()"
});
formatter.result({
  "duration": 36200,
  "status": "passed"
});
formatter.match({
  "location": "Problem1StepDefinition.user_verify_values_are_formmated_as_currencies()"
});
formatter.result({
  "duration": 34000,
  "status": "passed"
});
formatter.after({
  "duration": 130400,
  "status": "passed"
});
formatter.after({
  "duration": 29700,
  "status": "passed"
});
});