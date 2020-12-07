package Main;

import Page.*;
import Page.Page;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class GameView extends JPanel {

    public final static int WIDTH = 800;
    public final static int HEIGHT = 800;
    
    private JFrame frame;
    private String pageNow = "MenuView";
    private Page page;

    private MyImage icon;

    public GameView() {
        frame = new JFrame("Paradise Farm");

        frame.add(this);
        page = new MenuView();

        icon = new MyImage("fertilizer.png");

        frame.setIconImage(icon.loadImage());

        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        page.paint(g2d);
    }

    public String getPageNow() {
        return pageNow;
    }

    public void setPageNow(String pageNow) {
        this.pageNow = pageNow;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

}
