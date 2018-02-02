package com.JakeZuehlke;

/**
 * InvalidTestScores:
 * This is a custom exception class for use with TestScores,
 * it returns a custom phrase for the exception thrown.
 * @author Jake Zuehlke
 */
public class InvalidTestScores extends Exception
{
    public InvalidTestScores()
    {
        super("Error: Scores given contain a number less than 0 or greater than 100");
    }
}
