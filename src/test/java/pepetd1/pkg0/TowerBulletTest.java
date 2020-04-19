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
		
		Assert.assertTrue("X tengelyen negativ iranyba", tb.getX() == 5);
	}
	
	@Test
	public void testFollowTarget2() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(-10,0,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("X tengelyen pozitiv iranyba", tb.getX() == -5);
	}
	
	@Test
	public void testFollowTarget3() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(0,10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y tengelyen negativ iranyba", tb.getY() == 5);
	}
	
	@Test
	public void testFollowTarget4() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(0,-10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y tengelyen negativ iranyba", tb.getY() == -5);
	}
	
	@Test
	public void testFollowTarget5_1() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(10,-10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y pozitiv, X negativ", tb.getY() == -5 && tb.getX() == 5);
	}
	
	@Test
	public void testFollowTarget5_2() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(10,10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y negativ, X negativ", tb.getY() == 5 && tb.getX() == 5);
	}
	
	@Test
	public void testFollowTarget5_3() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(-10,10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y negativ, X pozitiv", tb.getY() == 5 && tb.getX() == -5);
	}
	
	@Test
	public void testFollowTarget5_4() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(-10,-10,2,2,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Y pozitiv, X negativ", tb.getY() == -5 && tb.getX() == -5);
	}
	
	@Test
	public void testFollowTarget6() { //a m�retek mindig lehet�v� teszik az eltal�l�st
		//(itt ha a Towerbullet-nek a sz�less�ge 2 lenne, akkor nem tal�ln� el)
		Pepe target = new Pepe(0,0,5,5,null);
		TowerBullet tb = new TowerBullet(3,0,5,5,null,5,target); 
		
		tb.followTarget();
		
		Assert.assertTrue("Tulmegy rajta, azaz eltalalja", tb.getX() == -2 && tb.meet(target));
	}
	
	@Test
	public void testFollowtarget7() {
		Pepe target = new Pepe(0,0,5,5,null);
		TowerBullet tb = new TowerBullet(0,0,5,5,null,5,target);
		
		tb.followTarget();
		
		Assert.assertTrue("Azonos koordinatak",
				tb.getX() == 0 && tb.getY() == 0 && tb.meet(target));
	}
	
	@Test
	public void testFollowTarget8() { //a m�retek mindig lehet�v� teszik az eltal�l�st
		Pepe target = new Pepe(0,0,5,5,null);
		TowerBullet tb = new TowerBullet(5,0,5,5,null,5,target); 
		
		tb.followTarget();
		
		Assert.assertTrue("Pontosan a target koordinataira megy, azaz eltalalja",
				tb.getX() == 0 && tb.meet(target));
	}
}
