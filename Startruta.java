package robotspel2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Startruta extends JFrame
                       implements ActionListener
{
    private JLabel titel;
    private JLabel version;
    private JLabel cred;
    private JLabel kontroller;
    private JLabel kontroller1;
    private JLabel kontroller2;
    private JLabel kontroller3;
    private JLabel kontroller4;
    private JLabel kontroller5;
    private JButton starta;
    private boolean startad;

    public Startruta()
    {
        super("Sebastian Olsson's Robotspel2");
        getContentPane().setLayout(new GridLayout(1,1));
        init();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter()
                              {
                                  public void windowClosing(WindowEvent e)
                                  {
                                      System.exit(0);
                                  }
                              });
        pack();
        startad = false;
        setVisible(true);
    }

    private void init()
    {
        titel = new JLabel("Sebastian Olsson's Robotspel2");
        version = new JLabel("Version 1.5");
        cred = new JLabel("Credits: Sebastian Olsson, NV07A; Niclas Andersson, NV0XX");
        kontroller = new JLabel("Kontroller:");
        kontroller1 = new JLabel("+: Ökad FPS");
        kontroller2 = new JLabel("-: Minskad FPS");
        kontroller3 = new JLabel("P: Paus");
        kontroller4 = new JLabel("R: Omstart");
        kontroller5 = new JLabel("Esc: Avsluta");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9,3));
        starta = new JButton("Start");
        starta.addActionListener(this);

        panel.add(new JLabel(""));
        panel.add(titel);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(version);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(kontroller);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(kontroller1);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(kontroller2);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(kontroller3);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(kontroller4);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(kontroller5);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(starta);
        getContentPane().add(panel);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == starta)
        {
            System.out.println("Knappen funkar?"+startad);
            startad = true;
        }
        else
        {
            System.out.println("Vad hande nu, manntro?");
        }
    }

    public boolean getStartad()
    {
        return startad;
    }

    public void destroy()
    {
        setVisible(false);
        dispose();
    }
}
