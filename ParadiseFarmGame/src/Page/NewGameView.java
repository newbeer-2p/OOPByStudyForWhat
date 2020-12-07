/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Page;

import Main.MyImage;
import Main.*;
import java.awt.Font;
import java.awt.Graphics2D;

public class NewGameView extends Page {

    private MyImage imgBack;
    private MyImage imgNext;
    private MyImage imgHowToPlay;
    private MyImage imgLogo;
    private MyImage imgBackground;

    public NewGameView() {

        imgBack = new MyImage("arrowLeft.png", 0, GameView.HEIGHT - 105);
        imgBack.setSize(imgBack.getWidth() / 4, imgBack.getHeight() / 4);
        imgNext = new MyImage("arrowRight.png", GameView.WIDTH - 93, GameView.HEIGHT - 105);
        imgNext.setSize(imgNext.getWidth() / 4, imgNext.getHeight() / 4);
        imgHowToPlay = new MyImage("HowToPlay.png", 45, 325);
        imgHowToPlay.setSize(imgHowToPlay.getWidth(), imgHowToPlay.getHeight());
        imgLogo = new MyImage("ParadiseFarmLogo.png", 130, 25);
        imgBackground = new MyImage("/background/menu.png");
        imgBackground.setSize(800, 800);
    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.drawImage(imgBackground.loadImage(), imgBackground.getX(), imgBackground.getY(), imgBackground.getWidth(), imgBackground.getHeight(), null);
        g2d.drawImage(imgBack.loadImage(), imgBack.getX(), imgBack.getY(), imgBack.getWidth(), imgBack.getHeight(), null);
        g2d.drawImage(imgNext.loadImage(), imgNext.getX(), imgNext.getY(), imgNext.getWidth(), imgNext.getHeight(), null);
        g2d.drawImage(imgHowToPlay.loadImage(), imgHowToPlay.getX(), imgHowToPlay.getY(), imgHowToPlay.getWidth(), imgHowToPlay.getHeight(), null);
        g2d.drawImage(imgLogo.loadImage(), imgLogo.getX(), imgLogo.getY(), imgLogo.getWidth(), imgLogo.getHeight(), null);
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
