/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Item.*;
import Minigame.*;
import MyLibrary.*;
import Page.*;
import java.awt.*;
import java.awt.event.*;

public class GameController implements MouseListener, MouseMotionListener {

    private GameView view;
    private GameModel model;

    public GameController() {
        model = new GameModel();
        view = new GameView(model.getPlayer());

        view.addMouseListener(this);
        view.addMouseMotionListener(this);
    }

    public void updatePage() {
        if (view.getPageNow().equals("MenuView")) {
            view.setPage(new MenuView(model.getPlayer(), view));
        } else if (view.getPageNow().equals("NewGameView")) {
            view.setPage(new NewGameView(model.getPlayer(), view));
        } else if (view.getPageNow().equals("LoadGameView")) {
            view.setPage(new LoadGameView(model.getPlayer(), view));
        } else if (view.getPageNow().equals("FrontHouseView")) {
            view.setPage(new FrontHouseView(model.getPlayer(), view));
        } else if (view.getPageNow().equals("HouseView")) {
            view.setPage(new HouseView(model.getPlayer(), view));
        } else if (view.getPageNow().equals("FarmView")) {
            view.setPage(new FarmView(model.getPlayer(), view));
        } else if (view.getPageNow().equals("ShopView")) {
            view.setPage(new ShopView(model.getPlayer(), view));
        } else if (view.getPageNow().equals("GetFruitGame")) {
            view.setPage(new GetFruitGame(model.getPlayer(), view));
        } else if (view.getPageNow().equals("CatchWormGame")) {
            view.setPage(new CatchWormGame(model.getPlayer(), view));
        }
        view.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Rectangle mouseBounds = new Rectangle(me.getX(), me.getY(), 1, 1);
        if (view.getPageNow().equals("MenuView")) {
            MenuView page = (MenuView) view.getPage();
            if (mouseBounds.intersects(page.getImgNew().getBounds())) {
                view.setPageNow("NewGameView");
                updatePage();
            } else if (mouseBounds.intersects(page.getImgLoad().getBounds())) {
                view.setPageNow("LoadGameView");
                updatePage();
            }
        } else if (view.getPageNow().equals("NewGameView")) {
            NewGameView page = (NewGameView) view.getPage();
            if (mouseBounds.intersects(page.getImgBack().getBounds())) {
                view.setPageNow("MenuView");
                updatePage();
            } else if (mouseBounds.intersects(page.getImgNext().getBounds())) {
                view.setPageNow("FrontHouseView");
                updatePage();
            }

        } else if (view.getPageNow().equals("LoadGameView")) {
            LoadGameView page = (LoadGameView) view.getPage();
            if (mouseBounds.intersects(page.getImgBack().getBounds())) {
                view.setPageNow("MenuView");
                updatePage();
            } else if (mouseBounds.intersects(page.getImgNext().getBounds())) {
                view.setPageNow("FrontHouseView");
                updatePage();
            }
        } else if (view.getPageNow().equals("FrontHouseView")) {
            FrontHouseView page = (FrontHouseView) view.getPage();
            if (mouseBounds.intersects(page.getImgGoUp().getBounds())) {
                view.setPageNow("HouseView");
                updatePage();
            } else if (mouseBounds.intersects(page.getImgGoLeft().getBounds())) {
                view.setPageNow("FarmView");
                updatePage();
            } else if (mouseBounds.intersects(page.getImgGoRight().getBounds())) {
                view.setPageNow("ShopView");
                updatePage();
            }

        } else if (view.getPageNow().equals("HouseView")) {
            HouseView page = (HouseView) view.getPage();
            if (mouseBounds.intersects(page.getImgGoDown().getBounds())) {
                view.setPageNow("FrontHouseView");
                updatePage();
            }
        } else if (view.getPageNow().equals("FarmView")) {
            FarmView page = (FarmView) view.getPage();
            if (mouseBounds.intersects(page.getImgGoRight().getBounds())) {
                view.setPageNow("FrontHouseView");
                updatePage();
            } else if (mouseBounds.intersects(page.getImgSleep().getBounds())) {
                for (int i = 0; i < page.getMyPlot().length; i++) {
                    page.getMyPlot()[i].grow();
                }
                view.repaint();
            } else if (!page.isUseWateringCan() && !page.isUseSeedRadish() && !page.isUseSeedCarrot() && !page.isUseSeedTomato()) {
                if (mouseBounds.intersects(page.getImgWateringCan().getBounds())) {
                    page.setUseWateringCan(true);
                } else if (mouseBounds.intersects(page.getImgSeedRadish().getBounds())) {
                    page.setUseSeedRadish(true);
                } else if (mouseBounds.intersects(page.getImgSeedCarrot().getBounds())) {
                    page.setUseSeedCarrot(true);
                } else if (mouseBounds.intersects(page.getImgSeedTomato().getBounds())) {
                    page.setUseSeedTomato(true);
                }
                view.repaint();
            } else if (mouseBounds.intersects(page.getImgCancel().getBounds())) {
                page.setUseWateringCan(false);
                page.getImgWateringCan().setLocation(GameView.WIDTH - 100, GameView.HEIGHT - 110);

                page.setUseSeedRadish(false);
                page.getImgSeedRadish().setLocation(GameView.WIDTH - 200, GameView.HEIGHT - 120);

                page.setUseSeedCarrot(false);
                page.getImgSeedCarrot().setLocation(GameView.WIDTH - 300, GameView.HEIGHT - 120);

                page.setUseSeedTomato(false);
                page.getImgSeedTomato().setLocation(GameView.WIDTH - 400, GameView.HEIGHT - 120);
            } else if (page.isUseWateringCan() || page.isUseSeedRadish() || page.isUseSeedCarrot() || page.isUseSeedTomato()) {
                for (int i = 0; i < page.getMyPlot().length; i++) {
                    if (mouseBounds.intersects(page.getMyPlot()[i].getImg().getBounds())) {
                        PlantPlot plot = page.getMyPlot()[i];
                        if (mouseBounds.intersects(page.getImgWateringCan().getBounds())) {
                            if (plot.getSeed() != null) {
                                plot.watering();
                            }
                        } else if (mouseBounds.intersects(page.getImgSeedRadish().getBounds()) && model.getPlayer().getInventorySeed()[0].getNumItem() != 0) {
                            plot.addSeed("radish");
                            model.getPlayer().getInventorySeed()[0].useSeed();
                        } else if (mouseBounds.intersects(page.getImgSeedCarrot().getBounds()) && model.getPlayer().getInventorySeed()[1].getNumItem() != 0) {
                            plot.addSeed("carrot");
                            model.getPlayer().getInventorySeed()[1].useSeed();
                        } else if (mouseBounds.intersects(page.getImgSeedTomato().getBounds()) && model.getPlayer().getInventorySeed()[2].getNumItem() != 0) {
                            plot.addSeed("tomato");
                            model.getPlayer().getInventorySeed()[2].useSeed();
                        }
                    }
                }
                view.repaint();
            }
        } else if (view.getPageNow().equals("ShopView")) {
            ShopView page = (ShopView) view.getPage();
            if (mouseBounds.intersects(page.getImgGoLeft().getBounds())) {
                view.setPageNow("FrontHouseView");
                updatePage();
            }
        } else if (view.getPageNow().equals("GetFruitGame")) {

        } else if (view.getPageNow().equals("CatchWormGame")) {
            CatchWormGame page = (CatchWormGame) view.getPage();
            if (mouseBounds.intersects(page.getWorm().getImg().getBounds())) {
                page.getWorm().move();
                page.setScore(page.getScore() + 1);

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

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
        Rectangle mouseBounds = new Rectangle(me.getX(), me.getY(), 1, 1);
        if (view.getPageNow().equals("MenuView")) {
            MenuView page = (MenuView) view.getPage();
            if (mouseBounds.intersects(page.getImgNew().getBounds())) {
                page.setImgNew(new MyImage("newgame1.png", page.getImgNew().getX(), page.getImgNew().getY()));
            } else {
                page.setImgNew(new MyImage("newgame2.png", page.getImgNew().getX(), page.getImgNew().getY()));
            }
            if (mouseBounds.intersects(page.getImgLoad().getBounds())) {
                page.setImgLoad(new MyImage("loadgame1.png", page.getImgLoad().getX(), page.getImgLoad().getY()));
            } else {
                page.setImgLoad(new MyImage("loadgame2.png", page.getImgLoad().getX(), page.getImgLoad().getY()));
            }
        } else if (view.getPageNow().equals("FarmView")) {
            FarmView page = (FarmView) view.getPage();
            if (page.isUseWateringCan()) {
                page.getImgWateringCan().setLocation(me.getX() - 50, me.getY() - 25);
            } else if (page.isUseSeedRadish()) {
                page.getImgSeedRadish().setLocation(me.getX() - 25, me.getY() - 20);
            } else if (page.isUseSeedCarrot()) {
                page.getImgSeedCarrot().setLocation(me.getX() - 25, me.getY() - 25);
            } else if (page.isUseSeedTomato()) {
                page.getImgSeedTomato().setLocation(me.getX() - 25, me.getY() - 25);
            }

            view.repaint();
        } else if (view.getPageNow().equals("GetFruitGame")) {
            GetFruitGame page = (GetFruitGame) view.getPage();
            page.movePlayer(me.getX(), 0);

            view.repaint();
        }
    }

    public static void main(String[] args) {
        new GameController();
    }
}
