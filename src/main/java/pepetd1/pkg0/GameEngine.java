/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Hege
 */
public class GameEngine extends JPanel{
    private final int FPS = 100;
    
    private Level level;
    private Timer newFrameTimer;
    private Timer bulletTimer;
    private Timer movementTimer;
    private Scene currentLevel;
    private Image background;
    private ArrayList<Scene> levels;
    
    private MenuPanel menu;
    
    private boolean ice;
    private boolean fire;
    private boolean ballista;
    private boolean tesla;
    private boolean delete;
    private boolean upgrade;
    
    private int wave;
    
    private final int TOWER_COST = 130; //egyelre itt van, de bele lesz rakva a toronyba
    
    public GameEngine(){
        super();
        
        background = new ImageIcon("data/grass.png").getImage();
        
        ice = false;
        fire = false;
        ballista = false;
        tesla = false;
        delete = true;
        upgrade = false;
        
        wave = 1;
        
        this.menu = new MenuPanel(this);
        restart();
        newFrameTimer = new Timer(1000 / FPS, new NewFrameListener());
        movementTimer = new Timer(100, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                //clock.setText(Integer.toString(Integer.parseInt(clock.getText())+1));
                /*for(NakedPepe nakedPepe : level.nakedPepes){
                    nakedPepe.nextPic();
                    level.inRange(nakedPepe);
                    if(!nakedPepe.isAlive()){
                        level.addMoney(nakedPepe.getMoneyReward());
                        level.nakedPepes.remove(nakedPepe);
                    }
                }*/

                for(int i = 0; i < level.pepes.size(); i++){
                    level.pepes.get(i).nextPic();
                    level.inRange(level.pepes.get(i));
                    if(!level.pepes.get(i).isAlive()){
                        level.addMoney(level.pepes.get(i).getMoneyReward());
                        level.pepes.remove(level.pepes.get(i));                        
                    }
                }

                menu.setGold(level.getMoney());
                
                level.towerShoot();
                
                if(level.pepes.isEmpty()){
                    	if(wave != 4) {
                    		menu.getWave().setEnabled(true);
                    	}else {
                            if((JOptionPane.showConfirmDialog(null, "Do you want to start a New Game?", "YOU WON",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION){               
                            	restart();
                            }else{
                                System.exit(-1);
                            }
                    	}
                        
                }
            }
        });
        
        newFrameTimer.start();
        movementTimer.start();
    }
    
    //van jobb megolds tuti, csak nem jutott eszembe jobb hirtelen
    public void attachMenu(MenuPanel m){
        menu = m;
        this.menu.setGold(this.level.getMoney());
    }

    public MenuPanel getMenu(){
        return this.menu;
    }
    
    public void newWave() {
        	wave++;
        	System.out.println("WAVE:" + wave);
                try {
                	level.loadPepes("data/levelPepes" + wave + ".txt");
                } catch (IOException ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }		
    }
    
    public void restart() {
        try {
        	wave = 1;
            level = new Level("data/level.txt", "data/levelPepes1.txt");
            //levelPepes = new LevelPepes("data/levelPepes.txt");
        } catch (IOException ex) {
            Logger.getLogger(GameEngine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    } 
    
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.drawImage(background, 0, 0, 800, 600, null);
        level.draw(grphcs);
    }
    
    public void click(int x, int y){
        System.out.println("Clicked: (" + x + "," + y + ")");
        if(delete){
            Tower tow = level.clickedInTower(x,y);
            if(tow != null){
                level.deleteTower(tow);
                level.addMoney(75 + tow.getCurrentLevel() * 25);
                System.out.println(tow.getX());
                System.out.println(tow.getY());
            }     
        }else{
            if(upgrade){
                Tower tow = level.clickedInTower(x,y);
                if(tow != null){
                    if(tow.upgrade()){
                        level.cutMoney(50);   //csak akkor vonja le a pnzt, ha tnyleg tudtunk upgradelni
                    }else{
                        System.out.println("Maxos a torony");
                    }
                }                 
            }else{
                StructurePlacementSpot struct = level.clickedInPlacementSpot(x, y);
                if(struct != null && ballista){
                    level.createBallistaTower(struct.getX(), struct.getY()-80);
                    level.cutMoney(TOWER_COST);
                    System.out.println(struct.getX());
                    System.out.println(struct.getY());
                }
                if(struct != null && tesla){
                    level.createTeslaTower(struct.getX(), struct.getY()-80);
                    level.cutMoney(TOWER_COST);
                    System.out.println(struct.getX());
                    System.out.println(struct.getY());
                }
                if(struct != null && fire){
                    level.createFireTower(struct.getX(), struct.getY()-80);
                    level.cutMoney(TOWER_COST);
                    System.out.println(struct.getX());
                    System.out.println(struct.getY());
                }
                if(struct != null && ice){
                    level.createIceTower(struct.getX(), struct.getY()-80);
                    level.cutMoney(TOWER_COST);
                    System.out.println(struct.getX());
                    System.out.println(struct.getY());                
                }
            }   
        }
        //this.menu.setGold(this.level.getMoney());
        repaint();
    }

    public void setIce(){
        ice = true;
        fire = false;
        ballista = false;
        tesla = false;
        delete = false;
        upgrade = false;
    }
    
    public void setFire(){
        ice = false;
        fire = true;
        ballista = false;
        tesla = false;
        delete = false;
        upgrade = false;
    }
    
    public void setBallista(){
        ice = false;
        fire = false;
        ballista = true;
        tesla = false;
        delete = false;
        upgrade = false;
    }

    public void setTesla(){
        ice = false;
        fire = false;
        ballista = false;
        tesla = true;
        delete = false;
        upgrade = false;
    }
    
    public void setDelete(){
        ice = false;
        fire = false;
        ballista = false;
        tesla = false;
        delete = true;
        upgrade = false;
    }
    
    public void setUpgrade(){
        ice = false;
        fire = false;
        ballista = false;
        tesla = false;
        delete = false;
        upgrade = true;
    }
    
    class NewFrameListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            boolean over = false;

            for(int i = 0; i < level.pepes.size(); i++){
                level.pepes.get(i).move();
                level.pepes.get(i).updateDebuffStats();
                if(level.pepes.get(i).getX() == -25 && level.pepes.get(i).isAlive()){
                    level.pepes.remove(i);
                    over = true;
                }
            }
            
            for(int i = 0; i < level.towerBullets.size(); i++){
                if(level.towerBullets.get(i).followTarget()) level.towerBullets.remove(i);     
            }
            repaint();
            if(over){                 
                if((JOptionPane.showConfirmDialog(null, "Do you want to start a New Game?", "GAME OVER",JOptionPane.YES_NO_OPTION))==JOptionPane.YES_OPTION){
                	restart();
                }else{
                    System.exit(-1);
                }
            }
        }

    }
    
    //teszthez kell
    public Level getLevel() {
    	return this.level;
    }

}

//if(level.towerBullets.get(i).followTarget()) level.towerBullets.remove(i);     
