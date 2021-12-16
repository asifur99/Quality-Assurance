Feature:Initial Move of 30 points or more with at least one type of set using a Joker
  Scenario Outline: Play Joker
    Given Initialized the game
    Then Players Joined
    And player <Player> got tiles <Tiles>
    And player 2 got tiles "R1,R2,B4,G2,B5,B6,G7,G8,G9,O6,O10,O11,O12,O13"
    And player 3 got tiles "R3,R5,R11,R12,R13,B1,B3,B11,B12,B13,G1,G3,G5,O1"
    When the player 1 enters option as 2
    Then the player 1 enters the updated hand <Updated Hand>
    Then the player 1 enters the updated table <Updated Table>
    Then Calling round function
    Then End of turn
    And Terminate the server
    Examples:

      | Player | Tiles | Updated Hand | Updated Table |
      | 1      | "R10,R11,R13,B4,B5,B6,G7,G8,G9,O6,O10,O11,O12,*"  |"{R11,R13,B4,B5,B6,G7,G8,G9,O6,O11,O12}" |"{R10,*,O10}" |
      | 1      | "R11,R12,B1,B4,B5,B6,G7,G8,G9,O6,O1,O9,O12,*" |"{B1,B4,B5,B6,G7,G8,G9,O6,O1,O9,O12}" |"{R11,R12,*}" |
      | 1      | "R11,R12,B1,B4,B5,B6,G7,G8,G9,O6,O1,O9,O12,*" |"{B1,B4,B5,B6,O6,O1,O9,O12}" |"{R11,R12,*} {G7,G8,G9}" |
      | 1      | "R10,R11,R13,B4,B5,B6,G7,G8,G9,O6,O10,O11,O12,*"  |"{R11,R13,B4,B5,B6,O6,O11,O12}" |"{R10,*,O10} {G7,G8,G9}" |