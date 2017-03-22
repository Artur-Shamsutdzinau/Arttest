Feature: add product to cart example

  Scenario: add product to cart
    Given I perform search request with parameter "logitech mouse"
    When I add product to cart
    Then 'Оформить покупку' button enabled
