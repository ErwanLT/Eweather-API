Feature: Testing EweatherApi with cucumber

  Scenario: Testing an invalid endpoint
    When the client call /eweather/toto
    Then the client receives status code of 404

  Scenario: Testing get weather
    When the client call the API with location "Paris"
    Then the client receive status code of 200
    Then I receive valid Response

  Scenario: Testing get weather with coordinates
    When the client call the API with latitude "48.742399999999996" and longitude "2.4576000000000002"
    Then the client receive status code of 200
    Then I receive valid Response

  Scenario: Testing get weather with invalid coordinates
    When the client call the API with latitude "" and longitude "2.4576000000000002"
    Then the client receive status code of 500
    Then I receive an error Response

  Scenario: Testing get weather no parameter
    When the client call the API with location ""
    Then the client receive status code of 500
    Then I receive an error Response