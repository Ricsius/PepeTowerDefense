package test.pepetd1.pkg0;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.Pepe;
import pepetd1.pkg0.TowerBullet;

public class TowerBulletTest {
	
	@Test
	public void testFollowTarget() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(10,0,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("X tengelyen negat�v ir�nyba", tb.getX() == 5);
	}
	
	@Test
	public void testFollowTarget2() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(-10,0,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("X tengelyen pozit�v ir�nyba", tb.getX() == -5);
	}
	
	@Test
	public void testFollowTarget3() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(0,10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y tengelyen negat�v ir�nyba", tb.getY() == 5);
	}
	
	@Test
	public void testFollowTarget4() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(0,-10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y tengelyen negat�v ir�nyba", tb.getY() == -5);
	}
	
	@Test
	public void testFollowTarget5_1() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(10,-10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y pozit�v, X negat�v", tb.getY() == -5 && tb.getX() == 5);
	}
	
	@Test
	public void testFollowTarget5_2() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(10,10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y negat�v, X negat�v", tb.getY() == 5 && tb.getX() == 5);
	}
	
	@Test
	public void testFollowTarget5_3() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(-10,10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y negat�v, X pozit�v", tb.getY() == 5 && tb.getX() == -5);
	}
	
	@Test
	public void testFollowTarget5_4() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(-10,-10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y pozit�v, X negat�v", tb.getY() == -5 && tb.getX() == -5);
	}
	
	@Test
	public void testFollowTarget6() { //a m�retek mindig lehet�v� teszik az eltal�l�st
		//(itt ha a Towerbullet-nek a sz�less�ge 2 lenne, akkor nem tal�ln� el)
		Pepe target = new Pepe(0,0,5,5,null);
		TowerBullet tb = new TowerBullet(3,0,5,5,null,5,target); 
		
		tb.followTarget();
		
		Assert.assertTrue("T�lmegy rajta, azaz eltal�lja", tb.getX() == -2 && tb.meet(target));
	}
	
	@Test
	public void testFollowtarget7() {
		Pepe target = new Pepe(0,0,5,5,null);
		TowerBullet tb = new TowerBullet(0,0,5,5,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Azonos koordin�t�k",
				tb.getX() == 0 && tb.getY() == 0 && tb.meet(target));
	}
	
	@Test
	public void testFollowTarget8() { //a m�retek mindig lehet�v� teszik az eltal�l�st
		Pepe target = new Pepe(0,0,5,5,null);
		TowerBullet tb = new TowerBullet(5,0,5,5,null,5,target); 
		
		tb.followTarget();
		
		Assert.assertTrue("Pontosan a target koordin�t�ira megy, azaz eltal�lja",
				tb.getX() == 0 && tb.meet(target));
	}
}
