/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Item.*;
import Minigame.*;
import Page.*;
import java.awt.*;
import java.awt.event.*;

public class GameController implements MouseListener, MouseMotionListener {

    private GameView view;
    private Player player;

    public GameController() {
        player = new Player();
        view = new GameView(player);

        view.addMouseListener(this);
        view.addMouseMotionListener(this);
    }

    public void updatePage() {
        if (view.getPageNow().equals("MenuView")) {
            view.setPage(new MenuView(player, view));
        } else if (view.getPageNow().equals("NewGameView")) {
            view.setPage(new NewGameView(player, view));
        } else if (view.getPageNow().equals("FrontHouseView")) {
            view.setPage(new FrontHouseView(player, view));
        } else if (view.getPageNow().equals("HouseView")) {
            view.setPage(new HouseView(player, view));
        } else if (view.getPageNow().equals("FarmView")) {
            view.setPage(new FarmView(player, view));
        } else if (view.getPageNow().equals("MarketView")) {
            view.setPage(new MarketView(player, view));
        } else if (view.getPageNow().equals("GetFruitGameView")) {
            view.setPage(new GetFruitGameView(player, view));
        } else if (view.getPageNow().equals("CatchWormGameView")) {
            view.setPage(new CatchWormGameView(player, view));
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
        } else if (view.getPageNow().equals("FrontHouseView")) {
            FrontHouseView page = (FrontHouseView) view.getPage();
            if (mouseBounds.intersects(page.getImgGoUp().getBounds())) {
                view.setPageNow("HouseView");
                updatePage();
            } else if (mouseBounds.intersects(page.getImgGoLeft().getBounds())) {
                int randomEvent = (int) (Math.random() * 3);
                if (!player.isPlayEvent()) {
                    player.setPlayEvent(true);
                    if (randomEvent == 0) {
                        view.setPageNow("FarmView");
                    } else if (randomEvent == 1) {
                        view.setPageNow("GetFruitGameView");
                    } else if (randomEvent == 2) {
                        view.setPageNow("CatchWormGameView");
                    }
                }
                else
                {
                    view.setPageNow("FarmView");
                }
                updatePage();
            } else if (mouseBounds.intersects(page.getImgGoRight().getBounds())) {
                view.setPageNow("MarketView");
                updatePage();
            }

        } else if (view.getPageNow().equals("HouseView")) {
            HouseView page = (HouseView) view.getPage();
            if (mouseBounds.intersects(page.getImgGoDown().getBounds())) {
                view.setPageNow("FrontHouseView");
                updatePage();
            } else if (mouseBounds.intersects(page.getImgBed().getBounds())) {
                if (!page.isLampOpen()) {
                    for (int i = 0; i < player.getMyPlot().length; i++) {
                        player.getMyPlot()[i].grow();
                    }

                    player.setDayInFarm(player.getDayInFarm() + 1);
                    page.getImgLamp().setImg("lampOpen.png");
                    player.setPlayEvent(false);
                    page.setLampOpen(true);
                }

                view.repaint();
            } else if (mouseBounds.intersects(page.getImgLamp().getBounds())) {
                if (page.isLampOpen()) {
                    page.getImgLamp().setImg("lampClose.png");
                } else {
                    page.getImgLamp().setImg("lampOpen.png");
                }
                page.setLampOpen(!page.isLampOpen());
                view.repaint();
            }
        } else if (view.getPageNow().equals("FarmView")) {
            FarmView page = (FarmView) view.getPage();
            if (mouseBounds.intersects(page.getImgGoRight().getBounds())) {
                view.setPageNow("FrontHouseView");
                updatePage();
            } else if (!page.isUseWateringCan() && !page.isUseSeedRadish() && !page.isUseSeedCarrot() && !page.isUseSeedTomato() && !page.isUseHand()) {
                if (mouseBounds.intersects(page.getImgWateringCan().getBounds())) {
                    page.setUseWateringCan(true);
                } else if (mouseBounds.intersects(page.getImgHand().getBounds())) {
                    page.setUseHand(true);
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

                page.setUseHand(false);
                page.getImgHand().setLocation(GameView.WIDTH - 180, GameView.HEIGHT - 110);

                page.setUseSeedRadish(false);
                page.getImgSeedRadish().setLocation(GameView.WIDTH - 280, GameView.HEIGHT - 120);

                page.setUseSeedCarrot(false);
                page.getImgSeedCarrot().setLocation(GameView.WIDTH - 380, GameView.HEIGHT - 120);

                page.setUseSeedTomato(false);
                page.getImgSeedTomato().setLocation(GameView.WIDTH - 480, GameView.HEIGHT - 120);
            } else if (page.isUseWateringCan() || page.isUseSeedRadish() || page.isUseSeedCarrot() || page.isUseSeedTomato() || page.isUseHand()) {
                for (int i = 0; i < page.getMyPlot().length; i++) {
                    if (mouseBounds.intersects(page.getMyPlot()[i].getImg().getBounds())) {
                        PlantPlot plot = page.getMyPlot()[i];
                        if (mouseBounds.intersects(page.getImgWateringCan().getBounds())) {
                            if (plot.getSeed() != null) {
                                plot.watering();
                            }
                        } else if (mouseBounds.intersects(page.getImgHand().getBounds())) {
                            if (plot.isCanGet()) {
                                player.addItem(plot.getProduct());
                                if (plot.getProduct().getName().equals("radish")) {
                                    player.setMoney(player.getMoney() + 200);
                                } else if (plot.getProduct().getName().equals("carrot")) {
                                    player.setMoney(player.getMoney() + 300);
                                } else if (plot.getProduct().getName().equals("tomato")) {
                                    player.setMoney(player.getMoney() + 400);
                                }
                                plot.setSeed(null);

                            }
                        } else if (mouseBounds.intersects(page.getImgSeedRadish().getBounds()) && player.getInventorySeed()[0].getNumItem() != 0) {
                            if (plot.addSeed("radish")) {
                                player.getInventorySeed()[0].useSeed();
                            }
                        } else if (mouseBounds.intersects(page.getImgSeedCarrot().getBounds()) && player.getInventorySeed()[1].getNumItem() != 0) {
                            if (plot.addSeed("carrot")) {
                                player.getInventorySeed()[1].useSeed();
                            }
                        } else if (mouseBounds.intersects(page.getImgSeedTomato().getBounds()) && player.getInventorySeed()[2].getNumItem() != 0) {
                            if (plot.addSeed("tomato")) {
                                player.getInventorySeed()[2].useSeed();
                            }
                        }
                    }
                }
                view.repaint();
            }
        } else if (view.getPageNow().equals("MarketView")) {
            MarketView page = (MarketView) view.getPage();
            if (mouseBounds.intersects(page.getImgGoLeft().getBounds())) {
                view.setPageNow("FrontHouseView");
                updatePage();
            } else if (mouseBounds.intersects(page.getImgSeedRadish().getBounds())) {
                player.buyItem(new Seed("radish"));
                view.repaint();
            } else if (mouseBounds.intersects(page.getImgSeedCarrot().getBounds())) {
                player.buyItem(new Seed("carrot"));
                view.repaint();
            } else if (mouseBounds.intersects(page.getImgSeedTomato().getBounds())) {
                player.buyItem(new Seed("tomato"));
                view.repaint();
            }
        } else if (view.getPageNow().equals("GetFruitGameView")) {
            GetFruitGameView page = (GetFruitGameView) view.getPage();
            if (page.isGameOver() && mouseBounds.intersects(page.getImgGoToFarm().getBounds())){
                view.setPageNow("FarmView");
                player.setMoney(player.getMoney()+(5*page.getScore()));
                updatePage();
            }

        } else if (view.getPageNow().equals("CatchWormGameView")) {
            CatchWormGameView page = (CatchWormGameView) view.getPage();
            if (mouseBounds.intersects(page.getWorm().getImg().getBounds())) {
                page.getWorm().move();
                page.setScore(page.getScore() + 1);

            } else if (page.isGameOver() && mouseBounds.intersects(page.getImgGoToFarm().getBounds())){
                view.setPageNow("FarmView");
                player.setMoney(player.getMoney()+(5*page.getScore()));
                updatePage();
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
    public void mouseMoved(MouseEvent me
    ) {
        Rectangle mouseBounds = new Rectangle(me.getX(), me.getY(), 1, 1);
        if (view.getPageNow().equals("MenuView")) {
            MenuView page = (MenuView) view.getPage();
            if (mouseBounds.intersects(page.getImgNew().getBounds())) {
                page.setImgNew(new MyImage("newgame1.png", page.getImgNew().getX(), page.getImgNew().getY()));
            } else {
                page.setImgNew(new MyImage("newgame2.png", page.getImgNew().getX(), page.getImgNew().getY()));
            }
        } else if (view.getPageNow().equals("FarmView")) {
            FarmView page = (FarmView) view.getPage();
            if (page.isUseWateringCan()) {
                page.getImgWateringCan().setLocation(me.getX() - 50, me.getY() - 25);
            } else if (page.isUseHand()) {
                page.getImgHand().setLocation(me.getX() - 25, me.getY() - 20);
            } else if (page.isUseSeedRadish()) {
                page.getImgSeedRadish().setLocation(me.getX() - 25, me.getY() - 20);
            } else if (page.isUseSeedCarrot()) {
                page.getImgSeedCarrot().setLocation(me.getX() - 25, me.getY() - 25);
            } else if (page.isUseSeedTomato()) {
                page.getImgSeedTomato().setLocation(me.getX() - 25, me.getY() - 25);
            }

            view.repaint();
        } else if (view.getPageNow().equals("GetFruitGameView")) {
            GetFruitGameView page = (GetFruitGameView) view.getPage();
            page.movePlayer(me.getX(), 0);
            view.repaint();
        } else if (view.getPageNow().equals("CatchWormGameView")) {
            CatchWormGameView page = (CatchWormGameView) view.getPage();
            page.getImgSpray().setLocation(me.getX()-100, me.getY()-25);
            view.repaint();
        }
    }

    public static void main(String[] args) {
        new GameController();
    }
}
