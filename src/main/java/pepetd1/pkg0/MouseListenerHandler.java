/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.*;  
import java.awt.event.*;  
import javax.swing.JFrame;

public class MouseListenerHandler extends JFrame implements MouseListener{
    private GameEngine engine;
    private LevelSelectMenu lsm;
    
    MouseListenerHandler(GameEngine ge){  
        addMouseListener(this);
        this.engine = ge;
    }
    
    public void addGameEngine(GameEngine gameEngine){
        this.engine = gameEngine;
    }
    
    public void addLevelSelectMenu(LevelSelectMenu lsm){
        this.lsm = lsm;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(engine != null){
            engine.click(e.getX(), e.getY());
        }
        //System.out.println("Mouse");
    }  
    @Override
    public void mouseEntered(MouseEvent e) {}  
    @Override
    public void mouseExited(MouseEvent e) {}  
    @Override
    public void mousePressed(MouseEvent e) {}  
    @Override
    public void mouseReleased(MouseEvent e) {}  
      
}  
