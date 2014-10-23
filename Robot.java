package robotspel2;

import java.util.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Robot extends Sprite
{
    protected Spelare spelare;
    protected int loading;

    public Robot(int ID,Spelare spelare,Punkt2D p,double width,double height,double speed)
    {
        super(ID,p,width,height,speed);
        this.spelare = spelare;
        speed = Consts.ROBOTSPEED;
        loading = 1;
    }

    public Drag dinTur()
    {
        loading--;
        spelare.dinTur();
        if(spelare.getDrag().getRedskap() == Consts.HJUL)
        {
            if(loading == 0)
            {
                loading = Consts.HJULLOADING;
            }
            return spelare.getDrag();
        }
        if(loading != 0)
        {
            System.out.println("Drag bortkastat.");
            return null;
        }
        if(spelare.getDrag().getRedskap() == Consts.RADAR)
        {
            loading = Consts.RADARLOADING;
        }
        else if(spelare.getDrag().getRedskap() == Consts.SENSOR)
        {
            loading = Consts.SENSORLOADING;
        }
        else if(spelare.getDrag().getRedskap() == Consts.TRICKER)
        {
            loading = Consts.TRICKERLOADING;
        }
        else if(spelare.getDrag().getRedskap() == Consts.KANON)
        {
            loading = Consts.KANONLOADING;
        }
        return spelare.getDrag();
    }

    public void informera(Feedback fb)
    {
        spelare.informera(fb);
    }

    public String getNamn()
    {
        return spelare.getNamn();
    }

    public void draw(Graphics2D g)
    {
        BufferedImage img = ImageUtil.resize(spelare.getBild(),SpelUtil.avrunda(width),SpelUtil.avrunda(height));

        g.drawImage(img,
                    null,
                    SpelUtil.avrunda(mittpt.getX()-width/2),
                    SpelUtil.avrunda(mittpt.getY()-height/2));
    }
}
