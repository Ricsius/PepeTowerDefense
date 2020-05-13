/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.Image;
import java.io.IOException;

/**
 *
 * @author Hege
 */
public class TankPepe extends Pepe{
    public TankPepe(int x, int y, int width, int height, Image image) throws IOException{
        super(x,y,width,height,image,450,60, "data/tank.png", 158, 100, ElementalType.PHYSICAL, ElementalType.FIRE);
    }
}
