/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Hege
 */
public class GUI{
    private MouseListenerHandler frame;
    private GameEngine gameEngine;
    private MenuPanel menu;
    private JButton playButton;
    private JButton quitButton;
    private MainMenu mainMenu;

    public GUI(){
        
        ImageIcon img = new ImageIcon("data/iconversion1.png");

        JButton play = new JButton("START GAME");
        play.setBackground(new Color(0, 0, 0));
        play.setFont(new Font("arial", Font.BOLD, 20));
        play.setForeground(Color.white);
        play.setBounds(150, 285, 200, 60);
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        
        JButton exit = new JButton("EXIT");
        exit.setBackground(new Color(0, 0, 0));
        exit.setFont(new Font("arial", Font.BOLD, 16));
        exit.setBounds(178, 483, 160, 40);
        exit.setForeground(Color.white);
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        
        mainMenu = new MainMenu();
        mainMenu.setLayout(null);
        mainMenu.add(play);
        mainMenu.add(exit);

        frame = new MouseListenerHandler(null);
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainMenu);
        frame.setPreferredSize( new Dimension(510, 620));
        frame.pack();
        frame.setVisible(true);
        
        play.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                gameEngine = new GameEngine();
                frame.remove(mainMenu);
                frame.addGameEngine(gameEngine);
                frame.getContentPane().add(gameEngine);
                frame.getContentPane().add(BorderLayout.EAST,gameEngine.getMenu());
                frame.setPreferredSize( new Dimension(950, 600));
                frame.pack();
                frame.setVisible(true);
            }
        });
        
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(-1);
            }
        });
        
        /*gameEngine = new GameEngine();
        //menu = new MenuPanel(gameEngine);
        //this.gameEngine.attachMenu(menu);
        
        frame = new MouseListenerHandler(this.gameEngine);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setIconImage(img.getImage());
        
        frame.getContentPane().add(gameEngine);
        frame.getContentPane().add(BorderLayout.EAST,gameEngine.getMenu());
        
        frame.setPreferredSize( new Dimension(900, 600));
        frame.pack();
        frame.setVisible(true);*/

    }
    /*public void mouseClicked(MouseEvent e) {  
        System.out.println(e.getX());
    }  
    public void mouseEntered(MouseEvent e) {}  
    public void mouseExited(MouseEvent e) {}  
    public void mousePressed(MouseEvent e) {}  
    public void mouseReleased(MouseEvent e) {}*/ 
    
}
