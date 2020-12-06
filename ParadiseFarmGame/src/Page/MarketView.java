package Page;

import Main.*;
import Main.MyImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class MarketView extends Page {

    private Player player;

    private GameView view;
    private MyImage imgGoLeft;
    private MyImage imgbgShop;
    private MyImage imgShop;
    private MyImage imgFarmer;
    private MyImage imgFertilizer;
    private MyImage imgSeedRadish;
    private MyImage imgSeedCarrot;
    private MyImage imgSeedTomato;

    private MyImage imgPlayerCard;

    public MarketView(Player player, GameView view) {
        this.view = view;
        this.player = player;

        imgGoLeft = new MyImage("arrowLeft.png");
        imgGoLeft.setSize(imgGoLeft.getWidth() / 4, imgGoLeft.getHeight() / 4);
        imgGoLeft.setLocation(0, GameView.HEIGHT / 2 - imgGoLeft.getHeight() / 2 - 15);

        imgShop = new MyImage("market.png", 150, 100);

        imgFertilizer = new MyImage("fertilizer.png", 20, 475);
        imgFertilizer.setSize(imgFertilizer.getWidth() / 2, imgFertilizer.getHeight() / 2);
        
        imgSeedRadish = new MyImage("radishseed.png", 230, 525);
        imgSeedRadish.setSize(imgSeedRadish.getWidth() / 4, imgSeedRadish.getHeight() / 4);
        
        imgSeedCarrot = new MyImage("carrotseed.png", 350, 525);
        imgSeedCarrot.setSize(imgSeedCarrot.getWidth() / 4, imgSeedCarrot.getHeight() / 4);
        
        imgSeedTomato = new MyImage("tomatoseed.png", 470, 525);
        imgSeedTomato.setSize(imgSeedTomato.getWidth() / 4, imgSeedTomato.getHeight() / 4);

        imgPlayerCard = new MyImage("card.png", 20, 20);
        
        imgbgShop = new MyImage("/background/market.png");
        imgbgShop.setSize(800, 800);
        
        imgFarmer = new MyImage("Farmer.png", 375, 280);

    }

    @Override
    public void paint(Graphics2D g2d) {
        
        g2d.drawImage(imgbgShop.loadImage(), imgbgShop.getX(), imgbgShop.getY(), imgbgShop.getWidth(), imgbgShop.getHeight(), null);
        g2d.drawImage(imgFarmer.loadImage(), imgFarmer.getX(), imgFarmer.getY(), imgFarmer.getWidth(), imgFarmer.getHeight(), null);
        g2d.drawImage(imgShop.loadImage(), imgShop.getX(), imgShop.getY(), imgShop.getWidth(), imgShop.getHeight(), null);
        g2d.drawImage(imgFertilizer.loadImage(), imgFertilizer.getX(), imgFertilizer.getY(), imgFertilizer.getWidth(), imgFertilizer.getHeight(), null);
        g2d.drawImage(imgFertilizer.loadImage(), imgFertilizer.getX()+550, imgFertilizer.getY(), imgFertilizer.getWidth(), imgFertilizer.getHeight(), null);

        g2d.drawImage(imgGoLeft.loadImage(), imgGoLeft.getX(), imgGoLeft.getY(), imgGoLeft.getWidth(), imgGoLeft.getHeight(), null);
        
        drawItemSell(g2d);
        drawPlayerCard(g2d);
    }
    
    public void drawItemSell(Graphics2D g2d){
        g2d.setFont(new Font("Ayutaya", Font.BOLD, 30));
        g2d.drawImage(imgSeedRadish.loadImage(), imgSeedRadish.getX(), imgSeedRadish.getY(), imgSeedRadish.getWidth(), imgSeedRadish.getHeight(), null);
        g2d.drawString("$ 100", imgSeedRadish.getX()+10, imgSeedRadish.getY()-20);
        g2d.drawImage(imgSeedCarrot.loadImage(), imgSeedCarrot.getX(), imgSeedCarrot.getY(), imgSeedCarrot.getWidth(), imgSeedCarrot.getHeight(), null);
        g2d.drawString("$ 200", imgSeedCarrot.getX()+10, imgSeedCarrot.getY()-20);
        g2d.drawImage(imgSeedTomato.loadImage(), imgSeedTomato.getX(), imgSeedTomato.getY(), imgSeedTomato.getWidth(), imgSeedTomato.getHeight(), null);
        g2d.drawString("$ 300", imgSeedTomato.getX()+10, imgSeedTomato.getY()-20);
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

    public MyImage getImgGoLeft() {
        return imgGoLeft;
    }

    public void setImgGoLeft(MyImage imgGoLeft) {
        this.imgGoLeft = imgGoLeft;
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
    
    
    
}
