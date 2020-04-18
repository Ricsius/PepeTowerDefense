/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Hege
 */
public class GUI{
    private MouseListenerHandler frame;
    private GameEngine gameEngine;
    private MenuPanel menu;
    
    public GUI(){
        ImageIcon img = new ImageIcon("data/iconversion1.png");
        gameEngine = new GameEngine();
        //menu = new MenuPanel(gameEngine);
        //this.gameEngine.attachMenu(menu);
        
        frame = new MouseListenerHandler(this.gameEngine);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setIconImage(img.getImage());
        
        frame.getContentPane().add(gameEngine);
        frame.getContentPane().add(BorderLayout.EAST,gameEngine.getMenu());
        
        frame.setPreferredSize( new Dimension(900, 600));
        frame.pack();
        frame.setVisible(true);

    }
    /*public void mouseClicked(MouseEvent e) {  
        System.out.println(e.getX());
    }  
    public void mouseEntered(MouseEvent e) {}  
    public void mouseExited(MouseEvent e) {}  
    public void mousePressed(MouseEvent e) {}  
    public void mouseReleased(MouseEvent e) {}*/ 
    
}
