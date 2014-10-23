package robotspel2;

import java.awt.*;

public class Grop extends Form
{
    public Grop(Punkt2D p,
                double width,
                double height)
    {
        super(p,width,height);
    }

    public void draw(Graphics2D g)
    {
        g.fillRect(SpelUtil.avrunda(getX()-width/2),
                   SpelUtil.avrunda(getY()-height/2),
                   SpelUtil.avrunda(width),
                   SpelUtil.avrunda(height));
    }
}
