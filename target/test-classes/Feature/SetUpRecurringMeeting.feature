@Regression
Feature: Create a recurring meeting using Native Android Calendar App.

  Scenario Outline: Create a meeting event
    Given I have launched the Calendar App
    When Meeting is between "<startHour>" : "<startMinute>" : "<startMeridiem>" to "<endHour>" : "<endMinute>" : "<endMeridiem>"
    And It occurs on every "<frequency>" : "<dayOfTheWeek>"
    And It is only on weekdays
    And It starts from the month "<startMonth>" and continues for next "<numberOfMonths>"
    And I invite "<number>" of attendies
    Then I want to book a meeting with the title "<title>"
    And I save the meeting
    Then I Check if the meeting is created as expected
    Then I can delete the meeting

    Examples: 
      | title    | startHour | startMinute | startMeridiem | endHour | endMinute | endMeridiem | dayOfTheWeek | startMonth | frequency | numberOfMonths |number|
      | WorkShop |         9 |          30 | AM            |       1 |        30 | PM          | Friday       | April      | weekly    |              2 |5|
      #| Stand Up |         10 |          00 | AM            |       10 |        15 | AM         | Monday       | April      | weekly    |              3 |5|
