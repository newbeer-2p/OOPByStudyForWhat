package Item;

import MyLibrary.MyImage;
import java.io.Serializable;

public class PlantPlot implements Serializable {

    protected Seed seed;
    protected int numId;
    protected int level;
    protected int days;
    protected MyImage img;
    private boolean watering;
    private boolean canGet;

    public PlantPlot(int numId) {
        img = new MyImage("plantcrop.png");
        this.numId = numId;
    }

    public void addSeed(String nameSeed) {
        if (seed == null) {
            seed = new Seed(nameSeed);
            img.setImg("plantcrop0.png");
        }
    }

    public void watering() {
        watering = true;
        System.out.println(level);
        if (level < seed.getLevelMax()) {
            img.setImg("plantcropwater" + level + ".png");
        } else {
            img.setImg("plantcropwater" + seed.getNameProduct() + ".png");
        }
    }

    public void grow() {
        if (watering && seed != null && !canGet) {
            days++;
            if ((level + 1) == seed.getLevelMax()) {
                img.setImg("plantcrop" + seed.getNameProduct() + ".png");
                level++;
                canGet = true;

            } else if (days % (seed.getDayToGrow() / seed.getLevelMax()) == 0) {
                img.setImg("plantcrop" + level + ".png");
                level++;
            }

            if (days < seed.getDayToGrow()) {
                img.setImg("plantcrop" + level + ".png");
            }
            watering = false;
        } else if (watering && seed == null) {
            img.setImg("plantcrop" + level + ".png");

        }
    }

    public Item getProduct() {
        img.setImg("plantcrop.png");
        return seed.getProduct();
    }

    public boolean isWatering() {
        return watering;
    }

    public void setWatering(boolean watering) {
        this.watering = watering;
    }

    public Seed getSeed() {
        return seed;
    }

    public void setSeed(Seed seed) {
        this.seed = seed;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public MyImage getImg() {
        return img;
    }

    public void setImg(MyImage img) {
        this.img = img;
    }

    public boolean isCanGet() {
        return canGet;
    }

    public void setCanGet(boolean canGet) {
        this.canGet = canGet;
    }
    
    
}
