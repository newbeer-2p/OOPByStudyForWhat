/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minigame;

import MainGame.mainFrame;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author newbe
 */
public class Player extends ItemsGame implements Runnable {

    private String name;
    private GetFruitGame p;

    private final static int MOVEMENT = 50;

    public Player(GetFruitGame p) {
        this("Player", 0, 0, 100, 100, p);
    }

    public Player(int x, int y, GetFruitGame p) {
        this("Player", x, y, 100, 100, p);
    }
    
    public Player(int x, int y, int width, int height, GetFruitGame p) {
        this("Player", x, y, width, height, p);
    }
    
    public Player(String name, int x, int y, GetFruitGame p) {
        this(name, x, y, 100, 100, p);
    }

    public Player(String name, int x, int y, int width, int height, GetFruitGame p) {
        super(x, y, width, height);
        this.name = name;
        this.p = p;
    }

    @Override
    public void run() {

    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.red);
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.black);
        g2d.drawRect(x, y, width, height);
        
    }

    public void move(int horizontal, int vertical) {
        x += MOVEMENT * horizontal;
        x = horizontal-50;
        if (x < p.getMinWidthScreen()) {
            x = p.getMinWidthScreen();
        } else if (x > p.getMaxWidthScreen()) {
            x = p.getMaxWidthScreen();
        }
        p.repaint();
    }

    public int getMovement() {
        return MOVEMENT;
    }
    
    
}
