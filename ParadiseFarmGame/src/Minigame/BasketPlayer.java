package Minigame;

import MyLibrary.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BasketPlayer implements Runnable {

    private GetFruitGame p;
    private MyImage img;

    private final static int MOVEMENT = 50;

    public BasketPlayer(GetFruitGame p) {
        this(0, 0, p);
    }

    public BasketPlayer(int x, int y, GetFruitGame p) {
        this.p = p;
        img = new MyImage("basket.png", x, y);
        img.setSize(img.getWidth()/3, img.getHeight()/3);
    }

    @Override
    public void run() {

    }

    public void paint(Graphics2D g2d) {
        g2d.drawImage(img.loadImage(), img.getX(), img.getY(), img.getWidth(), img.getHeight(), null);
    }

    public void move(int x, int y) {
        img.setX(x - 100);
        p.getView().repaint();
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