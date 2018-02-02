package com.JakeZuehlke;
import java.io.*;

/**
 * @author Jake Zuehlke
 * File Encrypt class:
 * This class' constructor accepts a string,
 * then with the Encryption method the string's letters are shifted based on
 * the passed integer value.  This shift will be to the right alphabetically.
 */
public class FileEncrypt
{
    private String unencryptedFile;
    private String encryptedFile = "";

    /**
     * Constructor, accepts file String
     * @param file
     */
    public FileEncrypt(String file)
    {
        this.unencryptedFile = file;
    }

    /**
     * encryptedFile Getter
     */
    public String getEncryptedFile()
    {
        return encryptedFile;
    }

    /**
     * Encryption:
     * Applies a Ceasarian Shift cipher to the passed file String.
     * @param shift - the integer value of the Ceasarian Shift
     */
    public void Encryption(int shift)
    {
        for(int i = 0; i < unencryptedFile.length(); i++)
        {
            //save the character of the string to Char
            char c = (char)(unencryptedFile.charAt(i));

            //if the character is a space or common punctuation, keep them unchanged
            if(c != ' ' && c != '.' && c != ',')
            {
                c = (char)(unencryptedFile.charAt(i) + shift);
                if((c > 'Z' && c < 'a') || (shift > 6 && (c >= 'a' && c < 'h')))
                {
                    //this adds 6 to the shift to avoid non-letters, then corrects the new shift
                    this.encryptedFile += (char)(c + 6);
                }
                else if (c > 'z')
                {
                    //this will bring the shift range back to the start of the alphabet
                    this.encryptedFile += (char)(c - 58);
                }
                else
                {
                    this.encryptedFile += c;
                }
            }
            else
            {
                this.encryptedFile += c;
            }
        }
    }

    /**
     * toFile:
     * This method attempts to open "topsecret.txt".
     * If successful, write the encryptedFile string to it, then close the file.
     */
    public void toFile()
    {
        //try to open the output file, then write the encryptedFile String to it
        try
        {
            PrintWriter outputFile = new PrintWriter("topsecret.txt");
            outputFile.print(encryptedFile);
            System.out.println("File encryption success!");
            outputFile.close();
        }
        catch(FileNotFoundException e)
        {
            e.getMessage();
        }
    }

    @Override
    public String toString()
    {
        return encryptedFile;
    }
}
