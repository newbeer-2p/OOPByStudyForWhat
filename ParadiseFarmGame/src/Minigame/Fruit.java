package Minigame;

import MyLibrary.*;
import Page.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fruit implements Runnable {

    private GetFruitGame p;
    private Thread t;
    private int movement = (int) (Math.random() * 20 + 10);
    private BasketPlayer player;
    private MyImage img;

    private boolean canHit;

    public Fruit(String name, GetFruitGame p) {
        this(name, 0, p);
    }

    public Fruit(String name, int x, GetFruitGame p) {
        this.p = p;
        img = new MyImage(name, x, -200);
        img.setSize(img.getWidth()/4, img.getHeight()/4);
        player = p.getPlayer();
        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics2D g2d) {
        g2d.drawImage(img.loadImage(), img.getX(), img.getY(), img.getWidth(), img.getHeight(), null);
    }

    @Override
    public void run() {
        while (!p.isStop()) {
            try {
                if (canHit || img.getY() > MainView.HEIGHT) {
                    p.removeFruit(this);
                }
                if (img.isHit(player.getImg())) {
                    p.addFruitCollect(this);
                }
                img.setY(img.getY()+movement);
                p.getView().repaint();
                Thread.sleep(50);
            } catch (InterruptedException ex) {

            }

        }
    }
    
    

}
