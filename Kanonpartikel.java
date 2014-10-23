package robotspel2;

import java.awt.Color;
import java.awt.Graphics2D;

public class Kanonpartikel extends Sprite
{
    private int robotID;
    private Vektor2D riktningStart;

    public Kanonpartikel(int robotID,Punkt2D p,double width,double height,Vektor2D riktning,double speed)
    {
        super(robotID,p,width,height,riktning,speed);
        riktningStart = new Vektor2D(riktning);
    }

    public Vektor2D getRiktningStart()
    {
        return riktningStart;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(SpelUtil.avrunda(mittpt.getX()-width/2),SpelUtil.avrunda(mittpt.getY()-height/2),SpelUtil.avrunda(width),SpelUtil.avrunda(height));
        g.setColor(Color.BLACK);
    }
}
