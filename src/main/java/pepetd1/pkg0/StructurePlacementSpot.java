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
public class StructurePlacementSpot extends Sprite{
    public StructurePlacementSpot(int x, int y, Image image){
        super(x, y, 80, 40, image);
    }
    
    public boolean inside(int x, int y){
        
        boolean valX = false;
        boolean valY = false;
        
        //System.out.println("-----------------------------");
        
        if(super.getX() <= x && x <= super.getX()+super.getWidth()){
            valX = true;
        }
        
        if(super.getY()+super.getHeight() <= y && y <= super.getY()+super.getHeight()*2){
            valY = true;
        }
        
        return valX && valY;
    }
    
    public StructurePlacementSpot inside(){
        boolean valX = false;
        boolean valY = false;
        
        //System.out.println("-----------------------------");
        
        if(super.getX() <= x && x <= super.getX()+super.getWidth()){
            valX = true;
        }
        
        if(super.getY()+30 <= y && y <= super.getY()+super.getHeight()*2){
            valY = true;
        }
        
        if(valX && valY){
            return this;
        }else{
            return null;
        }
    }
}
