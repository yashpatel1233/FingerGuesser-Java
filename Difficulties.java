package nz.ac.auckland.se281;

import java.util.ArrayList;

public interface Difficulties {

  // method that returns the number of fingers to be played
  public int getFingers();

  // method that returns the sum of fingers to be guessed
  public int getSum(ArrayList fingersPlayed);
}
