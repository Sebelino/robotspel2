package robotspel2;

import java.awt.*;

public class Block extends Form
{
    public Block(Punkt2D p,
                 double width,
                 double height)
    {
        super(p,width,height);
        if(width < 0)
        {
            width *= -1;
        }
        if(height < 0)
        {
            height *= -1;
        }
    }

    public Block(Punkt2D NW,
                 Punkt2D SE)
    {
        super(new Punkt2D((NW.getX()+SE.getX())/2,(NW.getY()+SE.getY())/2),SE.getX()-NW.getX(),SE.getY()-NW.getY());
        if(width < 0)
        {
            width *= -1;
        }
        if(height < 0)
        {
            height *= -1;
        }
    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.RED);
        g.fillRect(SpelUtil.avrunda(getX()-width/2),
                   SpelUtil.avrunda(getY()-height/2),
                   SpelUtil.avrunda(width),
                   SpelUtil.avrunda(height));
        g.setColor(Color.BLACK);
    }
}
