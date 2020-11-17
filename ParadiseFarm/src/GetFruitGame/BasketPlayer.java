/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GetFruitGame;

import MainGame.mainFrame;
import MyLibrary.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author newbe
 */
public class BasketPlayer implements Runnable {

    private int x, y;
    private int width;
    private int height;
    private GetFruitGame p;
    BufferedImage img;

    private final static int MOVEMENT = 50;

    public BasketPlayer(GetFruitGame p) {
        this(0, 0, p);
    }

    public BasketPlayer(int x, int y, GetFruitGame p) {
        this.x = x;
        this.y = y;
        this.p = p;
        img = new ImageLoader("basket.png").loadImage();
        width = img.getWidth()/3;
        height = img.getHeight()/3;
    }

    @Override
    public void run() {

    }

    public void paint(Graphics2D g2d) {
        g2d.drawImage(img, x, y, width, height, null);
    }

    public void move(int horizontal, int vertical) {
        x += MOVEMENT * horizontal;
        x = horizontal - 50;
        if (x < p.getMinWidthScreen()) {
            x = p.getMinWidthScreen();
        } else if (x > p.getMaxWidthScreen() - (width/2)) {
            x = p.getMaxWidthScreen() - (width/2);
        }
        p.repaint();
    }

    public int getMovement() {
        return MOVEMENT;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
