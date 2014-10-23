package robotspel2.robotar.samplerobot;

import java.util.*;

import robotspel2.Punkt2D;
import robotspel2.Vektor2D;
import robotspel2.Feedback;

public class MinneSample
{
    private Punkt2D relativPos;
    private ArrayList<Punkt2D> sakraPos;
    private ArrayList<Punkt2D> positioner;
    private ArrayList<Vektor2D> riktningar;
    private ArrayList<Punkt2D> gropar;
    private int tid;

    public MinneSample()
    {
        relativPos = new Punkt2D(0,0);
        sakraPos = new ArrayList<Punkt2D>();
        positioner = new ArrayList<Punkt2D>();
        riktningar = new ArrayList<Vektor2D>();
        gropar = new ArrayList<Punkt2D>();
        tid = 0;
    }

    public void add(Feedback fb)
    {
        
    }
}
