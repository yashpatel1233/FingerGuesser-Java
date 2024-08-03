package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Average implements Strategy {

  // initialise the average
  private double average;

  private int fingers;

  private ArrayList fingersPlayed;

  public void setFingersPlayed(ArrayList fingersPlayed) {
    this.fingersPlayed = fingersPlayed;
  }

  // method to calculate the average of the fingers played by the human
  public void setAverage() {
    Double sum = 0.0;
    int count = fingersPlayed.size();
    for (int i = 0; i < count; i++) {
      sum += (double) fingersPlayed.get(i);
    }
    average = Math.round(sum / count);
  }

  // method that returns the number of fingers to be played
  public int getFingers() {
    fingers = Utils.getRandomNumber(1, 5);
    return fingers;
  }

  // method that returns the sum of the fingers played and the average
  public int getStrategySum(int fingers, ArrayList fingersPlayed) {
    setFingersPlayed(fingersPlayed);
    setAverage();
    return (int) (average + fingers);
  }
}
