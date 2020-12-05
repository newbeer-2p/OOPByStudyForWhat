package Page;

import Main.*;
import MyLibrary.*;
import java.awt.*;

public class MenuView extends Page implements Runnable {
    
    private Player player;
    
    private Graphics2D g2d;
    private GameView view;
    private MyImage imgBackground;
    private MyImage imgNew;
    private MyImage imgLoad;
    private MyImage imgLogo;
    private Thread t;

    public MenuView(Player player, GameView view) {
        this.view = view;
        
        imgBackground = new MyImage("/background/Logo.png");
        imgBackground.setSize(800, 800);
        imgNew = new MyImage("newgame2.png", 200, 475);
        imgNew.setSize(imgNew.getWidth(), imgNew.getHeight());
        imgLoad = new MyImage("loadgame2.png", 200, 600);
        imgLoad.setSize(imgLoad.getWidth(), imgLoad.getHeight());
        imgLogo = new MyImage("ParadiseFarmLogo.png", 130, 100);
        
        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics2D g2d) {
        this.g2d = g2d;

        g2d.drawImage(imgBackground.loadImage(), imgBackground.getX(), imgBackground.getY(), imgBackground.getWidth(), imgBackground.getHeight(), null);
        g2d.drawImage(imgNew.loadImage(), imgNew.getX(), imgNew.getY(), imgNew.getWidth(), imgNew.getHeight(), null);
        g2d.drawImage(imgLoad.loadImage(), imgLoad.getX(), imgLoad.getY(), imgLoad.getWidth(), imgLoad.getHeight(), null);
        g2d.drawImage(imgLogo.loadImage(), imgLogo.getX(), imgLogo.getY(), imgLogo.getWidth(), imgLogo.getHeight(), null);
        view.repaint();
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i < 50; i += 5) {
                    imgLogo.setY(imgLogo.getY() + 1);
                    Thread.sleep(50);
                }
                for (int i = 50; i > 0; i -= 5) {
                    imgLogo.setY(imgLogo.getY() - 1);
                    Thread.sleep(50);
                }
            } catch (Exception ex) {

            }
        }
    }

    public MyImage getImgNew() {
        return imgNew;
    }

    public void setImgNew(MyImage imgNew) {
        this.imgNew = imgNew;
    }

    public MyImage getImgLoad() {
        return imgLoad;
    }

    public void setImgLoad(MyImage imgLoad) {
        this.imgLoad = imgLoad;
    }

}
