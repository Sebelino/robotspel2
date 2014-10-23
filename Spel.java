package robotspel2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.*;

import robotspel2.robotar.sebe.Sebe;
import robotspel2.robotar.samplerobot.SampleRobot;

public class Spel extends JFrame
{
    protected BufferedImage buffer;
    protected Graphics2D bufferg;

    Font font;
    private Robotspel2KeyListener nyckellyssnare;
    String winnar;

    protected ArrayList<Robot> robotar;
    protected Block[] block;
    protected Grop[] gropar;
    protected int[] IDs;
    protected ArrayList<Feedback> feedback;
    protected ArrayList<Radarpartikel> rp;
    protected ArrayList<Sensorpartikel> sp;
    protected ArrayList<Trickerpartikel> tp;
    protected ArrayList<Kanonpartikel> kp;

    private int endtimer = 100;
    private int FPS;
    private boolean pause;
    private boolean restart;

    public Spel()
    {
        font = new Font("monospaced",Font.BOLD | Font.ITALIC,20);
        FPS = Consts.FPSSTART;
        robotar = new ArrayList<Robot>();
        rp = new ArrayList<Radarpartikel>();
        tp = new ArrayList<Trickerpartikel>();
        sp = new ArrayList<Sensorpartikel>();
        kp = new ArrayList<Kanonpartikel>();
        feedback = new ArrayList<Feedback>();
        block = new Block[Consts.BLOCK];
        gropar = new Grop[Consts.GROPAR];
        nyckellyssnare = new Robotspel2KeyListener();
        addKeyListener(nyckellyssnare);
        restart = true;
    }

    public void konstruera()
    {
        restart = false;
        pause = false;
        destroyAll();
        initAll();
    }

    private void initAll()
    {
        initForms();
        for(int i = 0;i < robotar.size();i++)
        {
            feedback.add(new Feedback());
        }
        placeBlock();
        placeGropar();
        placeRobotar();
    }

    private void initForms()
    {
        initBlock();
        initGropar();
        Spelare[] spelare = new Spelare[Consts.ROBOTAR];
        spelare[0] = new Sebe();
//        spelare[0] = new SampleRobot();
        spelare[1] = new SampleRobot();
        spelare[2] = new SampleRobot();
        IDs = new int[spelare.length];
        for(int i = 0;i < IDs.length;i++)
        {
            IDs[i] = i+1;
        }
        initRobotar(spelare,IDs);
    }

    private void destroyAll()
    {
        destroyForms();
        feedback.clear();
    }

    private void destroyForms()
    {
        for(int i = 0;i < block.length;i++)
        {
            block[i] = null;
        }
        for(int i = 0;i < gropar.length;i++)
        {
            gropar[i] = null;
        }
        robotar.clear();
        rp.clear();
        sp.clear();
        tp.clear();
        kp.clear();
    }

    private void initBlock()
    {
        block[0] = new Block(new Punkt2D(0,0),new Punkt2D(10,Consts.FRAMESIZEY));
        block[1] = new Block(new Punkt2D(0,Consts.FRAMESIZEY-10),new Punkt2D(Consts.FRAMESIZEX,Consts.FRAMESIZEY));
        block[2] = new Block(new Punkt2D(Consts.FRAMESIZEX-10,0),new Punkt2D(Consts.FRAMESIZEX,Consts.FRAMESIZEY));
        block[3] = new Block(new Punkt2D(0,0),new Punkt2D(Consts.FRAMESIZEX,10));
    }

    private void initGropar()
    {
        for(int i = 0; i < gropar.length;i++)
        {
            gropar[i] = new Grop(new Punkt2D(0,0),Consts.GROPWIDTHMIN+(Consts.GROPWIDTHMAX-Consts.GROPWIDTHMIN)*Math.random(),Consts.GROPHEIGHTMIN+(Consts.GROPHEIGHTMAX-Consts.GROPHEIGHTMIN)*Math.random());
        }
    }

