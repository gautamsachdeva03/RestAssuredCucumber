@API @Test
Feature: To test api

  Scenario: API: Retrieve Id of the given coin
    When API: User retrieve the data using cryptocurrency map call

  Scenario Outline: API: Retrieve Id of the given coin and convert them to Bolivian
    Then API: User converts the "<COIN_SYMBOL>" to "<CONVERSION_TYPE>"

    Examples:
      | COIN_SYMBOL | CONVERSION_TYPE |
      | BTC         | BOB             |
      | USDT        | BOB             |
      | ETH         | BOB             |

  Scenario Outline: API: Retrieve technical documentation of the given coin
    When API: User retrieve the technical documentation for id "<COIN_ID>" from info call

    Examples:
      | COIN_ID              |
      | 1027                 |
      | 1,2,3,4,5,6,7,8,9,10 |