/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetFruitGame;

/**
 *
 * @author newbe
 */
import MainGame.mainFrame;
import MyLibrary.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fruit implements Runnable {

    private int x, y;
    private int width = 100;
    private int height = 100;
    private GetFruitGame p;
    private Thread t;
    private int movement = (int) (Math.random() * 20 + 10);
    private boolean stop;
    private BasketPlayer player;
    private BufferedImage img;

    private boolean canHit;

    public Fruit(String name, GetFruitGame p) {
        this(name, 0, p);
    }

    public Fruit(String name, int x, GetFruitGame p) {
        this.x = x;
        this.y = -200;
        this.p = p;
        img = new ImageLoader(name).loadImage();
        player = p.getPlayer();
        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics2D g2d) {
//        g2d.setColor(Color.gray);
//        g2d.fillRect(x, y, width, height);
//        g2d.setColor(Color.black);
//        g2d.drawRect(x, y, width, height);

        g2d.drawImage(img, x, y, width, height, null);

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
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }
    
    public boolean intersect() {
//        boolean xYes = player.getX() + player.getWidth() / 2 > this.x & player.getX() - player.getWidth() / 2 < this.x;
//        boolean yYes = player.getY() + player.getHeight() / 2 > this.y & player.getY() - player.getHeight() / 2 < this.y;
//        return xYes && yYes;
        return player.getBounds().intersects(this.getBounds());
    }

}
