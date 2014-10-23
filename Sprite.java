package robotspel2;

abstract public class Sprite extends Form
{
    protected final int ID;
    protected Vektor2D riktning;
    protected double speed;
    protected boolean life;
    protected int lifetime;

    public Sprite(int ID,Punkt2D p,double width,double height)
    {
        super(p,width,height);
        riktning = new Vektor2D(0,0);
        speed = 0;
        this.ID = ID;
        life = true;
        lifetime = 0;
    }

    public Sprite(int ID,Punkt2D p,double width,double height,double speed)
    {
        super(p,width,height);
        this.riktning = new Vektor2D(0,0);
        this.speed = speed;
        this.ID = ID;
        life = true;
        lifetime = 0;
    }

    public Sprite(int ID,Punkt2D p,double width,double height,Vektor2D riktning,double speed)
    {
        super(p,width,height);
        this.riktning = new Vektor2D(riktning);
        this.speed = speed;
        this.ID = ID;
        life = true;
        lifetime = 0;
    }

    public void moveForward()
    {
        mittpt.add(new Punkt2D(new Vektor2D(speed,riktning)));
    }

    public void moveBackward()
    {
        mittpt.add(new Punkt2D(new Vektor2D(-speed,riktning)));
    }

    public Vektor2D getRiktning()
    {
        return riktning;
    }

    public void setRiktning(Vektor2D riktning)
    {
        this.riktning = new Vektor2D(riktning);
    }

    public double getSpeed()
    {
        return speed;
    }

    public int getID()
    {
        return ID;
    }

    public boolean getLife()
    {
        return life;
    }

    public void setLife(boolean value)
    {
        this.life = value;
    }

    public int getLifetime()
    {
        return lifetime;
    }

    public void increaseLifetime()
    {
        lifetime++;
    }
}
