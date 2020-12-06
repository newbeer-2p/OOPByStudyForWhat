package Item;

import Main.MyImage;
import java.io.Serializable;

public class Item implements Serializable {

    protected String name;
    protected MyImage img;
    protected double priceBuy;
    protected double priceSell;
    protected int numItem;

    public Item(String name) {
        this(name, 0);
    }
    
    public Item(String name, int numItem) {
        this.name = name;
        this.numItem = numItem;
        if (name.equals("radishSeed")){this.priceBuy = 100; this.priceSell = priceBuy*(0.75);}
        else if (name.equals("carrotSeed")){this.priceBuy = 200; this.priceSell = priceBuy*(0.75);}
        else if (name.equals("tomatoSeed")){this.priceBuy = 300; this.priceSell = priceBuy*(0.75);}
        else if (name.equals("radish")){this.priceBuy = 0; this.priceSell = 200;}
        else if (name.equals("carrot")){this.priceBuy = 0; this.priceSell = 400;}
        else if (name.equals("tomato")){this.priceBuy = 0; this.priceSell = 600;}
    }

    public void addItem(int number) {
        numItem += number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyImage getImg() {
        return img;
    }

    public void setImg(MyImage img) {
        this.img = img;
    }

    public double getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(double priceBuy) {
        this.priceBuy = priceBuy;
    }

    public double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(double priceSell) {
        this.priceSell = priceSell;
    }

    public int getNumItem() {
        return numItem;
    }

    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

}
