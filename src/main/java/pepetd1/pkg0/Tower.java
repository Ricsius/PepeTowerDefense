package pepetd1.pkg0;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
//import javafx.scene.shape.Circle;
import javax.swing.Timer;
import pepetd1.pkg0.Sprite;

public class Tower extends Sprite{
    //private Pepe target;
    private int range;
    private int dmg;
    private int currentLevel;
    protected int rechargeTime;
    protected int currentRechargeTime;
    private Timer towerTimer;
    public ArrayList<Pepe> targetQueue;

    public Tower(int x, int y,Image image, int range, int rechargeTime, int dmg){
        super(x,y,80,120,image);
        this.range = range;
        this.dmg = dmg;
        this.currentLevel = 1;
        this.rechargeTime = rechargeTime;
        this.currentRechargeTime = 0;
        this.targetQueue = new ArrayList<Pepe>();
        this.towerTimer = new Timer(500, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(currentRechargeTime != rechargeTime){
                    currentRechargeTime += 1;
                }else{
                    //currentRechargeTime = 0;
                }
            }
        });
        towerTimer.start();
    }

    public TowerBullet shoot(){
        return null;
    }

    protected void recharge(){

    }

    public int getRange(){
        return this.range;
    }

    public int getRechargeTime(){
        return this.rechargeTime;
    }
    
    public boolean inside(int x, int y){
        
        boolean valX = false;
        boolean valY = false;
        
        //System.out.println("-----------------------------");
        
        if(super.getX() <= x-8 && x <= super.getX()+super.getWidth()+8){
            valX = true;
        }
        
        if(super.getY()+38 <= y && y <= super.getY()+79*2){
            valY = true;
        }
        
        return valX && valY;
    }
    
    public boolean upgrade(){
        return false;
    }
    
    public void changeValues(int range, int dmg, int rechargeT){
        this.range += range;
        this.dmg += dmg;
        this.rechargeTime -= rechargeT;
    }
    
    public int getCurrentLevel(){
        return this.currentLevel;
    }
    
    public void setCurrentLevel(int lvl){
        this.currentLevel = lvl;
    } 
    
    @Override
    public boolean meet(Sprite other){
        Circle circle = new Circle();
        circle.setCenterX(this.x + 40);
        circle.setCenterY(this.y + 60);
        circle.setRadius(this.range);
        
        //Rectangle rectangle = new Rectangle(other.x, other.y, other.width, other.height);
        return circle.intersects(other.x, other.y, other.width, other.height);
    }
    
    
    public void addTarget(Pepe target){
        targetQueue.add(target);
    }
}