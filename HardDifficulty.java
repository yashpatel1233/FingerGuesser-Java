package nz.ac.auckland.se281;

import java.util.ArrayList;

public class HardDifficulty implements Difficulties {

  private int fingers;

  // method that returns the number of fingers to be played
  public int getFingers() {

    fingers = Utils.getRandomNumber(1, 5);
    return fingers;
  }

  // method that returns the sum of fingers to be guessed by using the easy method until the 4tho
  // round where it does the top method
  public int getSum(ArrayList fingersPlayed) {
    // if the rounds is less than 4 than use the random strategy otherwise get the most common
    // finger
    // played and add fingers
    if (fingersPlayed.size() < 3) {
      Strategy random = new Random();
      StrategySystem system = new StrategySystem(random);
      return system.getSum(fingers, fingersPlayed);
    } else {
      Strategy top = new Top();
      StrategySystem system = new StrategySystem(top);
      return system.getSum(fingers, fingersPlayed);
    }
  }
}
