Feature: Delete a pet


  Scenario Outline: delete a pet with valid id
    Given  a user is in the endpoint with pet add '<idCategory>' '<nameCategory>' '<name>' '<photoUrls>' '<idTags>' '<nameTag>' '<status>'
    When do delete with id
    Then status code <statusCode>


    Examples:
      | idCategory | nameCategory | name | photoUrls | idTags | nameTag    | status    | statusCode |
      | 12         | Poodle       | Luci | foto      | 15     | LuciPoodle | available | 200        |

  Scenario Outline: delete a pet with invalid id
    Given user is in the endpoint
    When do delete with '<id>'
    Then status code <statusCode>

    Examples:
      | id | statusCode |
      | 0  | 404        |