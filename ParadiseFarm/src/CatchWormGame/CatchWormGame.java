package CatchWormGame;

import MyLibrary.*;
import MainGame.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CatchWormGame extends JPanel implements MouseListener{
    
    private Graphics2D g2d;
    private Worm worm = new Worm(this);
    private MyTimer tmr;
    private int score;

    public CatchWormGame() {
        tmr = new MyTimer(20, true);
        addMouseListener(this);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        worm.paint(g2d);
        g2d.setFont(new Font("Courier New", 1, 26));
        g2d.drawString("Time: "+tmr.getTime(), 10, 30);
        g2d.drawString("Score: "+score, mainFrame.widthScreen-167, 30);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (worm.catchWorm(me.getX(), me.getY())){
            worm.move();
            score++;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
