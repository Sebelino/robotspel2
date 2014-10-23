package robotspel2;

import java.awt.Graphics2D;
import java.awt.Color;

public class Sensorpartikel extends Sprite
{
    private int robotID;
    private Vektor2D riktningStart;
    private int deathtime;
    private boolean tricked;

    public Sensorpartikel(int robotID,Punkt2D p,double width,double height,Vektor2D riktning,double speed,int deathtime)
    {
        super(robotID,p,width,height,riktning,speed);
        riktningStart = new Vektor2D(riktning);
        this.deathtime = deathtime;
        tricked = false;
    }

    public Vektor2D getRiktningStart()
    {
        return riktningStart;
    }

    public int getDeathtime()
    {
        return deathtime;
    }

    public boolean getTricked()
    {
        return tricked;
    }

    public void setTricked(boolean value)
    {
        tricked = value;
    }

    public void decreaseDeathtime()
    {
        deathtime--;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(new Color(128,0,128));
        g.fillRect(SpelUtil.avrunda(mittpt.getX()-width/2),SpelUtil.avrunda(mittpt.getY()-height/2),SpelUtil.avrunda(width),SpelUtil.avrunda(height));
        g.setColor(Color.BLACK);
    }
}
