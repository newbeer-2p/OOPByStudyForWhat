package MyLibrary;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author newbe
 */
public class MyImage {

    private BufferedImage img;
    private int width, height;
    private int x, y;
    private Rectangle bounds;

    public MyImage(String imgSource) {
        this(imgSource, 0, 0);
    }

    public MyImage(String imgSource, int x, int y) {

        try {
            File f = new File("Image/" + imgSource);
            img = ImageIO.read(f);
            width = img.getWidth();
            height = img.getHeight();
            this.x = x;
            this.y = y;
        } catch (IOException ex) {
        }
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

    public boolean isHit(MyImage img) {
        return this.getBounds().intersects(img.getBounds());
    }

    public void getBorder(Graphics2D g2d) {
        g2d.drawRect(x, y, width, height);
    }
    
    public Rectangle getBounds(){
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
