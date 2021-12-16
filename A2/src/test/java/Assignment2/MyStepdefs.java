package Assignment2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MyStepdefs extends TestSuite {
    ArrayList<String> consoleInput = new ArrayList<>();
    int count;

    @Given("Initialized the game")
    public void theGameIsInitialized() {
        GameServer gameServer = new GameServer();
        Thread gameServerThread = new Thread(gameServer);
        gameServerThread.start();
        count =0;
    }

    @Then("Players Joined")
    public void playersJoined() throws InterruptedException {
        AppTest.connectPlayers();
        AppTest.commander.sendTestCommand("reset");
    }

    @And("player {int} got tiles {string}")
    public void playerHasBeenDealtTiles(int playerNumber, String tiles) {
        ArrayList<String> myList = new ArrayList<>(Arrays.asList(tiles.split(",")));
        AppTest.commander.sendTestCommand("setPlayerTiles "+(playerNumber -1)+" " + myList);
    }

    @When("the player {int} types option {int}")
    public void thePlayerTypesOption(int playerNumber, int option) {
        consoleInput.add(Integer.toString(option));
    }

    @When("the player {int} enters option as {int}")
    public void thePlayerEntersOptionAs(int playerNumber, int option) {
        consoleInput.add(Integer.toString(option));
    }

    @Then("the player {int} enters the updated hand {string}")
    public void thePlayerEntersTheUpdatedHand(int playerNumber, String updatedHand) {
        consoleInput.add(updatedHand);
    }

    @Then("the player {int} enters the updated table {string}")
    public void thePlayerEntersTheUpdatedTable(int playerNumber, String updatedTable) {
        consoleInput.add(updatedTable);
        String[] userIP = new String[consoleInput.size()];
        userIP = consoleInput.toArray(userIP);


        Player currentPlayer;
        if (playerNumber == 1){
            currentPlayer = AppTest.p1;
            currentPlayer.writeToConsole(userIP);
            count++;
        }
        else if (playerNumber == 2){
            currentPlayer = AppTest.p2;
            currentPlayer.writeToConsole(userIP);
        }
        else if(playerNumber == 3){
            currentPlayer = AppTest.p3;
            currentPlayer.writeToConsole(userIP);
        }
    }

    @Then("Calling round function")
    public void CallingRoundFunction() {
        AppTest.commander.sendTestCommand("round");
    }

    @Then("End of turn")
    public void EndOfTurn() {
        AppTest.commander.sendTestCommand("endTurn");
        consoleInput.clear();
    }

    @And("Terminate the server")
    public void TerminateServer() {
        AppTest.commander.sendTestCommand("terminate");
    }

    @Then("{string} and {string}")
    public void theCurrentHandCurrentHandAndOldHand(String s1, String s2) {
        assertEquals(new ArrayList<String>(Arrays.asList(s1.split(","))).size()+1, new ArrayList<String>(Arrays.asList(s2.split(","))).size());
    }
}
