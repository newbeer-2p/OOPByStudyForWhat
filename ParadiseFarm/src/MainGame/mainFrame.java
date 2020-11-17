/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGame;

import GetFruitGame.GetFruitGame;
import java.awt.event.*;

/**
 *
 * @author newbe
 */
import javax.swing.*;

public class mainFrame extends JFrame implements KeyListener, MouseMotionListener {

    public static int widthScreen = 800;
    public static int heightScreen = 800;

    private GetFruitGame game = new GetFruitGame();

    public mainFrame() {
        add(game);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(widthScreen, heightScreen);
        setLocationRelativeTo(null);
        setVisible(true);

        addKeyListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        if (keyCode == 37) //Left
        {
            game.movePlayer(-1, 0);
        } else if (keyCode == 38) //Up
        {
            game.movePlayer(0, -1);
        } else if (keyCode == 39) //Right
        {
            game.movePlayer(1, 0);
        } else if (keyCode == 40) //Down
        {
            game.movePlayer(0, 1);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        game.movePlayer(me.getX(), 0);

    }

}
