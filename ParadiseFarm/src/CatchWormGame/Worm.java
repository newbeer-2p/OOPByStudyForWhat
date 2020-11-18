package CatchWormGame;

import MainGame.*;
import MyLibrary.*;
import com.sun.java.accessibility.util.AWTEventMonitor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Worm implements Runnable {

    private int x, y, width, height;
    private Graphics2D g2d;
    private int degree;
    private Thread t = new Thread(this);
    private CatchWormGame p;
    private BufferedImage img;

    public Worm(CatchWormGame p) {
        this.p = p;
        img = new ImageLoader("worm.png").loadImage();
        width = img.getWidth() / 3;
        height = img.getHeight() / 3;
        x = (int) (Math.random() * (mainFrame.widthScreen-width));
        y = (int) (Math.random() * (mainFrame.heightScreen+height));
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                p.repaint();
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void paint(Graphics2D g2d) {
        int ranX = (int) (Math.random() > 0.5 ? 1 : -1);
        int ranY = (int) (Math.random() > 0.5 ? 1 : -1);
        g2d.drawImage(img, x + ranX, y + ranY, width, height, null);
    }

    public void move() {
        x = (int) (Math.random() * mainFrame.widthScreen - width);
        y = (int) (Math.random() * mainFrame.heightScreen - height);
    }

    public boolean catchWorm(int mouseX, int mouseY) {
        Rectangle mouseBounds = new Rectangle(mouseX, mouseY, 1, 1);
        return mouseBounds.intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

}
