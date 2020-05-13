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
public class WizardPepe extends Pepe{
    public WizardPepe(int x, int y, int width, int height, Image image) throws IOException{
        super(x,y,width,height,image,120,50, "data/wizard.png", 72, 100, ElementalType.ICE, ElementalType.ELECTRIC);
    }
}
