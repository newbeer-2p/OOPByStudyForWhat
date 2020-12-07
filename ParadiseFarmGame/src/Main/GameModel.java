/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.*;

public class GameModel {

    private String[] history;

    public GameModel() {
        history = new String[2];
        history[0] = "0";
        history[1] = "0";
        loadData();
    }

    public void loadData() {
        File file = new File("history.dat");
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);) {
                history = (String[]) ois.readObject();
            } catch (IOException ex) {

            } catch (ClassNotFoundException ex) {

            }
        }
    }

    public void saveData(Player player) {
        history[0] = player.getDayInFarm()+"";
        history[1] = player.getMoney()+"";
        File file = new File("history.dat");
        try (   FileOutputStream fis = new FileOutputStream(file);
                ObjectOutputStream ois = new ObjectOutputStream(fis);) {
            ois.writeObject(history);
        } catch (IOException ex) {

        }
    }

    public String[] getHistory() {
        return history;
    }

    public void setHistory(String[] history) {
        this.history = history;
    }

}
