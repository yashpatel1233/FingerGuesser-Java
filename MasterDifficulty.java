package nz.ac.auckland.se281;

import java.util.ArrayList;

public class MasterDifficulty implements Difficulties {

  private int fingers;

  // method that returns the number of fingers to be played
  public int getFingers() {

    fingers = Utils.getRandomNumber(1, 5);
    return fingers;
  }

  // method that returns the sum of fingers to be guessed by using the easy method until the 4th
  // round where it does the average method and then alternates between the hard method
  public int getSum(ArrayList fingersPlayed) {
    // call all the potential strategies
    Strategy random = new Random();
    Strategy average = new Average();
    Strategy top = new Top();
    // call the strategy system
    StrategySystem system = new StrategySystem(random);

    // if the rounds is less than 4 than use the random strategy otherwise get the average of the
    // fingers played and add fingers
    if (fingersPlayed.size() < 3) {

      return system.getSum(fingers, fingersPlayed);

    } else {
      if (fingersPlayed.size() % 2 != 0) {
        system.setStrategy(average);
        return system.getSum(fingers, fingersPlayed);

      } else {

        system.setStrategy(top);
        return system.getSum(fingers, fingersPlayed);
      }
    }
  }
}
