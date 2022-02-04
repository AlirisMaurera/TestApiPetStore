Feature: Search a pet by id

  Background:
    Given user is the endpoint


  Scenario Outline: Get pet by valid id
    When do get with id '<id>'
    Then status code is <statusCode>
    And show the description pet '<nameCategory>' '<name>' '<id>' '<status>'

    Examples:
      | id | nameCategory | name | status    | statusCode |
      | 1  | ShauShau     | Luci | available | 200        |


  Scenario Outline: Get pet by invalid id
    When do get with id '<id>'
    Then status code is <statusCode>
    And show a message '<message>'
    Examples:
      | id      | statusCode | message       |
      | 1245698 | 404        | Pet not found |