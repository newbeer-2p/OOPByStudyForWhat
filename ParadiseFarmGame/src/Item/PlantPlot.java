package Item;

import Main.MyImage;
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
        img = new MyImage("/plantplot/crop.png");
        this.numId = numId;
    }

    public boolean addSeed(String nameSeed) {
        if (seed == null) {
            seed = new Seed(nameSeed);
            img.setImg("/plantplot/" + seed.getNameProduct() + "/crop" + level + ".png");
            return true;
        }
        return false;
    }

    public void watering() {
        watering = true;
        if (seed != null) {
            img.setImg("/plantplot/" + seed.getNameProduct() + "/cropwater" + level + ".png");
        } else {
            img.setImg("/plantplot/cropwater.png");
        }
    }

    public void grow() {
        if (watering && seed != null) {
            days++;
            if (!canGet && days == seed.getDayToGrow()) {
                System.out.println(canGet);
                canGet = true;
                level++;

            } else if (!canGet && days % (seed.getDayToGrow() / seed.getLevelMax()) == 0) {
                img.setImg("/plantplot/" + seed.getNameProduct() + "/crop" + level + ".png");
                level++;
            }
            watering = false;
            img.setImg("/plantplot/" + seed.getNameProduct() + "/crop" + level + ".png");
        }

    }

    public Item getProduct() {
        img.setImg("/plantplot/crop.png");
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
