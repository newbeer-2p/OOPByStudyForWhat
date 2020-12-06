package Minigame;

import Main.*;
import Page.*;
import java.awt.*;
import java.util.ArrayList;

public class GetFruitGameView extends Page implements Runnable {
    
    private Player player;

    private Graphics2D g2d;
    private GameView view;
    private BasketPlayer basketPlayer;
    private ArrayList<Fruit> fruitDrop = new ArrayList<Fruit>();
    private ArrayList<Fruit> fruitCollect = new ArrayList<Fruit>();
    private MyTimer tmr;
    private Thread t = new Thread(this);
    private String fruitName[] = {"apple", "carrot", "tomato", "mangosteen", "radish"};
    private boolean gameOver;
    private MyImage imgGoToFarm;
    private MyImage imgGameOver;
    private int score;
    private MyImage imgBackground;

    private int gameTime = 20;

    public GetFruitGameView(Player player, GameView view) {
        this.player = player;
        this.view = view;
        basketPlayer = new BasketPlayer(GameView.WIDTH / 2 - 50, GameView.HEIGHT - 190, this);
        
        imgGoToFarm = new MyImage("arrowRight.png",  550, 500);
        imgGoToFarm.setSize(imgGoToFarm.getWidth() / 4, imgGoToFarm.getHeight() / 4);
        
        imgGameOver = new MyImage("gameOver.png", 180, 250);
        imgGameOver.setSize(imgGameOver.getWidth() / 4, imgGameOver.getHeight() / 4);
        
        imgBackground = new MyImage("/background/fruitgame.png");
        imgBackground.setSize(800, 800);
        
        tmr = new MyTimer(gameTime, true);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (gameTime == tmr.getSec()) {
                    gameOver = true;
                    view.repaint();
                    break;
                }
                addFruit(); // เพิ่มผลไม้
                Thread.sleep((int) (Math.random() * 2) * 1000); //สุ่มในการหยุดปล่อย
            } catch (InterruptedException ex) {

            }
        }
    }

    public void paint(Graphics2D g2d) {
        this.g2d = g2d;
        
        g2d.drawImage(imgBackground.loadImage(), imgBackground.getX(), imgBackground.getY(), imgBackground.getWidth(), imgBackground.getHeight(), null);
        basketPlayer.paint(g2d);
        for (int i = 0; i < fruitDrop.size(); i++) {
            fruitDrop.get(i).paint(g2d);
        }
        g2d.setFont(new Font("Courier New", 1, 26));
        g2d.drawString("Score: " + score, GameView.WIDTH - 167, 30);
        g2d.drawString("Time: " + tmr.getTime(), 10, 30);
        if (gameOver)
        {
            paintGameOver(g2d);
        }
    }
    
    public void paintGameOver(Graphics2D g2d){
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRoundRect(150, 175, 500, 400, 20, 20);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Ayutaya", Font.BOLD, 30));
        g2d.drawString("Money: "+player.getMoney()+" (+"+(score*5)+")", imgGameOver.getX()+100, imgGameOver.getY()+200);
        g2d.drawImage(imgGameOver.loadImage(), imgGameOver.getX(), imgGameOver.getY(), imgGameOver.getWidth(), imgGameOver.getHeight(), null);
        g2d.drawImage(imgGoToFarm.loadImage(), imgGoToFarm.getX(), imgGoToFarm.getY(), imgGoToFarm.getWidth(), imgGoToFarm.getHeight(), null);
    }

    public void movePlayer(int x, int y) {
        basketPlayer.move(x, y);
    }

    public void removeFruit(Fruit fruit) {
        fruitDrop.remove(fruit);
    }

    public void addFruit() {
        int randomX = (int) (Math.random() * (GameView.WIDTH - 200)); // สุ่ม แกน X
        int randomFriut = (int) (Math.random() * fruitName.length);
        fruitDrop.add(new Fruit(fruitName[randomFriut] + ".png", randomX, this));
    }

    public void addFruitCollect(Fruit f) {
        if (!fruitCollect.contains(f)) {
            score++;
            fruitCollect.add(f);
            fruitDrop.remove(f);
        }
    }

    public boolean isGameOver() {
        return gameOver;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public MyImage getImgGoToFarm() {
        return imgGoToFarm;
    }

    public void setImgGoToFarm(MyImage imgGoToFarm) {
        this.imgGoToFarm = imgGoToFarm;
    }
    
    
}
