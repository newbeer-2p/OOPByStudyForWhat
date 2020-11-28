package Page;

import MyLibrary.*;
import java.awt.*;

public class MenuView extends Page{
    
    private Graphics2D g2d;
    private MainView view;
    private MyImage imgNew;
    private MyImage imgLoad;

    public MenuView(MainView view) {
        this.view = view;
        imgNew = new MyImage("newGame.png", 250, 500);
        imgNew.setSize(imgNew.getWidth() / 5, imgNew.getHeight() / 5);
        imgLoad = new MyImage("loadGame.png", 250, 600);
        imgLoad.setSize(imgLoad.getWidth() / 5, imgLoad.getHeight() / 5);
    }
    
    public void paint(Graphics2D g2d){
        this.g2d = g2d;
        
        g2d.drawImage(imgNew.loadImage(), imgNew.getX(), imgNew.getY(), imgNew.getWidth(), imgNew.getHeight(), null);
        g2d.drawImage(imgLoad.loadImage(), imgLoad.getX(), imgLoad.getY(), imgLoad.getWidth(), imgLoad.getHeight(), null);
        imgNew.getBorder(g2d);
        imgLoad.getBorder(g2d);
        view.repaint();
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
