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
public class SonicPepe extends Pepe{
    public SonicPepe(int x, int y, int width, int height, Image image) throws IOException{
        super(x,y,width,height,image,130,30, "data/sonicpepe.png", 108, 100, ElementalType.ELECTRIC, ElementalType.ICE);
    }
}
