/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Page;

import Minigame.*;
import java.awt.*;
import java.awt.event.*;

public class MainController implements MouseListener, MouseMotionListener {

    private MainView view;

    public MainController() {
        view = new MainView();
        view.addMouseListener(this);
        view.addMouseMotionListener(this);
    }

    public void update() {
        if (view.getPageNow().equals("MenuView")) {
            view.setPage(new MenuView(view));
        } else if (view.getPageNow().equals("GetFruitGame")) {
            view.setPage(new GetFruitGame(view));
        }
        view.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        Rectangle mouseBounds = new Rectangle(me.getX(), me.getY(), 1, 1);
        if (view.getPageNow().equals("MenuView")) {
            MenuView page = (MenuView) view.getPage();
            if (mouseBounds.intersects(page.getImgNew().getBounds())) {
                view.setPageNow("GetFruitGame");
            } else if (mouseBounds.intersects(page.getImgLoad().getBounds())) {

            }
            update();

        } else if (view.getPageNow().equals("GetFruitGame")) {
            GetFruitGame page = (GetFruitGame) view.getPage();
//            if (mouseBounds.intersects(page.getImgApple().getBounds())) {
//                view.setPageNow("MenuView");
//            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        if (view.getPageNow().equals("GetFruitGame")) {
            GetFruitGame page = (GetFruitGame) view.getPage();
            page.movePlayer(me.getX(), 0);

            view.repaint();
        }
    }

    public static void main(String[] args) {
        new MainController();
    }
}
