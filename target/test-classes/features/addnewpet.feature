Feature: Add a new pet to the store


  Scenario Outline: Add a pet with valid data
    Given  a user do in the endpoint
    And with the datas '<idCategory>' '<nameCategory>' '<name>' '<photoUrls>' '<idTags>' '<nameTag>' '<status>'
    When do post
    Then return status code <status>
    And show the body of the datas add '<idCategory>' '<nameCategory>' '<name>' '<status>'

    Examples:
      | idCategory | nameCategory | name | photoUrls | idTags | nameTag    | status |
      | 12         | Poodle       | Luci | foto      | 15     | LuciPoodle | 200    |