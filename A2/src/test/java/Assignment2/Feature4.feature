Feature:This feature checks the tile drawing feature works

  Scenario Outline: draw card
    Given Initialized the game
    Then Players Joined
    And player 1 got tiles "R10,R12,R13,B4,B5,B10,G7,G8,G10,O6,O10,O11,O12,O13"
    And player 2 got tiles "R1,R2,B4,G2,B5,B6,G7,G8,G9,O6,O10,O11,O12,O13"
    And player 3 got tiles "R3,R5,R11,R12,R13,B1,B3,B11,B12,B13,G1,G3,G5,O1"
    When the player 1 types option 1
    Then <currentHand> and <oldHand>

    Examples:
      |currentHand | oldHand|
      |"R10,R12,R13,B4,B5,B10,G7,G8,G10,O6,O10,O11,O12,O13"|"R10,R12,R13,B4,B5,B10,G7,G8,G10,O6,O9,O10,O11,O12,O13"|

  Scenario Outline:
    Given Initialized the game
    Then Players Joined
    And player 1 got tiles "R10,R12,R13,B4,B5,B10,G7,G8,G10,O6,O10,O11,O12,O13"
    And player 2 got tiles "R1,R2,B4,G2,B5,B6,G7,G8,G9,O6,O10,O11,O12,O13"
    And player 3 got tiles "R3,R5,R11,R12,R13,B1,B3,B11,B12,B13,G1,G3,G5,O1"
    When the player 1 types option 1
    Then <currentHand> and <oldHand>

    Examples:
      |currentHand | oldHand|
      |"R10,R12,R13,B4,B5,B10,G7,G8,G10,O6,O10,O11,O12,O13"|"R10,R12,R13,B4,B5,B10,G7,G8,G10,O6,O10,O11,O12,O13,*"|