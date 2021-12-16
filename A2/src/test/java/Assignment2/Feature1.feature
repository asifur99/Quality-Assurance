Feature:Initial Move of 30 points or more with at least one type of set
  Scenario Outline: All sets check
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
      #Playing a running Set
      | 1 | "R11,R12,R13,B4,B5,B6,G7,G8,G9,O6,O10,O11,O12,O13" |"{B4,B5,B6,G7,G8,G9,O6,O10,O11,O12,O13}" |"{R11,R12,R13}" |
      | 1 | "R1,R2,R3,B4,B5,B6,G7,G8,G9,O6,O10,O11,O12,O13" |"{R1,R2,R3,B4,B5,B6,G7,G8,G9,O6}" |"{O10,O11,O12,O13}" |
      #Playing a multiple running Sets
      | 1 | "R11,R12,R13,B4,B5,B6,G7,G8,G9,O6,O10,O11,O12,O13" |"{B4,B5,B6,G7,G8,G9,O6}" |"{R11,R12,R13} {O10,O11,O12,O13}" |
      | 1 | "R3,B4,B5,B6,B11,B12,B13,G7,G8,G9,O6,O10,O11,O12" |"{R3,B4,B5,B6,G7,G8,G9,O6}" |"{O10,O11,O12} {B11,B12,B13}" |
      #Playing a Set
      | 1 | "R10,R12,R13,B4,B5,B10,G7,G8,G10,O6,O10,O11,O12,O13" |"{R12,R13,B4,B5,G7,G8,O6,O10,O11,O12,O13}" |"{R10 B10 G10}" |
      | 1 | "R9,B4,B5,B9,B11,B12,B13,G7,G8,G9,O6,O9,O11,O12" |"{B4,B5,B11,B12,B13,G7,G8,O6,O11,O12}" |"{R9,B9,G9,O9}" |
      #Playing Multiple Sets
      | 1 | "R1,R7,R13,B1,B5,B7,G1,G7,G10,O1,O6,O7,O12,O13" |"{R13,B5,G10,O6,O12,O13}" |"{R1,B1,G1,O1} {R7,B7,G7,O7}" |
      | 1 | "R3,R13,B3,B5,B9,B12,B13,G3,G8,G13,O3,O9,O11,O13" |"{B5,B9,B12,G8,O9,O11}" |"{R3,B3,G3,O3} {R13,B13,G13,O13}" |
