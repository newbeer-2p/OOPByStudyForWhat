package Page;

import Main.*;
import MyLibrary.*;
import java.awt.Graphics2D;

public class FrontHouseView extends Page {
    
    private Player player;

    private Graphics2D g2d;
    private GameView view;
    private MyImage imgGoUp;
    private MyImage imgGoLeft;
    private MyImage imgGoRight;

    public FrontHouseView(Player player, GameView view) {
        this.view = view;
        this.player = player;

        imgGoUp = new MyImage("arrowUp.png");
        imgGoUp.setSize(imgGoUp.getWidth() / 4, imgGoUp.getHeight() / 4);
        imgGoUp.setLocation(GameView.WIDTH/2-imgGoUp.getWidth()/2, 0);
        
        imgGoLeft = new MyImage("arrowLeft.png");
        imgGoLeft.setSize(imgGoLeft.getWidth() / 4, imgGoLeft.getHeight() / 4);
        imgGoLeft.setLocation(0, GameView.HEIGHT/2-imgGoLeft.getHeight()/2-15);
        
        imgGoRight = new MyImage("arrowRight.png");
        imgGoRight.setSize(imgGoRight.getWidth() / 4, imgGoRight.getHeight() / 4);
        imgGoRight.setLocation(GameView.WIDTH-imgGoRight.getWidth()-8, GameView.HEIGHT/2-imgGoRight.getHeight()/2-15);

    }

    @Override
    public void paint(Graphics2D g2d) {
        this.g2d = g2d;

        g2d.drawImage(imgGoUp.loadImage(), imgGoUp.getX(), imgGoUp.getY(), imgGoUp.getWidth(), imgGoUp.getHeight(), null);
        g2d.drawImage(imgGoLeft.loadImage(), imgGoLeft.getX(), imgGoLeft.getY(), imgGoLeft.getWidth(), imgGoLeft.getHeight(), null);
        g2d.drawImage(imgGoRight.loadImage(), imgGoRight.getX(), imgGoRight.getY(), imgGoRight.getWidth(), imgGoRight.getHeight(), null);
    }

    public MyImage getImgGoUp() {
        return imgGoUp;
    }

    public void setImgGoUp(MyImage imgGoUp) {
        this.imgGoUp = imgGoUp;
    }

    public MyImage getImgGoLeft() {
        return imgGoLeft;
    }

    public void setImgGoLeft(MyImage imgGoLeft) {
        this.imgGoLeft = imgGoLeft;
    }

    public MyImage getImgGoRight() {
        return imgGoRight;
    }

    public void setImgGoRight(MyImage imgGoRight) {
        this.imgGoRight = imgGoRight;
    }
    
    
    
}
