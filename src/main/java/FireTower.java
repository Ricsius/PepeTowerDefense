/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pepetd1.pkg0;

import pepetd1.pkg0.Tower;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Andras
 */
public class FireTower extends Tower{
    public FireTower(int x, int y, Image image, int range, int rechargeTime){
        super(x,y,image,range,rechargeTime,25);
    }
    
    public boolean upgrade(){
        if(this.getCurrentLevel() != 3){
            this.changeValues(0, 1, 1);
            if(this.getCurrentLevel() == 1){
                this.setCurrentLevel(2);
                super.changeImage(new ImageIcon("data/towerFire2.png").getImage());
            }else{
                this.setCurrentLevel(3);
                super.changeImage(new ImageIcon("data/towerFire3.png").getImage());
            }
            return true;
        }
        return false;
    }
    
    @Override
    public TowerBullet shoot(){
        if(targetQueue.isEmpty()){
            return null;
        }else{
            Pepe target = targetQueue.get(0);
            TowerBullet towerBullet = null;
            if(currentRechargeTime != rechargeTime){

            }else{
                Image image = new ImageIcon("data/FireBall.png").getImage();
                Image image2 = new ImageIcon("data/FireBallLeft.png").getImage();
                if(target.getX() < this.x){
                    towerBullet = new TowerBullet(this.x, this.y + height / 4, 50, 40, image2, 30,  target);
                    currentRechargeTime = 0;
                }else{
                    towerBullet = new TowerBullet(this.x + width, this.y + height / 4, 50, 40, image, 30,  target);
                    currentRechargeTime = 0;
                }
                
            }
            return towerBullet; 
        }
        
    }
}
