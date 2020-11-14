/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minigame;

/**
 *
 * @author newbe
 */
import MainGame.mainFrame;
import javax.swing.*;
import java.awt.*;

public class Fruit extends ItemsGame implements Runnable {

    private GetFruitGame p;
    private Thread t;
    private int movement = (int) (Math.random() * 20 + 10);
    private boolean stop;
    private Player player;

    private boolean canHit;

    public Fruit(GetFruitGame p) {
        this(0, 100, 100, p);
    }

    public Fruit(int x, GetFruitGame p) {
        this(x, 100, 100, p);
    }

    public Fruit(int x, int w, int h, GetFruitGame p) {
        super(x, -200, w, h);
        this.p = p;
        player = p.getPlayer();
        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.gray);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.black);
        g2d.drawRect(x, y, width, height);
        
        
//        Test HitBox
//        g2d.drawRect(x, y, player.x+width, player.y+width);
//        g2d.setColor(Color.blue);
//        g2d.drawRect(x, y, player.x-height, player.y-height);
//        g2d.setColor(Color.black);
    }

    public void removeFruit(Graphics2D g2d) {

    }

    @Override
    public void run() {
        while (!stop) {
            try {
                if (canHit || y > mainFrame.heightScreen) {
                    p.removeFruit(this);
                    stop = true;
                }
                if (intersect()) {
                    p.addFruitCollect(this);
                }
                y += movement;
                p.repaint();
                Thread.sleep(50);
            } catch (InterruptedException ex) {

            }

        }
    }

    public boolean intersect() {
        boolean xYes = player.x+player.width > this.x && player.x-player.width < this.x;
        boolean yYes = player.y+player.height > this.y && player.y-player.height < this.y;
        return xYes && yYes;
    }

}
