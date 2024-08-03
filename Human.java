package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Human extends Player {

  private ArrayList<Double> fingersPlayed;

  public Human(String name) {
    // integer arraylist for the fingers played
    super(name);
    // integer arraylist for the fingers played
    this.fingersPlayed = new ArrayList<Double>();
  }

  // method to add the fingers played by the human to the arraylist
  public void addFingersPlayed(Double fingers) {
    fingersPlayed.add(fingers);
  }
}
