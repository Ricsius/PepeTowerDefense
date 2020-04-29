/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.Image;
import java.io.IOException;
import java.util.HashSet;

public class Pepe extends Sprite{
    private double vely;
    private double velx;
    private int health;
    private int elementalOffset = 2;
    private int speed;
    
    private HashSet<Debuff> debuffs;
    private HashSet<ElementalType> resistantAgaints;
    private HashSet<ElementalType> vulnerableAgainst;
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
        this.resistantAgaints = new HashSet<>();
        this.vulnerableAgainst = new HashSet<>();
    }
    
    //teszthez kell
    public Pepe(int x, int y, int width, int height, Image image) {
    	super(x,y,width,height,image);
    	health = 10;
    	moneyReward = 0;
        this.vely = 1;
        this.velx = 0;
        this.alive = true;
        animationHandler = null;
        this.resistantAgaints = new HashSet<>();
        this.vulnerableAgainst = new HashSet<>();
    }
    
    public void updatePic(String imgPath, int frameWidth, int frameHeight) throws IOException{
        this.image = animationHandler.getCurrentFrame();
    }
    
    public void nextPic(){
        animationHandler.nextFrame();
        super.changeImage(animationHandler.getCurrentFrame());
    }
    
    public void moveUp(){
        this.y += this.speed;
    }

    public void moveDown(){
        this.y -= this.speed;
    }

    public void moveLeft(){
        this.x -= this.speed;
    }

    public void moveRight(){
        this.x += this.speed;
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
    
    public void takeDamage(int damage, ElementalType type){
        if(resistantAgaints.contains(type)){
            damage /= this.elementalOffset;
        }
        else if(vulnerableAgainst.contains(type)){
            damage *= this.elementalOffset;
        }

    	if(damage >=0) {
            this.health -= damage;
            if(health <= 0){
                this.death();
            }	
    	}
    }

    public void updateDebuffStats(){
        for(Debuff d : this.debuffs){(
            d.update();

            if(d.getCurrentDuration <= 0){
                this.removeDebuff(d);
            }
            else if(d.getCurrentTickTime <= 0){
                this.debuffEffect(d);
                d.resetCurrentTickTime();
            }
        }
    }

    public void applyDebuff(Debuff debuff){
        this.debuffs.add(debuff);
        this.debuffEffect(debuff);
    }

    public void removeDebuff(Debuff debuff){
        this.debuffs.remove(debuff);

        switch(debuff.getType()){
            case ICE:
            this.removeWeakness(ELECTRIC);
            this.speed *= 2;
            break;

            case ELECTRIC:
            this.removeWeakness(PHYSICAL);
            break;
        }
    }

    public void death(){
        this.alive = false;
    }
    
    public int getMoneyReward(){
        return this.moneyReward;
    }
    
    public int getHealth() {
    	return this.health;
    }
    
    //teszthez kell
    public void addResistance(ElementalType elemental) {
    	this.resistantAgaints.add(elemental);
    }
    
    //teszthez kell
    public void addWeakness(ElementalType elemental) {
    	this.vulnerableAgainst.add(elemental);
    }

    private void debuffEffect(Debuff d){
        switch(d.getType()){
            case FIRE:
            this.takeDamage(5,FIRE);
            break;

            case ICE:
            this.addWeakness(ELECTRIC);
            this.speed /= 2;
            break;

            case ELECTRIC:
            this.addWeakness(PHYSICAL);
            break;
        }
    }
}
