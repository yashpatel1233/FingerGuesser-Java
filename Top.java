package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Top implements Strategy {

  private Double common;

  // method that finds the most common fingers played by the human
  public void setMostCommonFingers(ArrayList fingersPlayed) {
    // variable to store the most common fingers played
    Double mostCommonFingers = 0.0;
    // variable to store the count of the most common fingers played
    int mostCommonFingersCount = 0;
    // loop to iterate through the arraylist
    for (int i = 0; i < fingersPlayed.size(); i++) {
      // variable to store the count of the current fingers played
      int currentFingersCount = 0;
      // loop to iterate through the arraylist
      for (int j = 0; j < fingersPlayed.size(); j++) {
        // check if the current fingers played is equal to the current fingers played
        if (fingersPlayed.get(i) == fingersPlayed.get(j)) {
          // increment the count of the current fingers played
          currentFingersCount++;
        }
      }
      // check if the count of the current fingers played is greater than the count of the most
      // common fingers played
      if (currentFingersCount > mostCommonFingersCount) {
        // set the most common fingers played to the current fingers played
        mostCommonFingers = (Double) fingersPlayed.get(i);
        // set the count of the most common fingers played to the count of the current fingers
        // played
        mostCommonFingersCount = currentFingersCount;
      }
    }
    // return the most common fingers played
    common = mostCommonFingers;
  }

  // method that returns the sum of fingers to be guessed
  public int getStrategySum(int fingers, ArrayList fingersPlayed) {
    setMostCommonFingers(fingersPlayed);
    return (int) (common + fingers);
  }
}
