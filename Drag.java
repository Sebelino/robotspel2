package robotspel2;

public class Drag
{
    private int redskap;
    private Vektor2D[] riktningar;
    private Vektor2D[] trickriktningar;
    private int[] deathtimes;
    private boolean legal;

    public Drag(int redskap,Vektor2D[] riktningar)
    {
        legal = true;
        if(redskap == Consts.HJUL)
        {
            this.redskap = redskap;
            this.riktningar = new Vektor2D[Consts.HJULSTEG];
            if(this.riktningar.length == riktningar.length)
            {
                for(int i = 0;i < riktningar.length;i++)
                {
                    this.riktningar[i] = new Vektor2D(riktningar[i]);
                }
            }
            else
            {
                System.out.println("Drag bortkastat.");
                legal = false;
            }
        }
        else if(redskap == Consts.RADAR)
        {
            this.redskap = redskap;
            this.riktningar = new Vektor2D[Consts.RADARPARTIKLAR];
            if(this.riktningar.length == riktningar.length)
            {
                for(int i = 0;i < riktningar.length;i++)
                {
                    this.riktningar[i] = new Vektor2D(riktningar[i]);
                }
            }
            else
            {
                System.out.println("Drag bortkastat.");
                legal = false;
            }
        }
        else if(redskap == Consts.KANON)
        {
            this.redskap = redskap;
            this.riktningar = new Vektor2D[Consts.KANONPARTIKLAR];
            if(this.riktningar.length == riktningar.length)
            {
                for(int i = 0;i < riktningar.length;i++)
                {
                    this.riktningar[i] = new Vektor2D(riktningar[i]);
                }
            }
            else
            {
                System.out.println("Drag bortkastat.");
                legal = false;
            }
        }
        else
        {
            System.out.println("Fel i en av Drag.java:s konstruktorer!");
        }
    }

    public Drag(int redskap,Vektor2D[] riktningar,int[] deathtimes)
    {
        legal = true;
        if(redskap == Consts.SENSOR && riktningar.length == deathtimes.length)
        {
            this.redskap = redskap;
            this.riktningar = new Vektor2D[Consts.SENSORPARTIKLAR];
            this.deathtimes = new int[Consts.SENSORPARTIKLAR];
            if(this.riktningar.length == riktningar.length && this.deathtimes.length == deathtimes.length)
            {
                for(int i = 0;i < riktningar.length;i++)
                {
                    this.riktningar[i] = new Vektor2D(riktningar[i]);
                    this.deathtimes[i] = deathtimes[i];
                }
            }
            else
            {
                System.out.println("Drag bortkastat.");
                legal = false;
            }
        }
        else
        {
            System.out.println("Fel i en av Drag.java:s konstruktorer!");
        }
    }

    public Drag(int redskap,Vektor2D[] riktningar,Vektor2D[] trickriktningar)
    {
        legal = true;
        if(redskap == Consts.TRICKER && riktningar.length == trickriktningar.length)
        {
            this.redskap = redskap;
            this.riktningar = new Vektor2D[Consts.TRICKERPARTIKLAR];
            this.trickriktningar = new Vektor2D[Consts.TRICKERPARTIKLAR];
            if(this.riktningar.length == riktningar.length && this.trickriktningar.length == trickriktningar.length)
            {
                for(int i = 0;i < riktningar.length;i++)
                {
                    this.riktningar[i] = new Vektor2D(riktningar[i].getX(),riktningar[i].getY());
                    this.trickriktningar[i] = new Vektor2D(trickriktningar[i].getX(),trickriktningar[i].getY());
                }
            }
            else
            {
                System.out.println("Drag bortkastat.");
                legal = false;
            }
        }
        else
        {
            System.out.println("Fel i en av Drag.java:s konstruktorer!");
        }
    }

    public boolean getLegal()
    {
        return legal;
    }

    public int getRedskap()
    {
        return redskap;
    }

    public Vektor2D[] getRiktningar()
    {
        return riktningar;
    }

    public Vektor2D[] getTrickriktningar()
    {
        return trickriktningar;
    }

    public int[] getDeathtimes()
    {
        return deathtimes;
    }
}
