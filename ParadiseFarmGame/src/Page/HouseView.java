package Page;

import Main.*;
import MyLibrary.MyImage;
import java.awt.Graphics2D;

public class HouseView extends Page {
    
    private Player player;

    private Graphics2D g2d;
    private GameView view;
    private MyImage imgGoDown;
    private MyImage imgBghouse;
    private MyImage imgCalendar;
    private MyImage imgBed;
    private MyImage imgLamp;

    public HouseView(Player player, GameView view) {
        this.view = view;
        this.player = player;

        imgGoDown = new MyImage("arrowDown.png");
        imgGoDown.setSize(imgGoDown.getWidth() / 4, imgGoDown.getHeight() / 4);
        imgGoDown.setLocation(GameView.WIDTH / 2 - imgGoDown.getWidth() / 2, GameView.HEIGHT - imgGoDown.getHeight() - 30);
        
        imgBghouse = new MyImage("/background/House.png");
        imgBghouse.setSize(800, 800);
        
        imgCalendar = new MyImage("calendar.png", 375, 200);
        imgCalendar.setSize(imgCalendar.getWidth() / 3, imgCalendar.getHeight() / 3);
        
        imgBed = new MyImage("bed.png", 10,370);
        imgBed.setSize(imgBed.getWidth() / 2, imgBed.getHeight() / 2);
        
        imgLamp = new MyImage("lamp.png", 150 ,0);
        imgLamp.setSize(imgLamp.getWidth() / 3, imgLamp.getHeight() / 3);
    }

    @Override
    public void paint(Graphics2D g2d) {
        this.g2d = g2d;
        g2d.drawImage(imgBghouse.loadImage(), imgBghouse.getX(), imgBghouse.getY(), imgBghouse.getWidth(), imgBghouse.getHeight(), null);
        g2d.drawImage(imgGoDown.loadImage(), imgGoDown.getX(), imgGoDown.getY(), imgGoDown.getWidth(), imgGoDown.getHeight(), null);
        g2d.drawImage(imgCalendar.loadImage(), imgCalendar.getX(), imgCalendar.getY(), imgCalendar.getWidth(), imgCalendar.getHeight(), null);
        g2d.drawImage(imgBed.loadImage(), imgBed.getX(), imgBed.getY(), imgBed.getWidth(), imgBed.getHeight(), null);
        g2d.drawImage(imgLamp.loadImage(), imgLamp.getX(), imgLamp.getY(), imgLamp.getWidth(), imgLamp.getHeight(), null);
        g2d.drawString("DAY", 415, 260);
    }

    public MyImage getImgGoDown() {
        return imgGoDown;
    }

    public void setImgGoDown(MyImage imgGoDown) {
        this.imgGoDown = imgGoDown;
    }
    
    
}