    private void initRobotar(Spelare[] spelare,int[] IDs)
    {
        robotar.add(new Robot(IDs[0],spelare[0],new Punkt2D(0,0),Consts.ROBOTWIDTH,Consts.ROBOTHEIGHT,Consts.ROBOTSPEED));
        robotar.add(new Robot(IDs[1],spelare[1],new Punkt2D(0,0),Consts.ROBOTWIDTH,Consts.ROBOTHEIGHT,Consts.ROBOTSPEED));
        robotar.add(new Robot(IDs[2],spelare[2],new Punkt2D(0,0),Consts.ROBOTWIDTH,Consts.ROBOTHEIGHT,Consts.ROBOTSPEED));
    }

    public void placeBlock()
    {
        for(int i = 4; i < block.length;i++)
        {
            block[i] = new Block(new Punkt2D(Consts.FRAMESIZEX*Math.random(),Consts.FRAMESIZEY*Math.random()),Consts.BLOCKWIDTHMIN+(Consts.BLOCKWIDTHMAX-Consts.BLOCKWIDTHMIN)*Math.random(),Consts.BLOCKHEIGHTMIN+(Consts.BLOCKHEIGHTMAX-Consts.BLOCKHEIGHTMIN)*Math.random());
        }
    }

    public void placeGropar()
    {
        for(int i = 0;i < gropar.length;i++)
        {
            for(int j = 0;j < block.length;j++)
            {
                if(gropar[i].touches(block[j]))
                {
                    gropar[i].setPunkt2D(new Punkt2D(Math.random()*Consts.FRAMESIZEX,Math.random()*Consts.FRAMESIZEY));
                    i = -1;
                    break;
                }
            }
        }
    }

    public void placeRobotar()
    {
        for(int i = 0;i < robotar.size();i++)
        {
            robotar.get(i).setPunkt2D(new Punkt2D(Math.random()*Consts.FRAMESIZEX,Math.random()*Consts.FRAMESIZEY));
            for(int j = 0;j < block.length;j++)
            {
                if(robotar.get(i).touches(block[j]))
                {
                    robotar.get(i).setPunkt2D(new Punkt2D(Math.random()*Consts.FRAMESIZEX,Math.random()*Consts.FRAMESIZEY));
                    j = -1;
                }
            }
            for(int j = 0;j < gropar.length;j++)
            {
                if(robotar.get(i).touches(gropar[j]))
                {
                    robotar.get(i).setPunkt2D(new Punkt2D(Math.random()*Consts.FRAMESIZEX,Math.random()*Consts.FRAMESIZEY));
                    i--;
                    break;
                }
            }
        }
    }

