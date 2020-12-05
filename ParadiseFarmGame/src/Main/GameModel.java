package Main;

import java.io.*;

public class GameModel {

    private Player player;

    public GameModel() {
        player = new Player();
        this.loadData();
    }

    public void loadData() {
        File file = new File("data.dat");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);) {
                player = (Player) ois.readObject();
                System.out.println("Have!");
            } catch (IOException ex) {
//                System.out.println(ex.printStackTrace());
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("Class");
            }
        } else {
            player = new Player();
        }
    }

    public void saveData() {
        File file = new File("data.dat");
        try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(player);
        } catch (IOException ex) {
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
