package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // double that stores the number of rounds played by the player
  private double roundsPlayed = 0;

  // string that stores name of the player
  private String name;

  // string that stores the name of the AI
  private String aiName = "Jarvis";

  // store the difficulty of the game using the enums from main
  private Difficulty difficulty;

  // int for AI fingers
  private int aiFingers;
  // int for AI sum
  private int aiSum;

  // boolean to check if there is a game in progress
  private boolean gameInProgress = false;

  // Arraylist to store the fingers played by the human
  private ArrayList<Double> fingersPlayed;

  // int to store the points to win
  private int gamePointsToWin;

  // store the human
  private Player human;

  // store the AI
  private Jarvis ai;

  public Morra() {
    // initialise the fingers played arraylist
    fingersPlayed = new ArrayList<Double>();
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // sets the number of rounds played to 1
    roundsPlayed = 1;

    // prints the welcome message
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);

    // new finger arraylist
    fingersPlayed = new ArrayList<Double>();

    // sets the name of the player to the first argument
    name = options[0];

    // sets the difficulty of the game to the first argument
    this.difficulty = difficulty;

    gameInProgress = true;

    gamePointsToWin = pointsToWin;

    human = new Human(options[0]);

    ai = new Jarvis(aiName);
  }

  public boolean checkFingersInput(String input) {
    // check is input is valid by checking whether it is a whole integer and between 1 and 5
    if (!Utils.isInteger(input) || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 5) {
      return false;
    }
    // return true if the input is valid
    return true;
  }

  public boolean checkSumInput(String input) {
    // check is input is valid by checking whether it is a whole integer and between 1 and 10
    if (!Utils.isInteger(input) || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 10) {
      return false;
    }

    // return true if the input is valid
    return true;
  }

  public String[] getInput() {
    
    // ask the user for input
    MessageCli.ASK_INPUT.printMessage();

    // read the input from the user
    String input = Utils.scanner.nextLine();

    // split the input into two strings
    String[] inputSplit = input.split(" ");

    // if the input is not valid ask the user to input again
    while (!checkFingersInput(inputSplit[0]) || !checkSumInput(inputSplit[1])){
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      input = Utils.scanner.nextLine();
      inputSplit = input.split(" ");
    }

    // return the input
    return inputSplit;
  }

  public void printJarvisHand() {
    // strategy to get the fingers and sum of the AI

    // if the difficulty is easy set fingers and sum to the values returned by getFingers and getSum
    // from Easy class

    if (difficulty == Difficulty.EASY) {
      Difficulties strategy = Factory.createHandStrategy(difficulty);
      Random random = new Random();
      StrategySystem strategySystem = new StrategySystem(random);
      

      aiFingers = strategy.getFingers();
      aiSum = strategySystem.getSum(aiFingers, fingersPlayed);
    }

    // if the difficulty is medium set fingers and sum to the values returned by getFingers and
    // getSum from medium class
    if (difficulty == Difficulty.MEDIUM) {
      Difficulties strategy = Factory.createHandStrategy(difficulty);

      aiFingers = strategy.getFingers();

      aiSum = strategy.getSum(fingersPlayed);
    }

    // if the difficulty is hard set fingers and sum to the values returned by getFingers and getSum
    // from Hard class
    if (difficulty == Difficulty.HARD) {
      Difficulties strategy = Factory.createHandStrategy(difficulty);

      aiFingers = strategy.getFingers();

      aiSum = strategy.getSum(fingersPlayed);
    }

    // if the difficulty is master set fingers and sum to the values returned by getFingers and
    // getSum from Master class
    if (difficulty == Difficulty.MASTER) {

      Difficulties strategy = Factory.createHandStrategy(difficulty);

      aiFingers = strategy.getFingers();

      aiSum = strategy.getSum(fingersPlayed);
    }

    // print the info about the AI hand
    MessageCli.PRINT_INFO_HAND.printMessage(
        aiName, Integer.toString(aiFingers), Integer.toString(aiSum));
  }

  private void resetGame() {
    gameInProgress = false;
  }

  private void printOutcome(String string, String string2, int aiFingers2, int aiSum2) {
    // convert all the inputs to doubles
    double fingers = Double.parseDouble(string);
    double sum = Double.parseDouble(string2);
    double aiFingers = aiFingers2;
    double aiSum = aiSum2;

    //

    // if the sum of the fingers is equal to the sum of the guessed number by the player or the AI
    // than the respective wins
    if (fingers + aiFingers == sum && fingers + aiFingers == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");

    } else if (fingers + aiFingers == aiSum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      ai.addRoundsWon();

    } else if (fingers + aiFingers == sum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      human.addRoundsWon();

    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

    // if the rounds won by the human are equal to the number of rounds to win than the human wins
    if (human.getRoundsWon() == gamePointsToWin) {
      MessageCli.END_GAME.printMessage(name, String.valueOf(Math.round(roundsPlayed)));
      // Call the game reset method
      resetGame();
    }

    // if the rounds won by the AI are equal to the number of rounds to win than the AI wins
    if (ai.getRoundsWon() == gamePointsToWin) {
      MessageCli.END_GAME.printMessage(aiName, String.valueOf(Math.round(roundsPlayed)));

      resetGame();
    }
  }

  public void play() {

    if (!gameInProgress) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // print the number of rounds played rounded to the nearest integer
    MessageCli.START_ROUND.printMessage(String.valueOf(Math.round(roundsPlayed)));

    // split the input into two strings
    String[] inputSplit = getInput();

    MessageCli.PRINT_INFO_HAND.printMessage(name, inputSplit[0], inputSplit[1]);

    // print the info about the AI hand
    printJarvisHand();

    // add the fingers played by the human to the arraylist
    fingersPlayed.add(Double.parseDouble(inputSplit[0]));
    // increase the number of rounds played by 1

    printOutcome(inputSplit[0], inputSplit[1], aiFingers, aiSum);

    roundsPlayed++;
   
  }

  public void showStats() {

    // if the game is not in progress print the message
    if (!gameInProgress) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // print the stats
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name,
        Integer.toString(human.roundsWon),
        Integer.toString(gamePointsToWin - human.roundsWon));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        aiName, Integer.toString(ai.roundsWon), Integer.toString(gamePointsToWin - ai.roundsWon));
  }
}
