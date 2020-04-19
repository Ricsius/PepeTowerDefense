/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.pepetd1.pkg0;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.Sprite;

/**
 *
 * @author Andras
 */
public class SpriteTest {
    @Test
    public void testMeet1(){
    	Sprite sprite1 = new Sprite(0,0,3,3,null);
    	Sprite sprite2 = new Sprite(2,2,2,2,null);
    	
    	Assert.assertTrue("Egymast fedo spriteok, tenyleg fedik egymast", sprite1.meet(sprite2));
    }
    
    @Test
    public void testMeet2(){
    	Sprite sprite1 = new Sprite(0,0,2,2,null);
    	Sprite sprite2 = new Sprite(2,2,2,2,null);
    	
    	Assert.assertFalse("Egymast erinto spriteok, nem fedik egymast", sprite1.meet(sprite2));
    }
    
    @Test
    public void testMeet3(){
    	Sprite sprite1 = new Sprite(0,0,2,2,null);
    	Sprite sprite2 = new Sprite(0,2,2,2,null);
    	
    	Assert.assertFalse("Egymast erinto spriteok (egysz oldal), nem fedik egymast", sprite1.meet(sprite2));
    }
    
    @Test
    public void testMeet4(){
    	Sprite sprite1 = new Sprite(0,0,2,2,null);
    	Sprite sprite2 = new Sprite(2,0,2,2,null);
    	
    	Assert.assertFalse("Egymast erinto spriteok (masik egysz oldal), nem fedik egymast", sprite1.meet(sprite2));
    }
    
    @Test
    public void testMeet5(){
    	Sprite sprite1 = new Sprite(0,0,1,1,null);
    	Sprite sprite2 = new Sprite(5,4,2,2,null);
    	
    	Assert.assertFalse("Egymast nem fedo spriteok, tenyleg nem fedik egymast", sprite1.meet(sprite2));
    }   
}
