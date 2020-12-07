package Minigame;

import Main.*;
import java.awt.*;

public class BasketPlayer{

    private MyImage img;

    private final static int MOVEMENT = 50;

    public BasketPlayer() {
        this(0, 0);
    }

    public BasketPlayer(int x, int y) {
        img = new MyImage("basket.png", x, y);
        img.setSize(img.getWidth()/3, img.getHeight()/3);
    }

    public void paint(Graphics2D g2d) {
        g2d.drawImage(img.loadImage(), img.getX(), img.getY(), img.getWidth(), img.getHeight(), null);
    }

    public void move(int x, int y) {
        img.setX(x - 100);
        GameController.view.repaint();
    }

    public int getMovement() {
        return MOVEMENT;
    }

    public MyImage getImg() {
        return img;
    }

    public void setImg(MyImage img) {
        this.img = img;
    }

}
