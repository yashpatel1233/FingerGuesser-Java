package nz.ac.auckland.se281;

import java.util.ArrayList;

public interface Strategy {
  // method that reurns the sum of fingers to be guessed
  public int getStrategySum(int fingers, ArrayList fingersPlayed);
}
