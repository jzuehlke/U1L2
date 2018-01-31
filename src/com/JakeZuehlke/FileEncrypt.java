package com.JakeZuehlke;

public class FileEncrypt
{
    private String unencryptedFile;

    public FileEncrypt(String file)
    {
        this.unencryptedFile = file;
    }

    public String Encryption()
    {
        String encryptedFile = "";
        char[] unencryptedFileChars = unencryptedFile.toCharArray();

        for(int i = 0; i < unencryptedFileChars.length; i++)
        {
            encryptedFile += unencryptedFileChars[i] + 5;
        }
        return encryptedFile;
    }

    @Override
    public String toString()
    {
        return unencryptedFile;
    }
}
