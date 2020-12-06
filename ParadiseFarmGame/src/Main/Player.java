package Main;

import Item.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {

    private String name;
    private double money = 400;
    private int dayInFarm = 1;
    private ArrayList<Item> inventory;
    private Seed[] inventorySeed = {new Seed("radish"), new Seed("carrot"), new Seed("tomato")};
    private PlantPlot[] myPlot;

    public Player() {
        name = "OOP";
        inventory = new ArrayList<Item>();

        myPlot = new PlantPlot[20];
        for (int i = 0; i < myPlot.length; i++) {
            myPlot[i] = new PlantPlot(i);
            myPlot[i].getImg().setSize(100, 100);
        }

    }

    public void addItem(Item item) {
        boolean found = false;
        for (int i = 0; i < inventory.size(); i++) {
            if (item.getName().equals(inventory.get(i).getName())) {
                found = true;
                inventory.get(i).addItem(1);
            }
        }
        if (!found) {
            inventory.add(item);

        }
    }

    public void addSeed(String nameSeed) {
        if (nameSeed.equals("radish")) {
            inventorySeed[0].addItem(1);
        } else if (nameSeed.equals("carrot")) {
            inventorySeed[1].addItem(1);
        } else if (nameSeed.equals("tomato")) {
            inventorySeed[2].addItem(1);
        }
    }

    public void buyItem(Seed item) {
        if (money - item.getPriceSell() >= 0) {
            money -= item.getPriceSell();
            addSeed(item.getNameProduct());
        }
    }

    public String showMoney() {
        if (money >= 1000000) {
            return ((int) money / 1000000) + "M";
        } else if (money >= 1000) {
            return ((int) money / 1000) + "K";
        } else {
            return money + "";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public Seed[] getInventorySeed() {
        return inventorySeed;
    }

    public void setInventorySeed(Seed[] inventorySeed) {
        this.inventorySeed = inventorySeed;
    }

    public PlantPlot[] getMyPlot() {
        return myPlot;
    }

    public void setMyPlot(PlantPlot[] myPlot) {
        this.myPlot = myPlot;
    }
    
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getDayInFarm() {
        return dayInFarm;
    }

    public void setDayInFarm(int dayInFarm) {
        this.dayInFarm = dayInFarm;
    }

}
