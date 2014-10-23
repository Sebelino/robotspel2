/*
Den här spelarklassen är hjärnan för en provrobot, med syfte att demonstrera en robots fulla potential.

Cooldown för redskapen står i Consts.java.
*/

package robotspel2.robotar.samplerobot;

import java.io.File;

import robotspel2.*;

public class SampleRobot extends Spelare
{
    private MinneSample minne;
    private int actraiser;
    private int actraiser2;
    private boolean filraiser;
    private int loading;
    private Vektor2D[] move;
    private Vektor2D[] kanon;

    public SampleRobot()
    {
        super("SampleRobot","SampleRobot.png");
        minne = new MinneSample();
        actraiser = 0;
        actraiser2 = Consts.KANON;
        filraiser = false;
        loading = 0;
        move = new Vektor2D[1];
        move[0] = new Vektor2D(-1,-1);
        kanon = new Vektor2D[1];
        kanon[0] = new Vektor2D(1,1);
    }

    public void dinTur()
    {
        if(loading == 0 && actraiser2 == Consts.KANON)
        {
            loading = Consts.KANONLOADING;
            actraiser2 = Consts.RADAR;
            kanon[0] = new Vektor2D(Math.cos((double)actraiser/10),
                                    Math.sin((double)actraiser/10));
            drag = new Drag(KANON,kanon);
        }
        else if(loading == 0 && actraiser2 == Consts.RADAR)
        {
            loading = Consts.RADARLOADING;
            actraiser2 = Consts.TRICKER;
            Vektor2D[] vekts = {new Vektor2D(Math.cos((double)actraiser/100),
                                             Math.sin((double)actraiser/100)),
                                new Vektor2D(Math.cos((double)actraiser/100+0.1),
                                             Math.sin((double)actraiser/100+0.1)),
                                new Vektor2D(Math.cos((double)actraiser/100+0.2),
                                             Math.sin((double)actraiser/100+0.2)),
                                new Vektor2D(Math.cos((double)actraiser/100+0.3),
                                             Math.sin((double)actraiser/100+0.3))};
            drag = new Drag(RADAR,vekts);
        }
        else if(loading == 0 && actraiser2 == Consts.TRICKER)
        {
            loading = Consts.TRICKERLOADING;
            actraiser2 = Consts.SENSOR;
            Vektor2D[] vekts = {new Vektor2D(Math.cos((double)actraiser/80),
                                             Math.sin((double)actraiser/80)),
                                new Vektor2D(Math.cos((double)actraiser/80+0.1),
                                             Math.sin((double)actraiser/80+0.1)),
                                new Vektor2D(Math.cos((double)actraiser/80+0.2),
                                             Math.sin((double)actraiser/80+0.2)),
                                new Vektor2D(Math.cos((double)actraiser/80+0.3),
                                             Math.sin((double)actraiser/80+0.3)),
                                new Vektor2D(Math.cos((double)actraiser/80+0.4),
                                             Math.sin((double)actraiser/80+0.4)),
                                new Vektor2D(Math.cos((double)actraiser/80+0.5),
                                             Math.sin((double)actraiser/80+0.5)),
                                new Vektor2D(Math.cos((double)actraiser/80+0.6),
                                             Math.sin((double)actraiser/80+0.6)),
                                new Vektor2D(Math.cos((double)actraiser/80+0.7),
                                             Math.sin((double)actraiser/80+0.7))};
            Vektor2D[] trickvekts = {new Vektor2D(-Math.cos((double)actraiser/80),
                                                  -Math.sin((double)actraiser/80)),
                                     new Vektor2D(-Math.cos((double)actraiser/80-0.1),
                                                  -Math.sin((double)actraiser/80-0.1)),
                                     new Vektor2D(-Math.cos((double)actraiser/80-0.2),
                                                  -Math.sin((double)actraiser/80-0.2)),
                                     new Vektor2D(-Math.cos((double)actraiser/80-0.3),
                                                  -Math.sin((double)actraiser/80-0.3)),
                                     new Vektor2D(-Math.cos((double)actraiser/80-0.4),
                                                  -Math.sin((double)actraiser/80-0.4)),
                                     new Vektor2D(-Math.cos((double)actraiser/80-0.5),
                                                  -Math.sin((double)actraiser/80-0.5)),
                                     new Vektor2D(-Math.cos((double)actraiser/80-0.6),
                                                  -Math.sin((double)actraiser/80-0.6)),
                                     new Vektor2D(-Math.cos((double)actraiser/80-0.7),
                                                  -Math.sin((double)actraiser/80-0.7))};
            drag = new Drag(TRICKER,vekts,trickvekts);
        }
        else if(loading == 0 && actraiser2 == Consts.SENSOR)
        {
            loading = Consts.SENSORLOADING;
            actraiser2 = Consts.KANON;
            Vektor2D[] vekts = {new Vektor2D(Math.cos((double)actraiser/30),
                                             Math.sin((double)actraiser/30))};
            int[] deathtimes = {50};
            drag = new Drag(SENSOR,vekts,deathtimes);
        }
        else
        {
            if(loading == 0)
            {
                loading = Consts.HJULLOADING;
            }
            move[0].setArg(move[0].getArg()+0.01);
            drag = new Drag(HJUL,move);
        }
        actraiser++;
        loading--;
    }

    public void informera(Feedback fb)
    {
        for(int i = 0;i < fb.getGropar().length;i++)
        {
            if(fb.getGropar()[i] != 0)
            {
                if(fb.getGropar()[i] == 1)
                {
                    System.out.println("Sensorp.:"+fb.getRiktningar()[i].getX()+","+fb.getRiktningar()[i].getY()+";time:"+fb.getLifetimes()[i]+" detekterade grop!"+i);
                }
            }
        }
        if(fb.getRobotkrock())
        {
            System.out.println("Robot krockade!");
            move[0].multiplicera(-1);
        }
        if(fb.getTrickade() > 0)
        {
            System.out.println("Du trickade just "+fb.getTrickade()+"partiklar.");
        }
        if(fb.getKills() > 0)
        {
            System.out.println(fb.getKills()+" robotar dog nyss!");
        }
        memorize(fb);
    }

    private void memorize(Feedback fb)
    {

    }
}
