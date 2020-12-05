package Main;

import java.io.*;

public class GameModel {

    private Player player;

    public GameModel() {
        loadData();
    }

    public void loadData() {
        File file = new File("data.dat");
        if (file.exists()) {
            try (   FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);) {
                player = (Player) ois.readObject();
            } catch (IOException ex) {} 
              catch (ClassNotFoundException ex) {}
        }
        else
        {
            player = new Player();
        }
    }

    public void saveData() {
        File file = new File("data.dat");
        try (   FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                oos.writeObject(player);
            } catch (IOException ex) {} 
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
