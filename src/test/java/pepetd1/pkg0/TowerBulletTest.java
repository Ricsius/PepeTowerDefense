package test.pepetd1.pkg0;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.Pepe;
import pepetd1.pkg0.TowerBullet;

public class TowerBulletTest {
	
	@Test
	public void testFollowTarget() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(10,0,2,2,null,5,target,null);
		
		tb.followTarget();
		
		Assert.assertTrue("X tengelyen negatív irányba", tb.getX() == 5);
	}
	
	@Test
	public void testFollowTarget2() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(-10,0,2,2,null,5,target,null);
		
		tb.followTarget();
		
		Assert.assertTrue("X tengelyen pozitív irányba", tb.getX() == -5);
	}
	
	@Test
	public void testFollowTarget3() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(0,10,2,2,null,5,target,null);
		
		tb.followTarget();
		
		Assert.assertTrue("Y tengelyen negatív irányba", tb.getY() == 5);
	}
	
	@Test
	public void testFollowTarget4() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(0,-10,2,2,null,5,target,null);
		
		tb.followTarget();
		
		Assert.assertTrue("Y tengelyen negatív irányba", tb.getY() == -5);
	}
	
	@Test
	public void testFollowTarget5_1() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(10,-10,2,2,null,5,target,null);
		
		tb.followTarget();
		
		Assert.assertTrue("Y pozitív, X negatív", tb.getY() == -5 && tb.getX() == 5);
	}
	
	@Test
	public void testFollowTarget5_2() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(10,10,2,2,null,5,target,null);
		
		tb.followTarget();
		
		Assert.assertTrue("Y negatív, X negatív", tb.getY() == 5 && tb.getX() == 5);
	}
	
	@Test
	public void testFollowTarget5_3() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(-10,10,2,2,null,5,target,null);
		
		tb.followTarget();
		
		Assert.assertTrue("Y negatív, X pozitív", tb.getY() == 5 && tb.getX() == -5);
	}
	
	@Test
	public void testFollowTarget5_4() {
		Pepe target = new Pepe(0,0,2,2,null);
		TowerBullet tb = new TowerBullet(-10,-10,2,2,null,5,target,null);
		
		tb.followTarget();
		
		Assert.assertTrue("Y pozitív, X negatív", tb.getY() == -5 && tb.getX() == -5);
	}
	
	@Test
	public void testFollowTarget6() { //a méretek mindig lehetővé teszik az eltalálást
		//(itt ha a Towerbullet-nek a szélessége 2 lenne, akkor nem találná el)
		Pepe target = new Pepe(0,0,5,5,null);
		TowerBullet tb = new TowerBullet(3,0,5,5,null,5,target,null); 
		
		tb.followTarget();
		
		Assert.assertTrue("Túlmegy rajta, azaz eltalálja", tb.getX() == -2 && tb.meet(target));
	}
	
	@Test
	public void testFollowtarget7() {
		Pepe target = new Pepe(0,0,5,5,null);
		TowerBullet tb = new TowerBullet(0,0,5,5,null,5,target,null);
		
		tb.followTarget();
		
		Assert.assertTrue("Azonos koordináták",
				tb.getX() == 0 && tb.getY() == 0 && tb.meet(target));
	}
	
	@Test
	public void testFollowTarget8() { //a méretek mindig lehetővé teszik az eltalálást
		Pepe target = new Pepe(0,0,5,5,null);
		TowerBullet tb = new TowerBullet(5,0,5,5,null,5,target,null); 
		
		tb.followTarget();
		
		Assert.assertTrue("Pontosan a target koordinátáira megy, azaz eltalálja",
				tb.getX() == 0 && tb.meet(target));
	}
}