    public void spring()
    {
        if(buffer == null)
            buffer = (BufferedImage)createImage(Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        while(endtimer > 0 && !restart)
        {
            rita();
            regulateKeys();
            try
            {
                Thread.sleep((int)(1000/FPS));
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            uppdatera();
        }
    }

    private void regulateKeys()
    {
        if(nyckellyssnare.getEsc())
        {
            System.exit(1);
        }
        if(nyckellyssnare.getR())
        {
            restart = true;
        }
        if(nyckellyssnare.getP())
        {
            pause = true;
        }
        if(nyckellyssnare.getPlus())
        {
            FPS++;
        }
        else if(nyckellyssnare.getMinus())
        {
            if(FPS-1 > 0)
            {
                FPS--;
            }
        }
        nyckellyssnare.avaktivera();
        while(pause)
        {
            if(nyckellyssnare.getP())
            {
                pause = false;
            }
        }
        nyckellyssnare.avaktivera();
    }

    private void uppdatera()
    {
        for(int i = 0;i < feedback.size();i++)
        {
            feedback.set(i,new Feedback());
        }
        Drag[] drag = new Drag[robotar.size()];
        for(int i = 0;i < drag.length;i++)
        {
            drag[i] = robotar.get(i).dinTur();
        }
        illegalize(drag);
        for(int i = 0;i < drag.length;i++)
        {
            if(drag[i] != null)
            {
                if(drag[i].getRedskap() == Consts.HJUL)
                {
                    robotar.get(i).setRiktning(drag[i].getRiktningar()[0]);
                    moveRobot(i);
                }
                else if(drag[i].getRedskap() == Consts.RADAR)
                {
                    for(int j = 0;j < drag[i].getRiktningar().length;j++)
                    {
                        rp.add(new Radarpartikel(robotar.get(i).getID(),new Punkt2D(robotar.get(i).getPunkt2D()),Consts.RADARWIDTH,Consts.RADARHEIGHT,drag[i].getRiktningar()[j],Consts.RADARSPEED));
                    }
                }
                else if(drag[i].getRedskap() == Consts.TRICKER)
                {
                    for(int j = 0;j < drag[i].getRiktningar().length;j++)
                    {
                        tp.add(new Trickerpartikel(robotar.get(i).getID(),new Punkt2D(robotar.get(i).getPunkt2D()),Consts.TRICKERWIDTH,Consts.TRICKERHEIGHT,drag[i].getRiktningar()[j],Consts.TRICKERSPEED,drag[i].getTrickriktningar()[j]));
                    }
                }
                else if(drag[i].getRedskap() == Consts.SENSOR)
                {
                    for(int j = 0;j < drag[i].getRiktningar().length;j++)
                    {
                        sp.add(new Sensorpartikel(robotar.get(i).getID(),new Punkt2D(robotar.get(i).getPunkt2D()),Consts.SENSORWIDTH,Consts.SENSORHEIGHT,drag[i].getRiktningar()[j],Consts.SENSORSPEED,drag[i].getDeathtimes()[j]));
                    }
                }
                else if(drag[i].getRedskap() == Consts.KANON)
                {
                    for(int j = 0;j < drag[i].getRiktningar().length;j++)
                    {
                        kp.add(new Kanonpartikel(robotar.get(i).getID(),new Punkt2D(robotar.get(i).getPunkt2D()),Consts.KANONWIDTH,Consts.KANONHEIGHT,drag[i].getRiktningar()[j],Consts.KANONSPEED));
                    }
                }
            }
        }
        movePartiklar();
        regulatePartiklar();
        tricka();
        kanondoda();
        kill();
        fugit();
        inform(feedback);
        if(robotar.size() == 1)
        {
            winnar = robotar.get(0).getNamn();
        }
        if(robotar.size() == 0)
        {
            endtimer--;
        }
    }

    private void illegalize(Drag[] drag)
    {
        for(int i = 0;i < drag.length && drag[i] != null;i++)
        {
            if(!drag[i].getLegal())
            {
                drag[i] = null;
            }
        }
    }

    private void fugit()
    {
        for(int i = 0;i < robotar.size();i++)
        {
            robotar.get(i).increaseLifetime();
        }
        for(int i = 0;i < rp.size();i++)
        {
            rp.get(i).increaseLifetime();
        }
        for(int i = 0;i < sp.size();i++)
        {
            sp.get(i).increaseLifetime();
            sp.get(i).decreaseDeathtime();
        }
        for(int i = 0;i < tp.size();i++)
        {
            tp.get(i).increaseLifetime();
        }
        for(int i = 0;i < kp.size();i++)
        {
            kp.get(i).increaseLifetime();
        }
    }

    public void moveRobot(int ID)
    {
        robotar.get(ID).moveForward();
        for(int i = 0;i < block.length;i++)
        {
            if(robotar.get(ID).touches(block[i]))
            {
                feedback.get(ID).setRobotkrock(true);
                robotar.get(ID).moveBackward();
            }
        }
        for(int i = 0;i < robotar.size();i++)
        {
            if(robotar.get(ID).touches(robotar.get(i)) && robotar.get(i).getID() != robotar.get(ID).getID())
            {
                feedback.get(ID).setRobotkrock(true);
                feedback.get(i).setRobotkrock(true);
                robotar.get(ID).moveBackward();
                robotar.get(i).moveBackward();
            }
        }
    }

    public void movePartiklar()
    {
        for(int i = 0;i < rp.size();i++)
        {
            rp.get(i).moveForward();
        }
        for(int i = 0;i < sp.size();i++)
        {
            sp.get(i).moveForward();
        }
        for(int i = 0;i < tp.size();i++)
        {
            tp.get(i).moveForward();
        }
        for(int i = 0;i < kp.size();i++)
        {
            kp.get(i).moveForward();
        }
    }

    public void regulatePartiklar()
    {
        for(int i = 0;i < feedback.size();i++)
        {
            for(int j = 0;j < rp.size();j++)
            {
                boolean temp = false;
                for(int k = 0;k < block.length;k++)
                {
                    if(rp.get(j).touches(block[k]))
                    {
                        rp.get(j).setLife(false);
                        if(!temp)
                        {
                            temp = true;
                            feedback.get(i).addPartikelData(rp.get(j).getRiktningStart(),rp.get(j).getLifetime());
                            feedback.get(i).addGrop(0);
                        }
                        break;
                    }
                }
                for(int k = 0;k < robotar.size();k++)
                {
                    if(rp.get(j).touches(robotar.get(k)) && robotar.get(k).getID() != rp.get(j).getID())
                    {
                        rp.get(j).setLife(false);
                        if(!temp)
                        {
                            temp = true;
                            feedback.get(i).addPartikelData(rp.get(j).getRiktningStart(),rp.get(j).getLifetime());
                            feedback.get(i).addGrop(0);
                        }
                        break;
                    }
                }
                if(!insideSpel(rp.get(j)))
                {
                    rp.get(j).setLife(false);
                    if(!temp)
                    {
                        temp = true;
                        feedback.get(i).addPartikelData(rp.get(j).getRiktningStart(),rp.get(j).getLifetime());
                        feedback.get(i).addGrop(0);
                    }
                }
            }
            for(int j = 0;j < sp.size();j++)
            {
                if((sp.get(j).getDeathtime() <= 0 || !insideSpel(sp.get(j))) && (robotar.get(i).getID() == sp.get(j).getID()))
                {
                    boolean temp = true;
                    boolean temp2 = sp.get(j).getTricked();
                    for(int k = 0;k < gropar.length;k++)
                    {
                        if(sp.get(j).inside(gropar[k]))
                        {
                            temp2 = !sp.get(j).getTricked();
                            temp = false;
                            break;
                        }
                        else
                        {
                            temp2 = sp.get(j).getTricked();
                        }
                    }
                    sp.get(j).setLife(false);
                    feedback.get(i).addPartikelData(sp.get(j).getRiktningStart(),sp.get(j).getLifetime());
                    feedback.get(i).addGrop(temp2);
                }
            }
            for(int j = 0;j < tp.size();j++)
            {
                for(int k = 0;k < block.length;k++)
                {
                    if(tp.get(j).touches(block[k]) || !insideSpel(tp.get(j)))
                    {
                        tp.get(j).setLife(false);
                        feedback.get(i).addPartikelData(tp.get(j).getRiktningStart(),tp.get(j).getLifetime());
                        feedback.get(i).addGrop(0);
                    }
                }
            }
            for(int j = 0;j < kp.size();j++)
            {
                for(int k = 0;k < block.length;k++)
                {
                    if(kp.get(j).touches(block[k]) || !insideSpel(kp.get(j)))
                    {
                        kp.get(j).setLife(false);
                        feedback.get(i).addPartikelData(kp.get(j).getRiktningStart(),kp.get(j).getLifetime());
                        feedback.get(i).addGrop(0);
                    }
                }
            }
        }
    }

    public void tricka()
    {
        for(int i = 0;i < feedback.size();i++)
        {
            for(int j = 0;j < tp.size();j++)
            {
                for(int k = 0;k < rp.size();k++)
                {
                    if(tp.get(j).touches(rp.get(k)) && tp.get(j).getID() != rp.get(k).getID())
                    {
                        if(!rp.get(k).getTricked())
                        {
                            feedback.get(i).increaseTrickade();
                            rp.get(k).setTricked(true);
                        }
                        rp.get(k).setRiktning(new Vektor2D(tp.get(j).getTrickriktning()));
                    }
                }
                for(int k = 0;k < sp.size();k++)
                {
                    if(tp.get(j).touches(sp.get(k)) && tp.get(j).getID() != sp.get(k).getID())
                    {
                        if(!sp.get(k).getTricked())
                        {
                            feedback.get(i).increaseTrickade();
                            sp.get(k).setTricked(true);
                        }
                    }
                }
            }
        }
    }

    public void kanondoda()
    {
        for(int i = 0;i < feedback.size();i++)
        {
            for(int j = 0;j < kp.size();j++)
            {
                for(int k = 0;k < robotar.size();k++)
                {
                    if(kp.get(j).touches(robotar.get(k)) && kp.get(j).getID() != robotar.get(k).getID())
                    {
                        kp.get(j).setLife(false);
                        robotar.get(k).setLife(false);
                        feedback.get(i).increaseKills();
                    }
                }
            }
        }
    }

    public void kill()
    {
        for(int i = 0;i < rp.size();i++)
        {
            if(!rp.get(i).getLife())
            {
                rp.remove(i);
                i--;
            }
        }
        for(int i = 0;i < sp.size();i++)
        {
            if(!sp.get(i).getLife())
            {
                sp.remove(i);
                i--;
            }
        }
        for(int i = 0;i < tp.size();i++)
        {
            if(!tp.get(i).getLife())
            {
                tp.remove(i);
                i--;
            }
        }
        for(int i = 0;i < kp.size();i++)
        {
            if(!kp.get(i).getLife())
            {
                kp.remove(i);
                i--;
            }
        }
        for(int i = 0;i < robotar.size();i++)
        {
            for(int j = 0;j < gropar.length;j++)
            {
                if(gropar[j].inside(robotar.get(i).getPunkt2D()))
                {
                    robotar.get(i).setLife(false);                               //
                    for(int k = 0;k < feedback.size();k++)
                    {
                        feedback.get(k).increaseKills();
                    }
                    break;
                }
            }
        }
        for(int i = 0;i < robotar.size();i++)
        {
            if(!robotar.get(i).getLife())
            {
                robotar.remove(i);
                feedback.remove(i);
            }
        }
    }

    public void inform(ArrayList<Feedback> feedback)
    {
        for(int i = 0;i < robotar.size();i++)
        {
            robotar.get(i).informera(feedback.get(i));
        }
    }

    public boolean insideSpel(Form form)
    {
        return (form.getX() > 0 &&
                form.getY() > 0 &&
                form.getX() < Consts.FRAMESIZEX &&
                form.getY() < Consts.FRAMESIZEY);
    }

    public void rita()
    {
        if(bufferg == null)
        {
            bufferg = (Graphics2D)buffer.getGraphics();
        }
        radera(bufferg);
        draw(bufferg);
        Graphics2D g = (Graphics2D)this.getGraphics();
        g.drawImage(buffer,0,0,this);
        g.dispose();
    }

    public void drawRobotar(Graphics2D g)
    {
        for(int i = 0;i < robotar.size();i++)
        {
            robotar.get(i).draw(g);
        }
    }

    public void drawBlock(Graphics2D g)
    {
        for(int i = 0;i < block.length;i++)
        {
            block[i].draw(g);
        }
    }

    public void drawGropar(Graphics2D g)
    {
        for(int i = 0;i < gropar.length;i++)
        {
            gropar[i].draw(g);
        }
    }

    public void drawPartiklar(Graphics2D g)
    {
        for(int i = 0;i < tp.size();i++)
        {
            tp.get(i).draw(g);
        }
        for(int i = 0;i < rp.size();i++)
        {
            rp.get(i).draw(g);
        }
        for(int i = 0;i < sp.size();i++)
        {
            sp.get(i).draw(g);
        }
        for(int i = 0;i < kp.size();i++)
        {
            kp.get(i).draw(g);
        }
    }

    public boolean getRestart()
    {
        return restart;
    }

    private void draw(Graphics2D g)
    {
        drawBlock(g);
        drawGropar(g);
        drawRobotar(g);
        drawPartiklar(g);
        g.setFont(font);
        g.drawString("FPS:"+FPS,10,20);
        if(robotar.size() <= 1)
        {
            g.setColor(Color.ORANGE);
            g.drawString(winnar+", A WINNAR IS YOU!",(int)(0.5*Consts.FRAMESIZEX-200),(int)(0.5*Consts.FRAMESIZEY));
            g.setColor(Color.BLACK);
        }
    }

    private void radera(Graphics2D g)
    {
        g.setColor(Color.white);
        g.fillRect(0,0,Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        g.setColor(Color.black);
    }
}
