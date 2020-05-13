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
public class TeslaTower extends Tower{
    public TeslaTower(int x, int y, Image image){
        super(x,y,image,150,2,15);
    }
    
    public TeslaTower(int x, int y, Image image, int r){
        super(x,y,image,r,2,15);
    }
    
    public boolean upgrade(){
        if(this.getCurrentLevel() != 3){
            this.changeValues(0, 5, 1);
            if(this.getCurrentLevel() == 1){
                this.setCurrentLevel(2);
                super.changeImage(new ImageIcon("data/towerTesla2.png").getImage());
            }else{
                this.setCurrentLevel(3);
                super.changeImage(new ImageIcon("data/towerTesla3.png").getImage());
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
                Image image = new ImageIcon("data/ThunderLeft.png").getImage();
                Image image2 = new ImageIcon("data/Thunder.png").getImage();
                if(target.getX() < this.x){
                    towerBullet = new TowerBullet(this.x, this.y - height / 4, 30, 30, image, super.dmg, target, ElementalType.ELECTRIC);
                    currentRechargeTime = 0;
                }else{
                    towerBullet = new TowerBullet(this.x + width, this.y - height / 4, 30, 30, image2, super.dmg, target, ElementalType.ELECTRIC);
                    currentRechargeTime = 0;
                }
                
            }
            return towerBullet;
        }
    }
}
