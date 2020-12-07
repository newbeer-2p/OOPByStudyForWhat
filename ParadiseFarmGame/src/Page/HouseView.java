package Page;

import Main.*;
import Main.MyImage;
import java.awt.Font;
import java.awt.Graphics2D;

public class HouseView extends Page {

    private boolean lampOpen;

    private MyImage imgGoDown;
    private MyImage imgBghouse;
    private MyImage imgCalendar;
    private MyImage imgBed;
    private MyImage imgLamp;
    private MyImage imgTable;
    private MyImage imgFrame;

    public HouseView() {

        imgGoDown = new MyImage("arrowDown.png");
        imgGoDown.setSize(imgGoDown.getWidth() / 4, imgGoDown.getHeight() / 4);
        imgGoDown.setLocation(GameView.WIDTH / 2 - imgGoDown.getWidth() / 2, GameView.HEIGHT - imgGoDown.getHeight() - 30);

        imgBghouse = new MyImage("/background/House.png");
        imgBghouse.setSize(800, 800);

        imgCalendar = new MyImage("calendar.png", 375, 200);
        imgCalendar.setSize(imgCalendar.getWidth() / 3, imgCalendar.getHeight() / 3);

        imgBed = new MyImage("bed.png", 10, 370);
        imgBed.setSize(imgBed.getWidth() / 2, imgBed.getHeight() / 2);

        imgLamp = new MyImage("lampOpen.png", 150, 0);
        imgLamp.setSize(imgLamp.getWidth() / 3, imgLamp.getHeight() / 3);
        lampOpen = true;

        imgTable = new MyImage("table.png", 650, 300);
        imgTable.setSize(imgTable.getWidth() / 3, imgTable.getHeight() / 3);

        imgFrame = new MyImage("farmframe.png", 100, 185);
        imgFrame.setSize(imgFrame.getWidth() / 4, imgFrame.getHeight() / 4);

    }

    @Override
    public void paint(Graphics2D g2d) {
        g2d.drawImage(imgBghouse.loadImage(), imgBghouse.getX(), imgBghouse.getY(), imgBghouse.getWidth(), imgBghouse.getHeight(), null);
        g2d.drawImage(imgFrame.loadImage(), imgFrame.getX(), imgFrame.getY(), imgFrame.getWidth(), imgFrame.getHeight(), null);
        g2d.drawImage(imgGoDown.loadImage(), imgGoDown.getX(), imgGoDown.getY(), imgGoDown.getWidth(), imgGoDown.getHeight(), null);
        g2d.drawImage(imgCalendar.loadImage(), imgCalendar.getX(), imgCalendar.getY(), imgCalendar.getWidth(), imgCalendar.getHeight(), null);
        g2d.drawImage(imgBed.loadImage(), imgBed.getX(), imgBed.getY(), imgBed.getWidth(), imgBed.getHeight(), null);
        g2d.drawImage(imgLamp.loadImage(), imgLamp.getX(), imgLamp.getY(), imgLamp.getWidth(), imgLamp.getHeight(), null);
        g2d.setFont(new Font("Ayutaya", Font.PLAIN, 28));
        g2d.drawString("DAY", 395, 270);
        g2d.drawString(GameController.player.getDayInFarm() + "", 415, 300);
        g2d.drawImage(imgTable.loadImage(), imgTable.getX(), imgTable.getY(), imgTable.getWidth(), imgTable.getHeight(), null);

    }

    public MyImage getImgGoDown() {
        return imgGoDown;
    }

    public void setImgGoDown(MyImage imgGoDown) {
        this.imgGoDown = imgGoDown;
    }

    public MyImage getImgBghouse() {
        return imgBghouse;
    }

    public void setImgBghouse(MyImage imgBghouse) {
        this.imgBghouse = imgBghouse;
    }

    public MyImage getImgCalendar() {
        return imgCalendar;
    }

    public void setImgCalendar(MyImage imgCalendar) {
        this.imgCalendar = imgCalendar;
    }

    public MyImage getImgBed() {
        return imgBed;
    }

    public void setImgBed(MyImage imgBed) {
        this.imgBed = imgBed;
    }

    public MyImage getImgLamp() {
        return imgLamp;
    }

    public void setImgLamp(MyImage imgLamp) {
        this.imgLamp = imgLamp;
    }

    public boolean isLampOpen() {
        return lampOpen;
    }

    public void setLampOpen(boolean lampOpen) {
        this.lampOpen = lampOpen;
    }

}
