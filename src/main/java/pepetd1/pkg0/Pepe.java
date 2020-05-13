/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
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
    ArrayList<Integer> movementY;
    ArrayList<Integer> movementX;
    
    public Pepe(int x, int y, int width, int height, Image image, int health, int moneyReward, String imagePath, int frameWidth, int frameHeight, ElementalType r, ElementalType v) throws IOException{
        super(x,y,width,height,image);
        this.health = health;
        this.moneyReward = moneyReward;
        this.vely = 1;
        this.velx = 0;
        this.alive = true;
        animationHandler = new AnimationHandler(imagePath, frameWidth, frameHeight);
        this.resistantAgaints = new HashSet<>();
        resistantAgaints.add(r);
        this.vulnerableAgainst = new HashSet<>();
        vulnerableAgainst.add(v);
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
    
    public void setMovements(ArrayList<Integer> movementX, ArrayList<Integer> movementY){
        this.movementX = movementX;
        this.movementY = movementY;
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
        //int velxSave = this.velx;
        //int velySave = this.vely;
        //System.out.println(this.movementY.get(0));
        //System.out.println(this.movementX.get(0));
        
        if(this.x == this.movementX.get(this.movementX.size()-1) || this.y == this.movementY.get(this.movementY.size()-1)){
            velx = 1;
            vely = 0;
            this.x -= velx;
        }else{
            this.y += vely;
            for(int i = 0; i < this.movementX.size(); i++){
                if(this.y == this.movementY.get(i)){
                    vely = 0;
                    velx = 1;
                    this.x -= velx;
                    if(this.x == this.movementX.get(i)){
                        velx = 0;
                        vely = 1;
                        this.y += vely;
                    }
                }
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
        for(Debuff d : this.debuffs){
            d.update();

            if(d.getCurrentDuration() <= 0){
                this.removeDebuff(d);
            }
            else if(d.getCurrentTickTime() <= 0){
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
            this.removeWeakness(ElementalType.ELECTRIC);
            this.speed *= 2;
            break;

            case ELECTRIC:
            this.removeWeakness(ElementalType.PHYSICAL);
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
    
    public void addResistance(ElementalType elemental) {
    	this.resistantAgaints.add(elemental);
    }
    
    public void addWeakness(ElementalType elemental) {
    	this.vulnerableAgainst.add(elemental);
    }

    public void removeResistance(ElementalType elemental) {
    	this.resistantAgaints.remove(elemental);
    }
    
    public void removeWeakness(ElementalType elemental) {
    	this.vulnerableAgainst.remove(elemental);
    }

    private void debuffEffect(Debuff d){
        switch(d.getType()){
            case FIRE:
            this.takeDamage(5,ElementalType.FIRE);
            break;

            case ICE:
            this.addWeakness(ElementalType.ELECTRIC);
            this.speed /= 2;
            break;

            case ELECTRIC:
            this.addWeakness(ElementalType.PHYSICAL);
            break;
        }
    }
}
