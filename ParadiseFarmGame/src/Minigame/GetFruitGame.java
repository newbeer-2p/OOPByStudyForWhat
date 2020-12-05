package Minigame;

import Main.*;
import MyLibrary.*;
import Page.*;
import java.awt.*;
import java.util.ArrayList;

public class GetFruitGame extends Page implements Runnable {
    
    private Player player;

    private Graphics2D g2d;
    private GameView view;
    private BasketPlayer basketPlayer;
    private ArrayList<Fruit> fruitDrop = new ArrayList<Fruit>();
    private ArrayList<Fruit> fruitCollect = new ArrayList<Fruit>();
    private MyTimer tmr;
    private Thread t = new Thread(this);
    private String fruitName[] = {"apple", "carrot", "tomato", "mangosteen", "radish"};
    private boolean stop;

    private int gameTime = 20;

    public GetFruitGame(Player player, GameView view) {
        this.view = view;
        basketPlayer = new BasketPlayer(GameView.WIDTH / 2 - 50, GameView.HEIGHT - 190, this);
        tmr = new MyTimer(gameTime, true);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (gameTime == tmr.getSec()) {
                    stop = true;
                    break;
                }
                addFruit();
                Thread.sleep((int) (Math.random() * 2) * 1000);
            } catch (InterruptedException ex) {

            }
        }
    }

    public void paint(Graphics2D g2d) {
        this.g2d = g2d;
        
        basketPlayer.paint(g2d);
        for (int i = 0; i < fruitDrop.size(); i++) {
            fruitDrop.get(i).paint(g2d);
        }
        g2d.setFont(new Font("Courier New", 1, 26));
        g2d.drawString("Score: " + fruitCollect.size(), GameView.WIDTH - 167, 30);
        g2d.drawString("Time: " + tmr.getTime(), 10, 30);
    }

    public void movePlayer(int x, int y) {
        basketPlayer.move(x, y);
    }

    public void removeFruit(Fruit fruit) {
        fruitDrop.remove(fruit);
    }

    public void addFruit() {
        int randomX = (int) (Math.random() * (GameView.WIDTH - 200));
        int randomFriut = (int) (Math.random() * fruitName.length);
        fruitDrop.add(new Fruit(fruitName[randomFriut] + ".png", randomX, this));
    }

    public void addFruitCollect(Fruit f) {
        if (!fruitCollect.contains(f)) {
            fruitCollect.add(f);
            fruitDrop.remove(f);
        }
    }

    public boolean isStop() {
        return stop;
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

    public BasketPlayer getBasketPlayer() {
        return basketPlayer;
    }

    public void setBasketPlayer(BasketPlayer player) {
        this.basketPlayer = player;
    }

    public GameView getView() {
        return view;
    }

    public void setView(GameView view) {
        this.view = view;
    }
    
    
}
