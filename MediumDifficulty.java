package nz.ac.auckland.se281;

import java.util.ArrayList;

public class MediumDifficulty implements Difficulties {

  private int fingers;

  // method that returns the number of fingers to be played
  public int getFingers() {
    fingers = Utils.getRandomNumber(1, 5);
    return fingers;
  }

  public int getSum(ArrayList fingersPlayed) {
    // if the rounds is less than 4 than use the easy strategy otherwise get the average of the
    // fingers played and add fingers
    if (fingersPlayed.size() < 3) {
      Strategy random = new Random();
      StrategySystem system = new StrategySystem(random);
      return system.getSum(fingers, fingersPlayed);
    } else {
      Strategy average = new Average();
      StrategySystem system = new StrategySystem(average);

      return system.getSum(fingers, fingersPlayed);
    }
  }
}
