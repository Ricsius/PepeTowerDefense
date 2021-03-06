/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import pepetd1.pkg0.Tower;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Andras
 */
public class IceTower extends Tower{
    public IceTower(int x, int y, Image image, int range, int rechargeTime){
        super(x,y,image,range,rechargeTime,20);
    }
    
    @Override
    public boolean upgrade(){
        if(this.getCurrentLevel() != 3){
            this.changeValues(0, 1, 1);
            if(this.getCurrentLevel() == 1){
                this.setCurrentLevel(2);
                super.changeImage(new ImageIcon("data/towerIce2.png").getImage());
            }else{
                this.setCurrentLevel(3);
                super.changeImage(new ImageIcon("data/towerIce3.png").getImage());
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
                if(currentRechargeTime > rechargeTime){
                    currentRechargeTime = 0;
                }
            }else{
                Image image = new ImageIcon("data/IceCube.png").getImage();
                if(target.getX() < this.x){
                    towerBullet = new TowerBullet(this.x, this.y, 50, 50, image, 30,  target);
                    currentRechargeTime = 0;
                }else{
                    towerBullet = new TowerBullet(this.x + width, this.y, 50, 50, image, 30,  target);
                    currentRechargeTime = 0;
                }
                
            }
            return towerBullet;
        }
    }
}
