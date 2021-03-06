package com.JakeZuehlke;

/**
 * TestScores class:
 * This class accepts and array of test scores as its argument,
 * can return average of test scores given,
 * and throws IllegalArgumentException for scores less than 0 or greater than 100
 * @author Jake Zuehlke
 */
public class TestScores
{
    private int[] scores;

    /**
     * The constructor accepts an array of test score integers
     * @param scoreArray
     */
    public TestScores(int[] scoreArray)
    {
        this.scores = scoreArray;
    }

    /**
     * This method will return the average of the given scores,
     * @throws InvalidTestScores for test scores below 0 and above 100
     * @returns the average of the scores array
     */
    public int testScoreAverage() throws InvalidTestScores
    {
        int totalScore = 0;

        for(int i = 0; i < scores.length; i++)
        {
            if(scores[i] < 0 || scores[i] > 100)
            {
                throw new InvalidTestScores();
            }
            totalScore += scores[i];
        }
        return totalScore/scores.length;
    }
}
