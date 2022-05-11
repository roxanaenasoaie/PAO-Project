package Application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromCsv
{
    public static void read(String filename)
    {
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(splitBy);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}  