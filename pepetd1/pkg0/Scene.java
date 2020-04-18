/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Hege
 */
public class Scene {
    //private HashSet<Entity> entities;
    //private ArrayList<Entity> garbage;
    private int playerMoney;
    private int pepeLimit;
    //private ArrayList<Line> pepePath;
    
    public Scene(int playerMoney, int pepeLimit){
        this.playerMoney = playerMoney;
        this.pepeLimit = pepeLimit;
        //this.entities = new HashSet<Entity>();
        //this.garbage = new ArrayList<Entity>();
    }
    
    public void update(){
    
    }
   
    public int getPlayerMoney(){
        return this.playerMoney;
    }
    
    public void setPlayerMoneyZero(){
        this.playerMoney = 0;
    }
    
    public void addPlayerMoney(int money){
        this.playerMoney += money;
    }
}
