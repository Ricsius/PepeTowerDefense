/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.Image;

/**
 *
 * @author Hege
 */
public class TowerBullet extends Sprite{
    int VEL = 5;
    
    private int dmg;
    private ElementalType elementalType;
    private Pepe target;
    public TowerBullet(int x, int y, int width, int height, Image image, int dmg, Pepe target){
        super(x, y, width, height, image);
        this.dmg = dmg;
        this.target = target;
        System.out.println("Bullet Spawn");
    }
    
    public Pepe getTarget(){
        return this.target;
    }
    
    public int getDamage(){
        return this.dmg;
    }
    
    public boolean followTarget(){
        if(this.target.getX() > this.x){
            this.x += VEL;
        }
        if(this.target.getY() > this.y){
            this.y += VEL;
        }
        if(this.target.getX() < this.x){
            this.x -= VEL;
        }
        if(this.target.getY() < this.y){
            this.y -= VEL;
        }
        if(this.meet(this.getTarget())){
            this.getTarget().takeDamage(this.getDamage(), this.elementalType);
            System.out.println("take damage");
            return true;
        }
        return false;
    }

}
