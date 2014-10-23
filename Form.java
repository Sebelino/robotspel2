package robotspel2;

import java.awt.Graphics2D;

abstract public class Form
{
    protected Punkt2D mittpt;
    protected double width;
    protected double height;

    public Form(){}

    public Form(Punkt2D mittpt,double width,double height)
    {
        this.mittpt = new Punkt2D(mittpt);
        this.width = width;
        this.height = height;
    }

    public boolean inside(Punkt2D p)
    {
        return (p.getX() > mittpt.getX()-width/2 &&
                p.getY() > mittpt.getY()-height/2 &&
                p.getX() < mittpt.getX()+width/2 &&
                p.getY() < mittpt.getY()+height/2);
    }

    public boolean inside(Form form)
    {
        return (mittpt.getX()-width/2 > form.getX()-form.getWidth()/2 &&
                mittpt.getY()-height/2 > form.getY()-form.getHeight()/2 &&
                mittpt.getX()+width/2 < form.getX()+form.getWidth()/2 &&
                mittpt.getY()+height/2 < form.getY()+form.getHeight()/2);
    }

    public boolean touches(Form form)
    {
        return (mittpt.getX()-width/2 < form.getX()+form.getWidth()/2 &&
                mittpt.getY()-height/2 < form.getY()+form.getHeight()/2 &&
                mittpt.getX()+width/2 > form.getX()-form.getWidth()/2 &&
                mittpt.getY()+height/2 > form.getY()-form.getHeight()/2);
    }

    abstract public void draw(Graphics2D g);

    public Punkt2D getPunkt2D()
    {
        return mittpt;
    }

    public double getX()
    {
        return mittpt.getX();
    }

    public double getY()
    {
        return mittpt.getY();
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setPunkt2D(Punkt2D value)
    {
        mittpt = value;
    }

    public void addPunkt2D(Punkt2D value)
    {
        mittpt.add(value);
    }

    public void setX(double value)
    {
        mittpt.setX(value);
    }

    public void setY(double value)
    {
        mittpt.setY(value);
    }
}
