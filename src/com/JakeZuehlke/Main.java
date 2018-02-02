package com.JakeZuehlke;
import java.io.*;
import java.util.*;

/**
 * @author Jake Zuehlke
 */
public class Main
{
    /**
     * Main method:
     * Challenge 1 will create an integer array of test scores from the user,
     * instantiate a TestScores object, passing in the array as an argument,
     * and print out the average score using the testScoreAverage method.
     * Challenge 2 will try to open a file and read from it,
     * appending each line of the file to a string.
     * It will then instantiate a FileEncrypt object, passing in the file string.
     * Next it calls the Encrypt method and prints out the file string in its
     * encrypted format.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        //instantiate scanner object
        Scanner keyboard = new Scanner(System.in);

        /**
         * Challenge 1: Test Scores -----------------------------------------------------------------------------------
         */
        System.out.println("Challenge 1: Test Scores ---------------------------------------------------------------");

        //prompt user for 3 test scores, put them into testScores array
        System.out.print("Enter test score 1: ");
        int ts1 = keyboard.nextInt();
        System.out.print("Enter test score 2: ");
        int ts2 = keyboard.nextInt();
        System.out.print("Enter test score 3: ");
        int ts3 = keyboard.nextInt();

        int[] testScores = new int[]{ts1, ts2, ts3};

        //instantiate TestScores object
        TestScores ts = new TestScores(testScores);

        //try to get an average of the entered test scores using testScoreAverage method in TestScores
        try
        {
            System.out.println("Average score: " + ts.testScoreAverage());
        }
        catch(InvalidTestScores e)
        {
            System.out.println(e.getMessage());
        }

        /**
         * Challenge 2: File Encryption/Decryption --------------------------------------------------------------------
         */
        System.out.println("\nChallenge 2: File Encrypt/Decrypt ----------------------------------------------------");

        //prompt user for shift value
        System.out.print("Encrypt the file by a Cesarian shift of: ");
        int shift = keyboard.nextInt();

        try
        {
            //try to open the file
            File file = new File("secret.txt");
            Scanner inputFile = new Scanner(file);
            String fileContent = "";


            //read and store file's contents to fileContent
            while(inputFile.hasNext())
            {
                fileContent += inputFile.nextLine();
            }

            //instantiate FileEncrypt, call Encryption and toFile methods
            FileEncrypt fe = new FileEncrypt(fileContent);
                fe.Encryption(shift);
                fe.toFile();

            //instantiate FileDecrypt, call Decryption and toFile methods
            FileDecrypt de = new FileDecrypt(fe.getEncryptedFile());
                de.Decryption(shift);
                de.toFile();

            //output decryption
            System.out.println("Decrypted Message: " + de.toString());

            //close the file
            inputFile.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
        }
    }
}
