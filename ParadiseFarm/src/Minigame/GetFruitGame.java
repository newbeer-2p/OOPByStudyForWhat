/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minigame;

import MainGame.*;

/**
 *
 * @author newbe
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GetFruitGame extends JPanel implements Runnable {

    private Graphics2D g2d;
    private Player player;
    private ArrayList<Fruit> fruitDrop = new ArrayList<Fruit>();
    private ArrayList<Fruit> fruitCollect = new ArrayList<Fruit>();
    private Timer tmr;
    private Thread t = new Thread(this);

    private int gameTime = 20;
    private int widthScreen = mainFrame.widthScreen;
    private int heightScreen = mainFrame.heightScreen;
    private int minWidthScreen = 0;
    private int maxWidthScreen = widthScreen - 117;
    private int minHeightScreen = 0;
    private int maxHeightScreen = heightScreen - 117;
//    private int pTmr;

    public GetFruitGame() {
        player = new Player("Basket", widthScreen / 2 - 50, heightScreen - 190, this);
        tmr = new Timer(gameTime, true);
        t.start();
    }

    @Override
    public void run() {
//        while (gameTime != tmr.getSec()) {
//            if (pTmr == tmr.getSec()) {
//                addFruit();
//                pTmr++;
//
//            }
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException ex) {
//
//            }
//        }
        while (true) {
            try {
                if (gameTime == tmr.getSec()) {
                    break;
                }
                addFruit();
                Thread.sleep((int)(Math.random()*2)*1000);
            } catch (InterruptedException ex) {

            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        player.paint(g2d);
        for (int i = 0; i < fruitDrop.size(); i++) {
            fruitDrop.get(i).paint(g2d);
        }
        g2d.setFont(new Font("Courier New", 1, 26));
        g2d.drawString("Score: " + fruitCollect.size(), maxWidthScreen - 50, minHeightScreen + 30);
        g2d.drawString("Time: " + tmr.getTime(), 10, 30);
    }

    public void movePlayer(int x, int y) {
        player.move(x, y);
    }

    public void removeFruit(Fruit fruit) {
        fruitDrop.remove(fruit);
    }

    public Graphics2D getG2d() {
        return g2d;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }

    public void addFruit() {
        fruitDrop.add(new Fruit((int) (Math.random() * maxWidthScreen), (int) (Math.random() * 100 + 20), (int) (Math.random() * 100 + 20), this));
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }

    public int getMinWidth() {
        return minWidthScreen;
    }

    public void setMinWidth(int minWidth) {
        this.minWidthScreen = minWidth;
    }

    public int getMaxWidth() {
        return maxWidthScreen;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidthScreen = maxWidth;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getMinWidthScreen() {
        return minWidthScreen;
    }

    public void setMinWidthScreen(int minWidthScreen) {
        this.minWidthScreen = minWidthScreen;
    }

    public int getMaxWidthScreen() {
        return maxWidthScreen;
    }

    public void setMaxWidthScreen(int maxWidthScreen) {
        this.maxWidthScreen = maxWidthScreen;
    }

    public int getMinHeightScreen() {
        return minHeightScreen;
    }

    public void setMinHeightScreen(int minHeightScreen) {
        this.minHeightScreen = minHeightScreen;
    }

    public int getMaxHeightScreen() {
        return maxHeightScreen;
    }

    public void setMaxHeightScreen(int maxHeightScreen) {
        this.maxHeightScreen = maxHeightScreen;
    }

    public void addFruitCollect(Fruit f) {
        if (!fruitCollect.contains(f)) {
            fruitCollect.add(f);
            fruitDrop.remove(f);
        }

    }

}
