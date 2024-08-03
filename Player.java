package nz.ac.auckland.se281;


public abstract class Player {
  // arraylist to store the fingers played by the human in double

  // variable to store the name of the human
  protected String name;

  protected int roundsWon;

  public Player(String name) {

    this.name = name;
    roundsWon = 0;
  }

  // method to add the rounds won by the Player
  public void addRoundsWon() {
    roundsWon++;
  }

  // method to get the rounds won by the Player
  public int getRoundsWon() {
    return roundsWon;
  }
}
