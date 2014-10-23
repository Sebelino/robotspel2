package robotspel2;

import java.awt.Graphics2D;
import java.awt.Color;

public class Radarpartikel extends Sprite
{
    private int robotID;
    private Vektor2D riktningStart;
    private boolean tricked;

    public Radarpartikel(int robotID,Punkt2D p,double width,double height,Vektor2D riktning,double speed)
    {
        super(robotID,p,width,height,riktning,speed);
        riktningStart = new Vektor2D(riktning);
        tricked = false;
    }

    public Vektor2D getRiktningStart()
    {
        return riktningStart;
    }

    public boolean getTricked()
    {
        return tricked;
    }

    public void setTricked(boolean value)
    {
        tricked = value;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(new Color(0,128,0));
        g.fillRect(SpelUtil.avrunda(mittpt.getX()-width/2),SpelUtil.avrunda(mittpt.getY()-height/2),SpelUtil.avrunda(width),SpelUtil.avrunda(height));
        g.setColor(Color.BLACK);
    }
}
