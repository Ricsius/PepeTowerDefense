/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

/**
 *
 * @author Hege
 */
public class Sprite {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;
    /**
     * Konstruktor
     * @param x
     * @param y
     * @param width
     * @param height
     * @param image 
     */
    public Sprite(int x, int y, int width, int height, Image image){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
    }
    
    /**
     * Kirajzolja a Spriteokat
     * @param g 
     */
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }
    
    /**
     * Visszaadja X koordinátát
     * @return 
     */
    public int getX() {
        return x;
    }

    /**
     * Beállítja X koordinátát
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Visszaadja Y koordinátát
     * @return 
     */
    public int getY() {
        return y;
    }

    
    /**
     * Beállítja Y koordinátát
     * @param Y 
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Visszaadja a Sprite szélességét
     * @return 
     */
    public int getWidth() {
        return width;
    }

    /**
     * Beáálítja a Sprite szélességét
     * @return 
     */
    public void setWidth(int width) {
        this.width = width;
    }

    
    /**
     * Visszaadja a Sprite magasságát
     * @return 
     */
    public int getHeight() {
        return height;
    }

    /**
     * Beállítja a Sprite magasságát
     * @return 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * Sprite-okhoz létrehoz egy négyzetet, ami hitboxként funkcionál,
     * ha két négyzet érinti egymást akkor jön létre a 'level'-en belüli találkozás
     * @param other
     * @return 
     */
    public boolean meet(Sprite other) {
        Rectangle rect = new Rectangle(x, y, width, height);
        Rectangle otherRect = new Rectangle(other.x, other.y, other.width, other.height);        
        return rect.intersects(otherRect);
    }
    
    public void changeImage(Image image){
        this.image = image;
    }
}
