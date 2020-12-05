package Page;

import Main.*;
import MyLibrary.MyImage;
import java.awt.Graphics2D;

public class LoadGameView extends Page{
    
    private Graphics2D g2d;
    private GameView view;
    private MyImage imgBack;
    private MyImage imgNext;
    
    private Player player;

    public LoadGameView(Player player, GameView view) {
        this.view = view;
        this.player = player;
        
        imgBack = new MyImage("arrowLeft.png", 0, GameView.HEIGHT-105);
        imgBack.setSize(imgBack.getWidth()/4, imgBack.getHeight()/4);
        imgNext = new MyImage("arrowRight.png", GameView.WIDTH-93, GameView.HEIGHT-105);
        imgNext.setSize(imgNext.getWidth()/4, imgNext.getHeight()/4);
    }

    @Override
    public void paint(Graphics2D g2d) {
        this.g2d = g2d;
        g2d.drawImage(imgBack.loadImage(), imgBack.getX(), imgBack.getY(), imgBack.getWidth(), imgBack.getHeight(), null);
        g2d.drawImage(imgNext.loadImage(), imgNext.getX(), imgNext.getY(), imgNext.getWidth(), imgNext.getHeight(), null);
    }

    public MyImage getImgBack() {
        return imgBack;
    }

    public void setImgBack(MyImage imgBack) {
        this.imgBack = imgBack;
    }

    public MyImage getImgNext() {
        return imgNext;
    }

    public void setImgNext(MyImage imgNext) {
        this.imgNext = imgNext;
    }
    
    
}
