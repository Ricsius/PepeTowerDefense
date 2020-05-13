package test.pepetd1.pkg0;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.BallistaTower;
import pepetd1.pkg0.FireTower;
import pepetd1.pkg0.IceTower;
import pepetd1.pkg0.Pepe;
import pepetd1.pkg0.Sprite;
import pepetd1.pkg0.TeslaTower;
import pepetd1.pkg0.Tower;

public class TowerTest {
	
	//kirajzolás torzítása miatt az inside() "el van tolva" 80 helyett eszerint 88, 280 helyett
	//318 (+8,+38)
	
	@Test
	public void testInside1() {	
		Tower tower = new Tower(80,280,null,0,0,0);
		
		Assert.assertTrue("Benne lévő pont valóban benne van",tower.inside(133, 402));
	}
	
	@Test
	public void testInside2() {	
		Tower tower = new Tower(80,280,null,0,0,0);
		
		Assert.assertTrue("Határán lévő pont valóban benne van",tower.inside(88, 402));
	}
	
	@Test
	public void testInside2_2() {	
		Tower tower = new Tower(80,280,null,0,0,0);
		
		Assert.assertTrue("Határán lévő pont valóban benne van (másik tengely)",tower.inside(133, 318));
	}
	
	@Test
	public void testInside3() {	
		Tower tower = new Tower(80,280,null,0,0,0);
		
		Assert.assertFalse("Külső pont nincs benne",tower.inside(402, 402));
	}
	
	//a torony lőtávának a középpontja el lett tolva, hogy esztétikusabb legyen
	//(ne a bal felső sarkától nézzük a lőtávot) +40 +60 értékekkel
	//azaz a kör középpontja (120,340)
	
	@Test
	public void testMeet1() {
		Tower tower = new Tower(80,280,null,100,0,0); //100 a range
		Sprite target = new Sprite(120,340,3,3,null);
		
		Assert.assertTrue("Benne van a range-ben",tower.meet(target));
	}
	
	@Test
	public void testMeet2() {
		Tower tower = new Tower(80,280,null,100,0,0); //100 a range
		Sprite target = new Sprite(220,340,3,3,null);
		
		Assert.assertTrue("Range határán van",tower.meet(target));
	}
	
	@Test
	public void testMeet2_2() {
		Tower tower = new Tower(80,280,null,100,0,0); //100 a range
		Sprite target = new Sprite(120,440,3,3,null);
		
		Assert.assertTrue("Range határán van (másik tengely)",tower.meet(target));
	}
	
	@Test
	public void testMeet3() {
		Tower tower = new Tower(80,280,null,100,0,0); //100 a range
		Sprite target = new Sprite(2200,3400,3,3,null);
		
		Assert.assertFalse("Range-en kívül van",tower.meet(target));
	}
	
	//shoot, egyelőre nincsenek elementálok, szóval csak azt nézzük, hogy létrejön-e a bullet
	
	@Test
	public void testShootBallistaNULL() {
		BallistaTower bt = new BallistaTower(0,0,null);
		
		bt.setRCT();
		Assert.assertNull("Target nélküli torony nem hoz létre bulletet", bt.shoot());
	}
	
	@Test
	public void testShootBallista() {
		BallistaTower bt = new BallistaTower(80,280,null,100);
		
		bt.setRCT();
		bt.addTarget(new Pepe(120,340,0,0,null));
		
		Assert.assertNotNull("Targettel rendelkező torony nem null bulletet hoz létre", bt.shoot());
	}
	
	@Test
	public void testShootFireNULL() {
		FireTower bt = new FireTower(0,0,null);
		
		bt.setRCT();
		Assert.assertNull("Target nélküli torony nem hoz létre bulletet", bt.shoot());
	}
	
	@Test
	public void testShootFire() {
		FireTower bt = new FireTower(80,280,null,100);
		
		bt.setRCT();
		bt.addTarget(new Pepe(120,340,0,0,null));
		
		Assert.assertNotNull("Targettel rendelkező torony nem null bulletet hoz létre", bt.shoot());
	}
	
	@Test
	public void testShootIceNULL() {
		IceTower bt = new IceTower(0,0,null);
		
		bt.setRCT();
		Assert.assertNull("Target nélküli torony nem hoz létre bulletet", bt.shoot());
	}
	
	@Test
	public void testShootIce() {
		IceTower bt = new IceTower(80,280,null,100);
		
		bt.setRCT();
		bt.addTarget(new Pepe(120,340,0,0,null));
		
		Assert.assertNotNull("Targettel rendelkező torony nem null bulletet hoz létre", bt.shoot());
	}
	
	@Test
	public void testShootTeslaNULL() {
		TeslaTower bt = new TeslaTower(0,0,null);
		
		bt.setRCT();
		Assert.assertNull("Target nélküli torony nem hoz létre bulletet", bt.shoot());
	}
	
	@Test
	public void testShootTesla() {
		TeslaTower bt = new TeslaTower(80,280,null,100);
		
		bt.setRCT();
		bt.addTarget(new Pepe(120,340,0,0,null));
		
		Assert.assertNotNull("Targettel rendelkező torony nem null bulletet hoz létre", bt.shoot());
	}
}
