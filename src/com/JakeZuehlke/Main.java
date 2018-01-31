package com.JakeZuehlke;

/**
 * @author Jake Zuehlke
 */
public class Main
{
    /**
     * Main method will create an integer array of test scores, then call
     * instantiate a TestScores object.  
     * @param args
     * @throws InvalidTestScores
     */
    public static void main(String[] args) throws InvalidTestScores {
        int[] testScores = new int[]{70, 80, 90, 101};

        TestScores ts = new TestScores(testScores);
        System.out.println("Average score: " + ts.testScoreAverage());
    }
}
