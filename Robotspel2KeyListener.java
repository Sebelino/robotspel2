package robotspel2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class Robotspel2KeyListener implements KeyListener
{
    private boolean plus;
    private boolean minus;
    private boolean p;
    private boolean r;
    private boolean esc;

    public Robotspel2KeyListener()
    {
        avaktivera();
    }

    public void keyTyped(KeyEvent e){}

    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_PLUS:      plus = true;
                                        break;
            case KeyEvent.VK_MINUS:     minus = true;
                                        break;
            case KeyEvent.VK_P:         p = true;
                                        break;
            case KeyEvent.VK_R:         r = true;
                                        break;
            case KeyEvent.VK_ESCAPE:    esc = true;
        }
    }

    public void keyReleased(KeyEvent e){}

    public boolean getPlus()
    {
        return plus;
    }

    public boolean getMinus()
    {
        return minus;
    }

    public boolean getP()
    {
        return p;
    }

    public boolean getR()
    {
        return r;
    }

    public boolean getEsc()
    {
        return esc;
    }

    public void avaktivera()
    {
        plus = false;
        minus = false;
        p = false;
        r = false;
        esc = false;
    }
}
