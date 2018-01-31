package com.JakeZuehlke;
import java.io.*;
import java.util.*;

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
    public static void main(String[] args) throws InvalidTestScores
    {
        //Challenge 1: Test Scores ------------------------------------------------------------------------------------
        int[] testScores = new int[]{70, 80, 90};

        TestScores ts = new TestScores(testScores);
        System.out.println("Average score: " + ts.testScoreAverage());

        //Challenge 2: File Encryption/Decryption ---------------------------------------------------------------------
        try
        {
            //open the file
            File file = new File("test.txt");
            Scanner inputFile = new Scanner(file);
            String fileContent = "";

            //read and store file's contents to fileContent
            try
            {
                while(inputFile.hasNext())
                {
                    fileContent += inputFile.nextLine();
                }
            }
            catch(Exception e)
            {
                System.out.println("ERROR");
            }
            finally
            {
                FileEncrypt fe = new FileEncrypt(fileContent);
                //close the file
                inputFile.close();
                System.out.println(fe.toString());
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}
