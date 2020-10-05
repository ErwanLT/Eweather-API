Feature: Testing EweatherApi with cucumber

  Scenario: Testing an invalid endpoint
    When the client call /eweather/toto
    Then the client receives status code of 404

  Scenario: Testing get weather
    When the client call /eweather/forecast?location=Paris
    Then the client receive status code of 200
    Then I receive valid Response

  Scenario: Testing get weather no parameter
    When the client call /eweather/forecast?location=
    Then the client receive status code of 500
    Then I receive an error Response