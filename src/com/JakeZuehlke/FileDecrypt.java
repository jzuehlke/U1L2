package com.JakeZuehlke;
import java.io.*;

/**
 * @author Jake Zuehlke
 * FileDecrypt class:
 * This class' constructor accepts a string,
 * then with the Decryption method the string's letters are shifted based on
 * the passed integer value.  This shift will be to the left alphabetically.
 */
public class FileDecrypt
{
    String encryptedFile;
    String decryptedFile = "";

    /**
     * Constructor, accepts the encrypted file as a string
     * @param file
     */
    public FileDecrypt(String file)
    {
        this.encryptedFile = file;
    }

    /**
     * Decryption:
     * Applies a Ceasarian Shift cipher to the passed file String.
     * @param shift - the integer value of the Ceasarian Shift
     */
    public void Decryption(int shift)
    {
        for(int i = 0; i < encryptedFile.length(); i++)
        {
            //save the character of the string to Char
            char c = (char)(encryptedFile.charAt(i));

            //if the character is a space or common punctuation, keep them unchanged
            if(c != ' ' && c != '.' && c != ',')
            {
                c = (char)(encryptedFile.charAt(i) - shift);
                if((c > 'Z' && c < 'a') || (shift > 6 && (c <= 'Z' && c < 'S')))
                {
                    //this subtracts 6 to the shift to avoid non-letters, then corrects the new shift
                    this.decryptedFile += (char)(c - 6);
                }
                else if (c < 'A')
                {
                    //this will bring the shift range back to the start of the alphabet
                    this.decryptedFile += (char)(c + 58);
                }
                else
                {
                    this.decryptedFile += c;
                }
            }
            else
            {
                this.decryptedFile += c;
            }
        }
    }

    /**
     * toFile:
     * This method attempts to open "nopsecret.txt".
     * If successful, write the decryptedFile string to it, then close the file.
     */
    public void toFile()
    {
        //try to open the output file, then write the encryptedFile String to it
        try
        {
            PrintWriter outputFile = new PrintWriter("nosecret.txt");
            outputFile.print(decryptedFile);
            System.out.println("File decryption success!");
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
        return decryptedFile;
    }
}
