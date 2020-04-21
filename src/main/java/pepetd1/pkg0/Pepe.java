/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.Image;
import java.io.IOException;
import java.util.HashSet;

/**
 *
 * @author Hege
 */
public class Pepe extends Sprite{
    private double vely;
    private double velx;
    private int health;
    private int elementalOffset = 2;
    
    //private HashSet<Debuff> debuffs;
    private HashSet<ElementalType> resistantAgaints;
    private HashSet<ElementalType> vaulnarableAgainst;
    private int moneyReward;
    private int pathIndex;
    protected AnimationHandler animationHandler;
    private boolean alive;
    
    public Pepe(int x, int y, int width, int height, Image image, int health, int moneyReward, String imagePath, int frameWidth, int frameHeight) throws IOException{
        super(x,y,width,height,image);
        this.health = health;
        this.moneyReward = moneyReward;
        this.vely = 1;
        this.velx = 0;
        this.alive = true;
        animationHandler = new AnimationHandler(imagePath, frameWidth, frameHeight);
    }
    
    public Pepe(int x, int y, int width, int height, Image image) {
    	super(x,y,width,height,image);
    	health = 10;
    	moneyReward = 0;
        this.vely = 1;
        this.velx = 0;
        this.alive = true;
        animationHandler = null;
    }
    
    public void updatePic(String imgPath, int frameWidth, int frameHeight) throws IOException{
        this.image = animationHandler.getCurrentFrame();
    }
    
    public void nextPic(){
        animationHandler.nextFrame();
        super.changeImage(animationHandler.getCurrentFrame());
    }
    
    public void move(){
        y += vely;
        if(y == 100){
            vely = 0;
            velx = 1;
            x -= velx;
            if(x == 600){
                velx = 0;
                vely = 1;
                y += vely;
            }
        }
        if(y == 150){
            vely = 0;
            velx = 1;
            x -= velx;
            if(x == 350){
                velx = 0;
                vely = 1;
                y += vely;
            }
        }
        if(y == 200){
            vely = 0;
            velx = 1;
            x -= velx;
            if(x == 100){
                velx = 0;
                vely = 1;
                y += vely;
            }
        }
        if(y == 250){
            vely = 0;
            velx = 1;
            x -= velx;
            if(x == 50){
                velx = 0;
                vely = 1;
                y += vely;
            }
        }
        if(y == 300){
            vely = 0;
            velx = 1;
            x -= velx;
            if(x == 0){
                velx = 0;
                vely = 0;
            }
        }
    }
    
    public boolean isAlive(){
        return this.alive;
    }
    
    public void takeDamage(int damage, ElementalTypeClass type){
        if(resistantAgaints.has(type)){
            damage /= this.elementalOffset;
        }
        else if(vaulnarableAgainst.has(type)){
            damage *= this.elementalOffset;
        }

    	if(damage >=0) {
            this.health -= damage;
            if(health <= 0){
                this.death();
            }	
    	}
    }
    //, ElementalTypeClass Damage){}
    //public void applyDebuff(Debuff debuff){}
    //public void removeDebuff(Debuff debuff){}
    public void death(){
        this.alive = false;
    }
    
    public int getMoneyReward(){
        return this.moneyReward;
    }
    
    public int getHealth() {
    	return this.health;
    }
}
