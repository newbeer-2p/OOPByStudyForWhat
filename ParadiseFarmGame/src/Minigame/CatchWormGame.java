package Minigame;

import Main.*;
import MyLibrary.*;
import Page.*;
import java.awt.*;

public class CatchWormGame extends Page{
    
    private Player player;
    
    private Graphics2D g2d;
    private GameView view;
    private Worm worm = new Worm(this);
    private MyTimer tmr;
    private int score;

    public CatchWormGame(Player player, GameView view) {
        this.view = view;
        
        tmr = new MyTimer(20, true);
    }
    
    public void paint(Graphics2D g2d) {
        this.g2d = g2d;
        
        worm.paint(g2d);
        g2d.setFont(new Font("Courier New", 1, 26));
        g2d.drawString("Time: "+tmr.getTime(), 10, 30);
        g2d.drawString("Score: "+score, GameView.WIDTH-167, 30);
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
    
    
}