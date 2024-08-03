package nz.ac.auckland.se281;

import java.util.ArrayList;

public class EasyDifficulty implements Difficulties {

  private int fingers;

  // method that returns the number of fingers to be played
  public int getFingers() {
    fingers = Utils.getRandomNumber(1, 5);
    return fingers;
  }

  // method that returns the sum of fingers to be guessed
  public int getSum(ArrayList fingersPlayed) {
    Strategy random = new Random();

    return random.getStrategySum(fingers, fingersPlayed);
  }
}
