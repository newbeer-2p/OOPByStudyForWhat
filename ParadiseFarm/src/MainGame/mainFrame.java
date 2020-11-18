/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainGame;

import GetFruitGame.*;
import CatchWormGame.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author newbe
 */
import javax.swing.*;

public class mainFrame extends JFrame implements ActionListener {

    public static int widthScreen = 800;
    public static int heightScreen = 800;
    private JPanel pn;
    private JButton btnGame1, btnGame2;

    public mainFrame() {

        pn = new JPanel();
        btnGame1 = new JButton("Get Fruit Game");
        btnGame2 = new JButton("Catch Worm Game");

        pn.setLayout(new FlowLayout());

        pn.add(btnGame1);
        pn.add(btnGame2);

        btnGame1.addActionListener(this);
        btnGame2.addActionListener(this);

        add(pn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(widthScreen, heightScreen);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JFrame fr = new JFrame();
        if (ae.getSource().equals(btnGame1)) {
            
            fr.add(new GetFruitGame());
            
        } else if (ae.getSource().equals(btnGame2)) {
            fr.add(new CatchWormGame());
        }
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(widthScreen, heightScreen);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

}
