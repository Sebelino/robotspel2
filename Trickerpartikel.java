package robotspel2;

import java.awt.Graphics2D;
import java.awt.Color;

public class Trickerpartikel extends Sprite
{
    private int robotID;
    private Vektor2D riktningStart;
    private Vektor2D trickriktning;
    private int trickade;

    public Trickerpartikel(int robotID,Punkt2D p,double width,double height,Vektor2D riktning,double speed,Vektor2D trickriktning)
    {
        super(robotID,p,width,height,riktning,speed);
        riktningStart = new Vektor2D(riktning);
        this.trickriktning = new Vektor2D(trickriktning);
        trickade = 0;
    }

    public Vektor2D getRiktningStart()
    {
        return riktningStart;
    }

    public Vektor2D getTrickriktning()
    {
        return trickriktning;
    }

    public int getTrickade()
    {
        return trickade;
    }

    public void increaseTrickade()
    {
        trickade++;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(SpelUtil.avrunda(mittpt.getX()-width/2),SpelUtil.avrunda(mittpt.getY()-height/2),SpelUtil.avrunda(width),SpelUtil.avrunda(height));
        g.setColor(Color.BLACK);
    }
}
