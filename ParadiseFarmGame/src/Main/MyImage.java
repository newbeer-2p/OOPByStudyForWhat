package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

/**
 *
 * @author newbe
 */
public class MyImage implements Serializable{

    private BufferedImage img;
    private int width, height;
    private int x, y;

    public MyImage(String imgSource) {
        this(imgSource, 0, 0);
    }

    public MyImage(String imgSource, int x, int y) {
        setImg(imgSource);
        width = img.getWidth();
        height = img.getHeight();
        this.x = x;
        this.y = y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public BufferedImage loadImage() {
        return img;
    }

    public void setImg(String imgSource) {
        try {
            File f = new File("Image/" + imgSource);
            if (f.exists()) {
                img = ImageIO.read(f);

            } else {
                img = ImageIO.read(new File("Image/none.png"));
            }
        } catch (IOException ex) {
        }
    }

    public boolean isHit(MyImage img) {
        return this.getBounds().intersects(img.getBounds());
    }

   

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
