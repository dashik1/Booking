Feature: Search

  Scenario Outline: User search for <hotel> hotel and check that it exists on the page and it has <score> score
    Given Main Booking page is opened
    When User inputs <hotel> to Destination field
    And Click Search button
    Then <hotel> card is displayed on the page
    And <score> score is displayed
    Examples:
      | hotel                         | score |
      | "Rooms Hotel Kazbegi"         | "8.9" |
      | "Hotel Tbilisi Tower"         | "8.7" |
      | "Golden Tulip Design Tbilisi" | "9.1" |






    

