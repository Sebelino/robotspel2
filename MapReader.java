/*package robotspel2;

import java.io.*;
import java.util.*;

public class MapReader
{
    public MapReader(String fil)
    {
        Block[] block = getBlock(fil);
    }

    public static Block[] getBlock(String fil)
    {
        String[] rader = fillasare(fil);
    }

    public static String[] fillasare(String fil)
    {
        Vector<String> rader;
        try
        {
            FileReader fr = new FileReader(fil);
            BufferedReader input = new BufferedReader(fr);
            String rad = input.readLine();
            int i = 0;
            while(rad != null)
            {
                rader.add(rad);
                rad = input.readLine();
                i++;
            }
            input.close();
        }
        catch(FileNotFoundException e1)
        {
            System.out.println("Filen hittades inte.");
        }
        catch(IOException e2)
        {
            System.out.println("Foljande fel: "+ e2);
        }
        String[] raders = new String[rader.size()];
        raders = rader.toArray(raders);
    }
}*/
