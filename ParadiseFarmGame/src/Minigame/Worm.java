package Minigame;

import Main.*;
import java.awt.*;

public class Worm implements Runnable {

    private Thread t;
    private CatchWormGameView p;
    
    private MyImage img;

    public Worm(CatchWormGameView p) {
        this.p = p;
        img = new MyImage("worm.png");
        img.setSize(img.getWidth() / 6, img.getHeight() / 6);
        move();
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (!p.isGameOver()) {
            try {
                GameController.view.repaint();
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void paint(Graphics2D g2d) {
        int ranX = (int) (Math.random() > 0.5 ? 1 : -1);
        int ranY = (int) (Math.random() > 0.5 ? 1 : -1);
        g2d.drawImage(img.loadImage(), img.getX() + ranX, img.getY() + ranY, img.getWidth(), img.getHeight(), null);
    }

    public void move() {
        if (!p.isGameOver()) {
            img.setLocation((int) (Math.random() * 700), (int) (Math.random() * 700));

        }
    }

    public MyImage getImg() {
        return img;
    }

    public void setImg(MyImage img) {
        this.img = img;
    }

}
