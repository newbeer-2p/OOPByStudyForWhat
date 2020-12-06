package Minigame;

import Main.MyImage;
import Main.GameView;
import MyLibrary.*;
import java.awt.*;
import Page.*;

public class Worm implements Runnable {

    private Graphics2D g2d;
    private int degree;
    private Thread t;
    private CatchWormGameView p;
    private MyImage img;

    public Worm(CatchWormGameView p) {
        this.p = p;
        img = new MyImage("worm.png");
        img.setSize(img.getWidth() / 6, img.getHeight() / 6);
        img.setLocation((int) (Math.random() * (GameView.WIDTH - img.getWidth() - 100)), (int) (Math.random() * (GameView.HEIGHT - img.getHeight()-100)));
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                p.getView().repaint();
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
        img.setLocation((int) (Math.random() * (GameView.WIDTH - img.getWidth())), (int) (Math.random() * (GameView.HEIGHT + img.getHeight())));
    }

    public MyImage getImg() {
        return img;
    }

    public void setImg(MyImage img) {
        this.img = img;
    }
    
    

}
