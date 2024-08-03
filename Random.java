package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Random implements Strategy {

  // method that returns the sum of fingers to be guessed
  public int getStrategySum(int fingers, ArrayList fingersPlayed) {
    return Utils.getRandomNumber(fingers + 1, fingers + 5);
  }
}
