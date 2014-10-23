package robotspel2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Huvud
{
    Spel frame;

    public Huvud()
    {
        Startruta start = new Startruta();
        while(!start.getStartad()){}
        start.destroy();
        frame = new Spel();
        initiera();
        while(frame.getRestart())
        {
            frame.konstruera();
            frame.spring();
        }
        destroy(frame);
    }

    public void initiera()
    {
        frame.setTitle("Robotspel2");
        frame.addWindowListener(new WindowAdapter()
                                    {
                                        public void windowClosing(WindowEvent event)
                                        {
                                            System.exit(0);
                                        }
                                    });
        frame.setSize(Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    public void destroy(JFrame frame)
    {
        frame.setVisible(false);
        frame.dispose();
    }
}
