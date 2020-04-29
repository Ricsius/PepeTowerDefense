package test.pepetd1.pkg0;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.GameEngine;

public class GameEngineTest {
	
	@Test
	public void testRestart() {
		GameEngine ge = new GameEngine();
		int pepe = ge.getLevel().getPepes().size();
		ge.getLevel().getPepes().remove(0);
		ge.restart();
		Assert.assertTrue("Adatok megvaltoztatasa utan restart visszaallitja az ertekeket",
				naked == ge.getLevel().getPepes().size());
	}
	
	@Test
	public void testClick_delete1() {
		GameEngine ge = new GameEngine();
		int money = ge.getLevel().getMoney();
		ge.setDelete();
		ge.click(0, 0);
		Assert.assertTrue("Semmire sem kattintunk", money == ge.getLevel().getMoney());
	}
	
	@Test
	public void testClick_delete2() {
		GameEngine ge = new GameEngine();
		int money = ge.getLevel().getMoney();
		ge.setDelete();
		ge.click(80, 120);
		Assert.assertTrue("PlacementSpotra kattintunk", money == ge.getLevel().getMoney());
	}
	
	//100 goldot kapunk torony t�rl�s�rt (ha lvl 1-es)
	@Test
	public void testClick_delete3() {
		GameEngine ge = new GameEngine();
		int money = ge.getLevel().getMoney();
		ge.getLevel().createBallistaTower(80, 280);
		ge.setDelete();
		ge.click(133, 402);
		Assert.assertTrue("Toronyra kattintunk", money+100 == ge.getLevel().getMoney());
	}
	
	@Test
	public void testClick_Upgrade1() {
		GameEngine ge = new GameEngine();
		int money = ge.getLevel().getMoney();
		ge.setUpgrade();
		ge.click(0, 0);
		Assert.assertTrue("Semmire sem kattintunk", money == ge.getLevel().getMoney());
	}
	
	@Test
	public void testClick_Upgrade2() {
		GameEngine ge = new GameEngine();
		int money = ge.getLevel().getMoney();
		ge.setUpgrade();
		ge.click(90, 170);
		Assert.assertTrue("PlacementSpotra kattintunk", money == ge.getLevel().getMoney());
	}
	
	//50 goldba ker�l az upgrade
	@Test
	public void testClick_Upgrade3() {
		GameEngine ge = new GameEngine();
		int money = ge.getLevel().getMoney();
		ge.getLevel().createBallistaTower(80, 280);
		ge.setUpgrade();
		ge.click(133, 402);
		Assert.assertTrue("Toronyra kattintunk", money == ge.getLevel().getMoney()+50);
	}
	
	//az�rt csak Ice-ra teszteltem, mert a t�bbi torony is ugyanannyit von le (egyel�re)
	@Test
	public void testClick_Build1() {
		GameEngine ge = new GameEngine();
		int money = ge.getLevel().getMoney();
		ge.setIce();
		ge.click(0, 0);
		Assert.assertTrue("Semmire sem kattintunk", money == ge.getLevel().getMoney());
	}
	
	//130-ba ker�l egy tower
	@Test
	public void testClick_Build2() {
		GameEngine ge = new GameEngine();
		int money = ge.getLevel().getMoney();
		ge.setIce();
		ge.click(90, 170);
		Assert.assertTrue("PlacementSpotra kattintunk", money == ge.getLevel().getMoney()+130);
	}
	
	@Test
	public void testClick_Build3() {
		GameEngine ge = new GameEngine();
		int money = ge.getLevel().getMoney();
		ge.getLevel().createBallistaTower(1080, 1280);
		ge.setIce();
		ge.click(1133, 1402);
		Assert.assertTrue("Toronyra kattintunk", money == ge.getLevel().getMoney());
	}
}
