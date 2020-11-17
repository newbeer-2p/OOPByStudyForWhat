/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyLibrary;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author newbe
 */
public class MyTimer implements Runnable {

    private int time, sec;
    private int second;
    private boolean reverse;
    private Thread t = new Thread(this);

    public MyTimer(int second) {
        this.second = second;
        t.start();
    }

    public MyTimer(int second, boolean reverse) {
        this.time = second;
        this.second = second;
        this.reverse = reverse;
        t.start();
    }

    @Override
    public void run() {
        while (sec != second) {
            try {
                Thread.sleep(1000);
                if (!reverse) {
                    time++;

                } else {
                    time--;
                }
                sec++;
            } catch (InterruptedException ex) {

            }

        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }
    
    
}
