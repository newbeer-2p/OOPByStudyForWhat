package Page;

import Main.MyImage;
import Main.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class FrontHouseView extends Page {

    private Player player;

    private GameView view;
    private MyImage imgGoUp;
    private MyImage imgGoLeft;
    private MyImage imgGoRight;
    private MyImage imgFence;
    private MyImage imgFenceEnd;
    private MyImage imgbackground;

    private MyImage imgPlayerCard;

    public FrontHouseView(Player player, GameView view) {
        this.view = view;
        this.player = player;

        imgPlayerCard = new MyImage("card.png", 20, 20);
        imgPlayerCard.setSize(imgPlayerCard.getWidth(), imgPlayerCard.getHeight());

        imgGoUp = new MyImage("arrowUp.png");
        imgGoUp.setSize(imgGoUp.getWidth() / 4, imgGoUp.getHeight() / 4);
        imgGoUp.setLocation(GameView.WIDTH / 2 - imgGoUp.getWidth() / 2, 0);

        imgGoLeft = new MyImage("arrowLeft.png");
        imgGoLeft.setSize(imgGoLeft.getWidth() / 4, imgGoLeft.getHeight() / 4);
        imgGoLeft.setLocation(0, GameView.HEIGHT / 2 - imgGoLeft.getHeight() / 2 - 15);

        imgGoRight = new MyImage("arrowRight.png");
        imgGoRight.setSize(imgGoRight.getWidth() / 4, imgGoRight.getHeight() / 4);
        imgGoRight.setLocation(GameView.WIDTH - imgGoRight.getWidth() - 8, GameView.HEIGHT / 2 - imgGoRight.getHeight() / 2 - 15);

        imgFence = new MyImage("fence.png", 0, 611);
        imgFence.setSize(imgFence.getWidth() / 4, imgFence.getHeight() / 4);

        imgFenceEnd = new MyImage("fence1.png", 0, 611);
        imgFenceEnd.setSize(imgFence.getWidth(), imgFence.getHeight());

        imgbackground = new MyImage("/background/FrontHouse.png");
        imgbackground.setSize(800, 800);
    }

    @Override
    public void paint(Graphics2D g2d) {

        g2d.drawImage(imgbackground.loadImage(), imgbackground.getX(), imgbackground.getY(), imgbackground.getWidth(), imgbackground.getHeight(), null);
        g2d.drawImage(imgFence.loadImage(), imgFence.getX(), imgFence.getY(), imgFence.getWidth(), imgFence.getHeight(), null);
        g2d.drawImage(imgFenceEnd.loadImage(), imgFenceEnd.getX() + 160, imgFenceEnd.getY(), imgFenceEnd.getWidth(), imgFenceEnd.getHeight(), null);
        g2d.drawImage(imgFence.loadImage(), imgFence.getX() + 472, imgFence.getY(), imgFence.getWidth(), imgFence.getHeight(), null);
        g2d.drawImage(imgFence.loadImage(), imgFence.getX() + 632, imgFence.getY(), imgFence.getWidth(), imgFence.getHeight(), null);
        g2d.drawImage(imgGoUp.loadImage(), imgGoUp.getX(), imgGoUp.getY(), imgGoUp.getWidth(), imgGoUp.getHeight(), null);
        g2d.drawImage(imgGoLeft.loadImage(), imgGoLeft.getX(), imgGoLeft.getY(), imgGoLeft.getWidth(), imgGoLeft.getHeight(), null);
        g2d.drawImage(imgGoRight.loadImage(), imgGoRight.getX(), imgGoRight.getY(), imgGoRight.getWidth(), imgGoRight.getHeight(), null);

        drawPlayerCard(g2d);
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

    public MyImage getImgGoUp() {
        return imgGoUp;
    }

    public void setImgGoUp(MyImage imgGoUp) {
        this.imgGoUp = imgGoUp;
    }

    public MyImage getImgGoLeft() {
        return imgGoLeft;
    }

    public void setImgGoLeft(MyImage imgGoLeft) {
        this.imgGoLeft = imgGoLeft;
    }

    public MyImage getImgGoRight() {
        return imgGoRight;
    }

    public void setImgGoRight(MyImage imgGoRight) {
        this.imgGoRight = imgGoRight;
    }

}
