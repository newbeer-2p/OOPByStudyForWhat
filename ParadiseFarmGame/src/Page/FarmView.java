package Page;

import Item.*;
import Main.*;
import Main.MyImage;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class FarmView extends Page {

    private Player player;

    private GameView view;
    
    private boolean useWateringCan;
    private boolean useSeedRadish;
    private boolean useSeedCarrot;
    private boolean useSeedTomato;
    private boolean useHand;
    private PlantPlot[] myPlot;
    
    private MyImage imgBackground;
    private MyImage imgGoRight;
    private MyImage imgWateringCan;
    private MyImage imgSeedRadish;
    private MyImage imgSeedCarrot;
    private MyImage imgSeedTomato;
    private MyImage imgCancel;
    private MyImage imgHand;
    private MyImage imgPlayerCard;

    

    public FarmView(Player player, GameView view) {
        this.view = view;
        this.player = player;

        myPlot = player.getMyPlot();

        imgBackground = new MyImage("/background/Farm.png");
        imgBackground.setSize(800, 800);

        imgGoRight = new MyImage("arrowRight.png");
        imgGoRight.setSize(imgGoRight.getWidth() / 4, imgGoRight.getHeight() / 4);
        imgGoRight.setLocation(GameView.WIDTH - imgGoRight.getWidth() - 8, GameView.HEIGHT / 2 - imgGoRight.getHeight() / 2 - 15);

        imgWateringCan = new MyImage("wateringcan.png", GameView.WIDTH - 100, GameView.HEIGHT - 110);
        imgWateringCan.setSize(imgWateringCan.getWidth() / 8, imgWateringCan.getHeight() / 8);

        imgCancel = new MyImage("cancel.png", 10, GameView.HEIGHT - 140);
        imgCancel.setSize(imgCancel.getWidth() / 4, imgCancel.getHeight() / 4);

        imgHand = new MyImage("hand.png", GameView.WIDTH - 180, GameView.HEIGHT - 120);
        imgHand.setSize(imgHand.getWidth() / 10, imgHand.getHeight() / 10);

        imgSeedRadish = new MyImage("radishSeed.png", GameView.WIDTH - 280, GameView.HEIGHT - 120);
        imgSeedRadish.setSize(imgSeedRadish.getWidth() / 6, imgSeedRadish.getHeight() / 6);
        imgSeedCarrot = new MyImage("carrotSeed.png", GameView.WIDTH - 380, GameView.HEIGHT - 120);
        imgSeedCarrot.setSize(imgSeedCarrot.getWidth() / 6, imgSeedCarrot.getHeight() / 6);
        imgSeedTomato = new MyImage("tomatoSeed.png", GameView.WIDTH - 480, GameView.HEIGHT - 120);
        imgSeedTomato.setSize(imgSeedTomato.getWidth() / 6, imgSeedTomato.getHeight() / 6);

        imgPlayerCard = new MyImage("card.png", 20, 20);

    }

    @Override
    public void paint(Graphics2D g2d) {

        g2d.drawImage(imgBackground.loadImage(), 0, 0, null);

        if (useWateringCan || useSeedRadish || useSeedCarrot || useSeedTomato || useHand) {
            g2d.drawImage(imgCancel.loadImage(), imgCancel.getX(), imgCancel.getY(), imgCancel.getWidth(), imgCancel.getHeight(), null);
        }

        g2d.drawImage(imgGoRight.loadImage(), imgGoRight.getX(), imgGoRight.getY(), imgGoRight.getWidth(), imgGoRight.getHeight(), null);
        for (int i = 0; i < myPlot.length / 4; i++) {
            for (int j = 0; j < myPlot.length / 5; j++) {
                myPlot[(i * 4) + j].getImg().setLocation(100 + (i * 100), 250 + (j * 100));
                g2d.drawImage(myPlot[(i * 4) + j].getImg().loadImage(), myPlot[(i * 4) + j].getImg().getX(), myPlot[(i * 4) + j].getImg().getY(), myPlot[(i * 4) + j].getImg().getWidth(), myPlot[(i * 4) + j].getImg().getHeight(), null);
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(5));
                g2d.drawRect(myPlot[(i * 4) + j].getImg().getX(), myPlot[(i * 4) + j].getImg().getY(), myPlot[(i * 4) + j].getImg().getWidth(), myPlot[(i * 4) + j].getImg().getHeight());
            }
        }
        paintMenuBar(g2d);
        drawPlayerCard(g2d);
    }

    public void paintMenuBar(Graphics2D g2d) {
        g2d.drawImage(imgWateringCan.loadImage(), imgWateringCan.getX(), imgWateringCan.getY(), imgWateringCan.getWidth(), imgWateringCan.getHeight(), null);
        g2d.drawImage(imgHand.loadImage(), imgHand.getX(), imgHand.getY(), imgHand.getWidth(), imgHand.getHeight(), null);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Ayutaya", Font.PLAIN, 30));
        g2d.drawImage(imgSeedRadish.loadImage(), imgSeedRadish.getX(), imgSeedRadish.getY(), imgSeedRadish.getWidth(), imgSeedRadish.getHeight(), null);
        g2d.drawString(player.getInventorySeed()[0].getNumItem() + "", imgSeedRadish.getX() + imgSeedRadish.getWidth(), imgSeedRadish.getY() + imgSeedRadish.getHeight());
        g2d.drawImage(imgSeedCarrot.loadImage(), imgSeedCarrot.getX(), imgSeedCarrot.getY(), imgSeedCarrot.getWidth(), imgSeedCarrot.getHeight(), null);
        g2d.drawString(player.getInventorySeed()[1].getNumItem() + "", imgSeedCarrot.getX() + imgSeedCarrot.getWidth(), imgSeedCarrot.getY() + imgSeedCarrot.getHeight());
        g2d.drawImage(imgSeedTomato.loadImage(), imgSeedTomato.getX(), imgSeedTomato.getY(), imgSeedTomato.getWidth(), imgSeedTomato.getHeight(), null);
        g2d.drawString(player.getInventorySeed()[2].getNumItem() + "", imgSeedTomato.getX() + imgSeedTomato.getWidth(), imgSeedTomato.getY() + imgSeedTomato.getHeight());
    }

    public void drawPlayerCard(Graphics2D g2d) {
        g2d.drawImage(imgPlayerCard.loadImage(), imgPlayerCard.getX(), imgPlayerCard.getY(), imgPlayerCard.getWidth(), imgPlayerCard.getHeight(), null);
        g2d.setFont(new Font("Ayutaya", Font.PLAIN, 27));
        g2d.setColor(Color.BLACK);
        g2d.drawString("Name: " + player.getName(), imgPlayerCard.getX() + 125, imgPlayerCard.getY() + 50);
        g2d.drawString("Sex: Female", imgPlayerCard.getX() + 125, imgPlayerCard.getY() + 115);
        g2d.drawString("Day: " + player.getDayInFarm(), imgPlayerCard.getX() + 20, imgPlayerCard.getY() + 175);
        g2d.drawString("Money: " + player.showMoney(), imgPlayerCard.getX() + 125, imgPlayerCard.getY() + 175);
    }

    public MyImage getImgGoRight() {
        return imgGoRight;
    }

    public void setImgGoRight(MyImage imgGoRight) {
        this.imgGoRight = imgGoRight;
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

    public MyImage getImgHand() {
        return imgHand;
    }

    public void setImgHand(MyImage imgHand) {
        this.imgHand = imgHand;
    }

    public boolean isUseHand() {
        return useHand;
    }

    public void setUseHand(boolean useHand) {
        this.useHand = useHand;
    }

}
