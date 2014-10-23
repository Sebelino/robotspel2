package robotspel2;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.ArrayList;
import java.io.*;

public class SpelUtil
{
    public static BufferedImage laddaBild(String ref)
    {
        return ImageUtil.makeColorTransparent("Pics/"+ref,new Color(255,128,128));
    }

    public static int avrunda(double value)
    {
        if((int)(2*value) > 2*(int)value)
        {
            return (int)value+1;
        }
        else
        {
            return (int)value;
        }
    }

    public static String[] fillasare(String fil)
    {
        String pro = "Memory/";
        ArrayList<String> rader = new ArrayList<String>();
        try
        {
            FileReader fr = new FileReader(pro+fil);
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
        return raders;
    }

    public static void filskrivare(String[] info,String fil,boolean editera)
    {
        String pro = "Memory/";
        try
        {
            FileWriter fW = new FileWriter(pro+fil,editera);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pW = new PrintWriter(bW);
            for(int i = 0;i < info.length;i++)
            {
                pW.println(info[i]);
            }
            pW.close();
        }
        catch(FileNotFoundException e1)
        {
            System.out.println("Filen hittades inte.");
        }
        catch(IOException e2)
        {
            System.out.println(e2);
        }
    }

    public static void destroy(Object obj)
    {
        obj = null;
    }
}
