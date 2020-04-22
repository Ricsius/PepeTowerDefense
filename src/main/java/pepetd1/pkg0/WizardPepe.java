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
    public WizardPepe(int x, int y, int width, int height, Image image, int health, int moneyReward) throws IOException{
        super(x,y,width,height,image,health,moneyReward, "data/wizard.png", 72, 100);
    }
}
