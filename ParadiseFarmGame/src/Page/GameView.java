/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Page;

import MyLibrary.MyImage;
import java.awt.Graphics2D;

/**
 *
 * @author newbe
 */
public class GameView extends Page{
    
    private Graphics2D g2d;
    private MainView view;
    
    private MyImage imgApple;

    public GameView(MainView view) {
        this.view = view;
        
        imgApple = new MyImage("apple.png");
        imgApple.setSize(imgApple.getWidth()/5, imgApple.getHeight()/5);
    }
    
            
    @Override
    public void paint(Graphics2D g2d) {
        this.g2d = g2d;
        
        g2d.drawImage(imgApple.loadImage(), imgApple.getX(), imgApple.getY(), imgApple.getWidth(), imgApple.getHeight(),null);
    }

    public MyImage getImgApple() {
        return imgApple;
    }

    public void setImgApple(MyImage imgApple) {
        this.imgApple = imgApple;
    }
    
    
}
