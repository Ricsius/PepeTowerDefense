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
    private LevelSelectMenu levelSelectMenu;
    private MusicPlayer player;

    public GUI(){
    	player = new MusicPlayer();
    	player.playMusic("data/theme.wav");
        
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
        frame.setTitle("PepeTD");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainMenu);
        frame.setPreferredSize( new Dimension(510, 620));
        frame.pack();
        frame.setVisible(true);
        
        play.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                levelSelectMenu = new LevelSelectMenu();
                frame.remove(mainMenu);
                frame.addLevelSelectMenu(levelSelectMenu);
                
                JButton level1 = new JButton("Level 1");
                level1.setBackground(new Color(0, 0, 0));
                level1.setFont(new Font("arial", Font.BOLD, 25));
                level1.setForeground(Color.white);
                level1.setBounds(187, 197, 170, 50);
                level1.setOpaque(false);
                level1.setContentAreaFilled(false);
                level1.setBorderPainted(false);
                
                JButton level2 = new JButton("Level 2");
                level2.setBackground(new Color(0, 0, 0));
                level2.setFont(new Font("arial", Font.BOLD, 25));
                level2.setForeground(Color.white);
                level2.setBounds(600, 197, 170, 50);
                level2.setOpaque(false);
                level2.setContentAreaFilled(false);
                level2.setBorderPainted(false);
                
                JButton level3 = new JButton("Level 3");
                level3.setBackground(new Color(0, 0, 0));
                level3.setFont(new Font("arial", Font.BOLD, 25));
                level3.setForeground(Color.white);
                level3.setBounds(182, 493, 170, 50);
                level3.setOpaque(false);
                level3.setContentAreaFilled(false);
                level3.setBorderPainted(false);
                
                JButton level4 = new JButton("Level 4");
                level4.setBackground(new Color(0, 0, 0));
                level4.setFont(new Font("arial", Font.BOLD, 25));
                level4.setForeground(Color.white);
                level4.setBounds(610, 496, 170, 50);
                level4.setOpaque(false);
                level4.setContentAreaFilled(false);
                level4.setBorderPainted(false);
                
                level1.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gameEngine = new GameEngine(0);
                        frame.remove(levelSelectMenu);
                        frame.addGameEngine(gameEngine);
                        frame.getContentPane().add(gameEngine);
                        frame.getContentPane().add(BorderLayout.EAST,gameEngine.getMenu());
                        frame.setPreferredSize( new Dimension(950, 600));
                        frame.pack();
                        frame.setVisible(true);
                        player.stopMusic();
                    }
                });
                
                level2.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gameEngine = new GameEngine(1);
                        frame.remove(levelSelectMenu);
                        frame.addGameEngine(gameEngine);
                        frame.getContentPane().add(gameEngine);
                        frame.getContentPane().add(BorderLayout.EAST,gameEngine.getMenu());
                        frame.setPreferredSize( new Dimension(950, 600));
                        frame.pack();
                        frame.setVisible(true);
                        player.stopMusic();
                    }
                });
                
                level3.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gameEngine = new GameEngine(2);
                        frame.remove(levelSelectMenu);
                        frame.addGameEngine(gameEngine);
                        frame.getContentPane().add(gameEngine);
                        frame.getContentPane().add(BorderLayout.EAST,gameEngine.getMenu());
                        frame.setPreferredSize( new Dimension(950, 600));
                        frame.pack();
                        frame.setVisible(true);
                        player.stopMusic();
                    }
                });
                
                level4.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gameEngine = new GameEngine(3);
                        frame.remove(levelSelectMenu);
                        frame.addGameEngine(gameEngine);
                        frame.getContentPane().add(gameEngine);
                        frame.getContentPane().add(BorderLayout.EAST,gameEngine.getMenu());
                        frame.setPreferredSize( new Dimension(950, 600));
                        frame.pack();
                        frame.setVisible(true);
                        player.stopMusic();
                    }
                });
                levelSelectMenu.setLayout(null);
                levelSelectMenu.add(level1);
                levelSelectMenu.add(level2);
                levelSelectMenu.add(level3);
                levelSelectMenu.add(level4);
                
                frame.getContentPane().add(levelSelectMenu);
                frame.setPreferredSize( new Dimension(810, 639));
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
    }


    
}
