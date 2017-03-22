Feature: Add product to cart example

  Scenario: Add product to cart
    Given I perform search request with parameter "logitech mouse"
    When I add product to cart
    Then 'Оформить покупку' button enabled

    Scenario Outline: Add product to cart
      Given I perform search request with parameter "<string>"
      When I add product to cart
      Then 'Оформить покупку' button enabled

      Examples:
      | string              |
      | a4Tech mouse        |
      | logitech keyboard   |
