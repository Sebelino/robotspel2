package robotspel2;

import java.awt.image.BufferedImage;

abstract public class Spelare
{
    protected final int HJUL = Consts.HJUL;
    protected final int RADAR = Consts.RADAR;
    protected final int SENSOR = Consts.SENSOR;
    protected final int TRICKER = Consts.TRICKER;
    protected final int KANON = Consts.KANON;

    protected String namn;
    protected BufferedImage bild;
    protected Drag drag;

    public Spelare(String namn,String bildnamn)
    {
        this.namn = namn;
        bild = SpelUtil.laddaBild(bildnamn);
    }

    abstract public void dinTur();

    abstract public void informera(Feedback feedback);

    public Drag getDrag()
    {
        return drag;
    }

    public BufferedImage getBild()
    {
        return bild;
    }

    public String getNamn()
    {
        return namn;
    }
}
