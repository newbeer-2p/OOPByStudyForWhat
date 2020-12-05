package Page;

import Main.*;
import MyLibrary.MyImage;
import java.awt.Graphics2D;

public class ShopView extends Page {
    
    private Player player;

    private Graphics2D g2d;
    private GameView view;
    private MyImage imgGoLeft;

    public ShopView(Player player, GameView view) {
        this.view = view;
        this.player = player;
        
        imgGoLeft = new MyImage("arrowLeft.png");
        imgGoLeft.setSize(imgGoLeft.getWidth() / 4, imgGoLeft.getHeight() / 4);
        imgGoLeft.setLocation(0, GameView.HEIGHT/2-imgGoLeft.getHeight()/2-15);

    }

    @Override
    public void paint(Graphics2D g2d) {
        this.g2d = g2d;

        g2d.drawImage(imgGoLeft.loadImage(), imgGoLeft.getX(), imgGoLeft.getY(), imgGoLeft.getWidth(), imgGoLeft.getHeight(), null);
    }

    public MyImage getImgGoLeft() {
        return imgGoLeft;
    }

    public void setImgGoLeft(MyImage imgGoLeft) {
        this.imgGoLeft = imgGoLeft;
    }
    
    
}
