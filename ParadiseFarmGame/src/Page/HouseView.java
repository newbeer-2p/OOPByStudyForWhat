package Page;

import Main.*;
import MyLibrary.MyImage;
import java.awt.Graphics2D;

public class HouseView extends Page {
    
    private Player player;

    private Graphics2D g2d;
    private GameView view;
    private MyImage imgGoDown;

    public HouseView(Player player, GameView view) {
        this.view = view;
        this.player = player;

        imgGoDown = new MyImage("arrowDown.png");
        imgGoDown.setSize(imgGoDown.getWidth() / 4, imgGoDown.getHeight() / 4);
        imgGoDown.setLocation(GameView.WIDTH / 2 - imgGoDown.getWidth() / 2, GameView.HEIGHT - imgGoDown.getHeight() - 30);
    }

    @Override
    public void paint(Graphics2D g2d) {
        this.g2d = g2d;

        g2d.drawImage(imgGoDown.loadImage(), imgGoDown.getX(), imgGoDown.getY(), imgGoDown.getWidth(), imgGoDown.getHeight(), null);
    }

    public MyImage getImgGoDown() {
        return imgGoDown;
    }

    public void setImgGoDown(MyImage imgGoDown) {
        this.imgGoDown = imgGoDown;
    }
    
    
}
