Feature: Get all pets by your status

  Scenario Outline: get all the pet by a valid status
    Given a user is in the endpoint
    When do get with status of the pet '<status>'
    Then status code return is <statusCode>
    And show all pets with status '<status>'

    Examples:
      | statusCode | status    |
      | 200        | available |
      | 200        | pending   |
      | 200        | sold      |