package robotspel2;

import java.util.ArrayList;

public class Feedback
{
    private ArrayList<Vektor2D> rikts;
    private ArrayList<Integer> lifetimes;
    private ArrayList<Integer> gropar;
    private int trickade;
    private boolean robotkrock;
    private int kills;

    public Feedback()
    {
        rikts = new ArrayList<Vektor2D>();
        lifetimes = new ArrayList<Integer>();
        trickade = 0;
        robotkrock = false;
        gropar = new ArrayList<Integer>();
        kills = 0;
    }

    public Vektor2D[] getRiktningar()
    {
        Vektor2D[] temp = new Vektor2D[rikts.size()];
        for(int i = 0;i < temp.length;i++)
        {
            temp[i] = rikts.get(i);
        }
        return temp;
    }

    public int[] getLifetimes()
    {
        int[] temp = new int[lifetimes.size()];
        for(int i = 0;i < temp.length;i++)
        {
            temp[i] = lifetimes.get(i);
        }
        return temp;
    }

    public int[] getGropar()
    {
        int[] temp = new int[gropar.size()];
        for(int i = 0;i < temp.length;i++)
        {
            temp[i] = gropar.get(i);
        }
        return temp;
    }

    public int getTrickade()
    {
        return trickade;
    }

    public boolean getRobotkrock()
    {
        return robotkrock;
    }

    public int getKills()
    {
        return kills;
    }

    public void addGrop(int value)
    {
        gropar.add(value);
    }

    public void addGrop(boolean value)
    {
        if(value)
        {
            gropar.add(1);
        }
        else
        {
            gropar.add(-1);
        }
    }

    public void addPartikelData(Vektor2D riktning,int lifetime)
    {
        rikts.add(riktning);
        lifetimes.add(new Integer(lifetime));
    }

    public void setRobotkrock(boolean value)
    {
        robotkrock = value;
    }

    public void increaseKills()
    {
        kills++;
    }

    public void increaseTrickade()
    {
        trickade++;
    }
}
