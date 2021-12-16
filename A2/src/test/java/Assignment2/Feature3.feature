Feature:Modifying table with hand
  Scenario Outline: Update Table1
    Given Initialized the game
    Then Players Joined
    And player 1 got tiles <Tiles>
    And player 2 got tiles "R1,R2,B4,G2,B5,B6,G7,G8,G9,O6,O10,O11,O12,O13"
    And player 3 got tiles "R3,R5,R11,R12,R13,B1,B3,B11,B12,B13,G1,G3,G12,O1"
    When the player 1 types option 2
    Then the player 1 enters the updated hand "{B4,B5,B6,G7,G8,G9,O6,O1,O6,O11,O12}"
    Then the player 1 enters the updated table "{R11,R12,R13}"
    When the player 2 types option 2
    Then the player 2 enters the updated hand "{R1,R2,B4,G2,B5,B6,G7,G8,G9,O6}"
    Then the player 2 enters the updated table "{O10,O11,O12,O13} {R11,R12,R13}"
    When the player 3 types option 2
    Then the player 3 enters the updated hand "{R3,R5,R11,R13,B1,B3,B11,B13,G1,G3,O1}"
    Then the player 3 enters the updated table "{R12,B12,G12} {O10,O11,O12,O13} {R11,R12,R13}"
    When the player 1 types option 2
    Then the player 1 enters the updated hand <Updated Hand>
    Then the player 1 enters the updated table <Updated Table>
    And End of turn

    Examples:
      |Tiles                                    |Updated Hand                     |Updated Table|
      |"R11,R12,R13,B4,B5,B6,G7,G8,G9,O6,O1,O6,O11,O12"|"{B4,B5,B6,G7,G8,G9,O6,O1,O6,O11}"|"{R12,B12,G12,O12} {O10,O11,O12,O13} {R11,R12,R13}"|

  Scenario Outline: Update table 2
    Given Initialized the game
    Then Players Joined
    And player 1 got tiles <Tiles>
    And player 2 got tiles "R1,R2,B4,G2,B5,B6,G7,G8,G9,O6,O7,O11,O12,O13"
    And player 3 got tiles "R3,R5,R11,R12,R13,B1,B3,B11,B12,B13,G1,G3,G12,O1"
    When the player 1 types option 2
    Then the player 1 enters the updated hand "{B4,B5,B6,G7,G8,G9,O6,O1,O6,O9,O10}"
    Then the player 1 enters the updated table "{R11,R12,R13}"
    When the player 2 types option 2
    Then the player 2 enters the updated hand "{R1,R2,B4,G2,B5,B6,G7,G8,G9,O6,O7}"
    Then the player 2 enters the updated table "{O11,O12,O13} {R11,R12,R13}"
    When the player 3 types option 2
    Then the player 3 enters the updated hand "{R3,R5,R11,R13,B1,B3,B11,B13,G1,G3,O1}"
    Then the player 3 enters the updated table "{R12,B12,G12} {O10,O11,O12,O13} {R11,R12,R13}"
    When the player 1 types option 2
    Then the player 1 enters the updated hand <Updated Hand>
    Then the player 1 enters the updated table <Updated Table>
    And End of turn
    And Terminate the server

    Examples:
      |Tiles                                    |Updated Hand                     |Updated Table|
      |"R11,R12,R13,B4,B5,B6,G7,G8,G9,O6,O1,O6,O9,O10"|"{B4,B5,B6,G7,G8,G9,O6,O1,O6}"|"{R12,B12,G12,O12} {O9,O10,O11,O12,O13} {R11,R12,R13}"|

