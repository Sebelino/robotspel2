package robotspel2.robotar.sebe;

import java.util.*;

import robotspel2.*;

public class MinneSebe
{
    private Punkt2D p;
    private ArrayList<Punkt2D> sakraPos;
    private ArrayList<Punkt2D> positioner;
    private ArrayList<Vektor2D> riktningar;
    private ArrayList<Punkt2D> gropar;
    private int tid;

    public MinneSebe()
    {
        p = new Punkt2D(0,0);
        sakraPos = new ArrayList<Punkt2D>();
        positioner = new ArrayList<Punkt2D>();
        riktningar = new ArrayList<Vektor2D>();
        gropar = new ArrayList<Punkt2D>();
        tid = 0;
    }

    public void add(Feedback fb)
    {
        for(int i = 0;i < fb.getGropar().length;i++)
        {
            int grop = fb.getGropar()[i];
            int livstid = fb.getLifetimes()[i];
            Vektor2D riktning = fb.getRiktningar()[i];
            riktning.multiplicera(livstid*Consts.SENSORSPEED);
            if(grop == 1)
                addGrop(new Punkt2D(riktning));
        }
    }

    public void addGrop(Punkt2D add)
    {
        gropar.add(Punkt2D.add(p,add));
    }

    public Punkt2D getGrop(int i)
    {
        if(i >= gropar.size())
        {
            return null;
        }
        return gropar.get(i);
    }

    public int getGroparLength()
    {
        return gropar.size();
    }

    public Punkt2D getP()
    {
        return p;
    }

    public void addP(Punkt2D pt)
    {
        p.add(pt);
    }
}
