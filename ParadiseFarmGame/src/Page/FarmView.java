package Page;

import Item.*;
import Main.*;
import MyLibrary.MyImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class FarmView extends Page {

    private Player player;

    private Graphics2D g2d;
    private GameView view;
    private MyImage imgBackground;
    private MyImage imgGoRight;
    private MyImage imgSleep;
    private MyImage imgWateringCan;
    private MyImage imgSeedRadish;
    private MyImage imgSeedCarrot;
    private MyImage imgSeedTomato;
    private MyImage imgCancel;
    
    private boolean useWateringCan;
    private boolean useSeedRadish;
    private boolean useSeedCarrot;
    private boolean useSeedTomato;
    private PlantPlot[] myPlot;

    public FarmView(Player player, GameView view) {
        this.view = view;
        this.player = player;
        
        imgBackground = new MyImage("/background/Farm.png");
        imgBackground.setSize(800, 800);

        imgGoRight = new MyImage("arrowRight.png");
        imgGoRight.setSize(imgGoRight.getWidth() / 4, imgGoRight.getHeight() / 4);
        imgGoRight.setLocation(GameView.WIDTH - imgGoRight.getWidth() - 8, GameView.HEIGHT / 2 - imgGoRight.getHeight() / 2 - 15);

        imgSleep = new MyImage("arrowLeft.png", 0, 0);
        imgSleep.setSize(imgSleep.getWidth() / 4, imgSleep.getHeight() / 4);
//        imgGoRight.setLocation(GameView.WIDTH - imgGoRight.getWidth() - 8, GameView.HEIGHT / 2 - imgGoRight.getHeight() / 2 - 15);

        myPlot = player.getMyPlot();

        imgWateringCan = new MyImage("wateringcan.png", GameView.WIDTH - 100, GameView.HEIGHT - 110);
        imgWateringCan.setSize(imgWateringCan.getWidth() / 8, imgWateringCan.getHeight() / 8);

        imgCancel = new MyImage("cancel.png", 0, GameView.HEIGHT - 120);
        imgCancel.setSize(imgCancel.getWidth() / 8, imgCancel.getHeight() / 8);

        imgSeedRadish = new MyImage("radishSeed.png", GameView.WIDTH - 200, GameView.HEIGHT - 120);
        imgSeedRadish.setSize(imgSeedRadish.getWidth() / 6, imgSeedRadish.getHeight() / 6);
        imgSeedCarrot = new MyImage("carrotSeed.png", GameView.WIDTH - 300, GameView.HEIGHT - 120);
        imgSeedCarrot.setSize(imgSeedCarrot.getWidth() / 6, imgSeedCarrot.getHeight() / 6);
        imgSeedTomato = new MyImage("tomatoSeed.png", GameView.WIDTH - 400, GameView.HEIGHT - 120);
        imgSeedTomato.setSize(imgSeedTomato.getWidth() / 6, imgSeedTomato.getHeight() / 6);

    }

    @Override
    public void paint(Graphics2D g2d) {
        this.g2d = g2d;
        
        g2d.drawImage(imgBackground.loadImage(), 0, 0, null);
        
        if (useWateringCan || useSeedRadish || useSeedCarrot || useSeedTomato) {
            g2d.drawImage(imgCancel.loadImage(), imgCancel.getX(), imgCancel.getY(), imgCancel.getWidth(), imgCancel.getHeight(), null);
        }

        g2d.drawImage(imgGoRight.loadImage(), imgGoRight.getX(), imgGoRight.getY(), imgGoRight.getWidth(), imgGoRight.getHeight(), null);
        g2d.drawImage(imgSleep.loadImage(), imgSleep.getX(), imgSleep.getY(), imgSleep.getWidth(), imgSleep.getHeight(), null);
        for (int i = 0; i < myPlot.length / 4; i++) {
            for (int j = 0; j < myPlot.length / 5; j++) {
                myPlot[(i * 4) + j].getImg().setLocation(100 + (i * 100), 250 + (j * 100));
                g2d.drawImage(myPlot[(i * 4) + j].getImg().loadImage(), myPlot[(i * 4) + j].getImg().getX(), myPlot[(i * 4) + j].getImg().getY(), myPlot[(i * 4) + j].getImg().getWidth(), myPlot[(i * 4) + j].getImg().getHeight(), null);
            }
        }
        paintMenuBar(g2d);
//        for (int i = 0; i < GameView.WIDTH; i += 50) {
//            g2d.drawLine(i, 0, i, GameView.WIDTH);
//            g2d.drawString("(" + i + ")", i, 12);
//        }
//        for (int i = 0; i < GameView.HEIGHT; i += 50) {
//            g2d.drawLine(0, i, GameView.HEIGHT, i);
//            g2d.drawString("(" + i + ")", 0, i + 12);
//        }
    }

    public void paintMenuBar(Graphics2D g2d) {
        g2d.drawImage(imgWateringCan.loadImage(), imgWateringCan.getX(), imgWateringCan.getY(), imgWateringCan.getWidth(), imgWateringCan.getHeight(), null);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Ayutaya", Font.PLAIN, 30));
        g2d.drawImage(imgSeedRadish.loadImage(), imgSeedRadish.getX(), imgSeedRadish.getY(), imgSeedRadish.getWidth(), imgSeedRadish.getHeight(), null);
        g2d.drawString(player.getInventorySeed()[0].getNumItem() + "", imgSeedRadish.getX() + imgSeedRadish.getWidth(), imgSeedRadish.getY() + imgSeedRadish.getHeight());
        g2d.drawImage(imgSeedCarrot.loadImage(), imgSeedCarrot.getX(), imgSeedCarrot.getY(), imgSeedCarrot.getWidth(), imgSeedCarrot.getHeight(), null);
        g2d.drawString(player.getInventorySeed()[1].getNumItem() + "", imgSeedCarrot.getX() + imgSeedCarrot.getWidth(), imgSeedCarrot.getY() + imgSeedCarrot.getHeight());
        g2d.drawImage(imgSeedTomato.loadImage(), imgSeedTomato.getX(), imgSeedTomato.getY(), imgSeedTomato.getWidth(), imgSeedTomato.getHeight(), null);
        g2d.drawString(player.getInventorySeed()[2].getNumItem() + "", imgSeedTomato.getX() + imgSeedTomato.getWidth(), imgSeedTomato.getY() + imgSeedTomato.getHeight());
    }

    public MyImage getImgGoRight() {
        return imgGoRight;
    }

    public void setImgGoRight(MyImage imgGoRight) {
        this.imgGoRight = imgGoRight;
    }

    public MyImage getImgSleep() {
        return imgSleep;
    }

    public void setImgSleep(MyImage imgSleep) {
        this.imgSleep = imgSleep;
    }

    public PlantPlot[] getMyPlot() {
        return myPlot;
    }

    public void setMyPlot(PlantPlot[] myPlot) {
        this.myPlot = myPlot;
    }

    public MyImage getImgWateringCan() {
        return imgWateringCan;
    }

    public void setImgWateringCan(MyImage imgWateringCan) {
        this.imgWateringCan = imgWateringCan;
    }

    public boolean isUseWateringCan() {
        return useWateringCan;
    }

    public void setUseWateringCan(boolean useWateringCan) {
        this.useWateringCan = useWateringCan;
    }

    public MyImage getImgCancel() {
        return imgCancel;
    }

    public void setImgCancel(MyImage imgCancel) {
        this.imgCancel = imgCancel;
    }

    public MyImage getImgSeedRadish() {
        return imgSeedRadish;
    }

    public void setImgSeedRadish(MyImage imgSeedRadish) {
        this.imgSeedRadish = imgSeedRadish;
    }

    public MyImage getImgSeedCarrot() {
        return imgSeedCarrot;
    }

    public void setImgSeedCarrot(MyImage imgSeedCarrot) {
        this.imgSeedCarrot = imgSeedCarrot;
    }

    public MyImage getImgSeedTomato() {
        return imgSeedTomato;
    }

    public void setImgSeedTomato(MyImage imgSeedTomato) {
        this.imgSeedTomato = imgSeedTomato;
    }

    public boolean isUseSeedRadish() {
        return useSeedRadish;
    }

    public void setUseSeedRadish(boolean useSeedRadish) {
        this.useSeedRadish = useSeedRadish;
    }

    public boolean isUseSeedCarrot() {
        return useSeedCarrot;
    }

    public void setUseSeedCarrot(boolean useSeedCarrot) {
        this.useSeedCarrot = useSeedCarrot;
    }

    public boolean isUseSeedTomato() {
        return useSeedTomato;
    }

    public void setUseSeedTomato(boolean useSeedTomato) {
        this.useSeedTomato = useSeedTomato;
    }
    
    

}
