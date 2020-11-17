/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibrary;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author newbe
 */
public class ImageLoader{
    private BufferedImage img;

    public ImageLoader(String imgSource) {
        try {
            File f = new File("Image/"+imgSource);
            img = ImageIO.read(f);
        } catch (IOException ex) {}
    }

    public BufferedImage loadImage() {
        return img;
    }
    
}
