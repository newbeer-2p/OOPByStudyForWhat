package Minigame;

import Main.*;
import Page.*;
import java.awt.*;

public class CatchWormGameView extends Page implements Runnable {

    private Player player;

    private Graphics2D g2d;
    private GameView view;
    private Worm worm;
    
    private int score;
    private boolean gameOver;
    private MyTimer tmr;

    private MyImage imgGoToFarm;
    private MyImage imgGameOver;
    private MyImage imgBackground;
    private MyImage imgSpray;

    private int gameTime = 20;
    private Thread t;

    public CatchWormGameView(Player player, GameView view) {
        this.player = player;
        this.view = view;
        
        worm = new Worm(this);

        imgGoToFarm = new MyImage("arrowRight.png", 550, 500);
        imgGoToFarm.setSize(imgGoToFarm.getWidth() / 4, imgGoToFarm.getHeight() / 4);

        imgGameOver = new MyImage("gameOver.png", 180, 250);
        imgGameOver.setSize(imgGameOver.getWidth() / 4, imgGameOver.getHeight() / 4);

        imgBackground = new MyImage("/background/wormgame.jpg");
        imgBackground.setSize(800, 800);

        imgSpray = new MyImage("spray.png");
        imgSpray.setSize(imgSpray.getWidth() / 5, imgSpray.getHeight() / 5);

        tmr = new MyTimer(gameTime, true);
        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics2D g2d) {
        this.g2d = g2d;

        g2d.drawImage(imgBackground.loadImage(), imgBackground.getX(), imgBackground.getY(), imgBackground.getWidth(), imgBackground.getHeight(), null);
        worm.paint(g2d);
        g2d.setFont(new Font("Courier New", 1, 26));
        g2d.drawString("Time: " + tmr.getTime(), 10, 30);
        g2d.drawString("Score: " + score, GameView.WIDTH - 167, 30);
        g2d.drawImage(imgSpray.loadImage(), imgSpray.getX(), imgSpray.getY(), imgSpray.getWidth(), imgSpray.getHeight(), null);
        if (gameOver) {
            paintGameOver(g2d);
        }
    }

    public void paintGameOver(Graphics2D g2d) {
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRoundRect(150, 175, 500, 400, 20, 20);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Ayutaya", Font.BOLD, 30));
        g2d.drawString("Money: " + player.getMoney() + " (+" + (score * 5) + ")", imgGameOver.getX() + 100, imgGameOver.getY() + 200);
        g2d.drawImage(imgGameOver.loadImage(), imgGameOver.getX(), imgGameOver.getY(), imgGameOver.getWidth(), imgGameOver.getHeight(), null);
        g2d.drawImage(imgGoToFarm.loadImage(), imgGoToFarm.getX(), imgGoToFarm.getY(), imgGoToFarm.getWidth(), imgGoToFarm.getHeight(), null);
    }

    @Override
    public void run() {
        while (!gameOver) {
            try {
                if (tmr.getSec() == gameTime) {
                    gameOver = true;
                    break;
                }
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public GameView getView() {
        return view;
    }

    public void setView(GameView view) {
        this.view = view;
    }

    public MyImage getImgGoToFarm() {
        return imgGoToFarm;
    }

    public void setImgGoToFarm(MyImage imgGoToFarm) {
        this.imgGoToFarm = imgGoToFarm;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public MyImage getImgSpray() {
        return imgSpray;
    }

    public void setImgSpray(MyImage imgSpray) {
        this.imgSpray = imgSpray;
    }

}
