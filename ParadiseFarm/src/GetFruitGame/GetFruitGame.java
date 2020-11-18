package GetFruitGame;

import MyLibrary.*;
import MainGame.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GetFruitGame extends JPanel implements Runnable, MouseMotionListener {

    private Graphics2D g2d;
    private BasketPlayer player;
    private ArrayList<Fruit> fruitDrop = new ArrayList<Fruit>();
    private ArrayList<Fruit> fruitCollect = new ArrayList<Fruit>();
    private MyTimer tmr;
    private Thread t = new Thread(this);
    private String fruitName[] = {"apple", "grape"};

    private int gameTime = 20;

    public GetFruitGame() {
        player = new BasketPlayer(mainFrame.widthScreen / 2 - 50, mainFrame.heightScreen - 190, this);
        tmr = new MyTimer(gameTime, true);
        addMouseMotionListener(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (gameTime == tmr.getSec()) {
                    break;
                }
                addFruit();
                Thread.sleep((int) (Math.random() * 2) * 1000);
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
        g2d.drawString("Score: " + fruitCollect.size(), mainFrame.widthScreen - 167, 30);
        g2d.drawString("Time: " + tmr.getTime(), 10, 30);
    }

    public void movePlayer(int x, int y) {
        player.move(x, y);
    }

    public void removeFruit(Fruit fruit) {
        fruitDrop.remove(fruit);
    }

    public void addFruit() {
        int randomX = (int) (Math.random() * (mainFrame.widthScreen - 200) +50);
        int randomFriut = (int) (Math.random() * fruitName.length);
        fruitDrop.add(new Fruit(fruitName[randomFriut]+".png", randomX, this));
    }
    
    public void addFruitCollect(Fruit f) {
        if (!fruitCollect.contains(f)) {
            fruitCollect.add(f);
            fruitDrop.remove(f);
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        movePlayer(me.getX(), 0);

    }
    
    public Graphics2D getG2d() {
        return g2d;
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }


    public BasketPlayer getPlayer() {
        return player;
    }

    public void setPlayer(BasketPlayer player) {
        this.player = player;
    }

}
