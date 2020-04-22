package test.pepetd1.pkg0;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.Level;
import pepetd1.pkg0.NakedPepe;
import pepetd1.pkg0.Tower;

import java.util.ArrayList;

public class LevelTest {
	
	@Test (expected = Exception.class)
	public void testConstructor() throws IOException {
		Level lvl = new Level("asd","asd");
	}
	
	@Test
	public void testConstructor2() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes_test.txt");
			Assert.assertTrue("ures level",lvl.getSpots().isEmpty());
	}
	
	@Test
	public void testConstructor3() throws IOException {
		Level lvl = new Level("data/level_test2.txt","data/levelPepes_test.txt");
			Assert.assertTrue("4 toronyhely",!lvl.getSpots().isEmpty());	
	}
	
	@Test
	public void testConstructor4() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes_test.txt");
			boolean naked = lvl.getNakeds().isEmpty();
			boolean wizard = lvl.getWizards().isEmpty();
			boolean tank = lvl.getTanks().isEmpty();
			boolean ricardo = lvl.getRicardo().isEmpty();
			Assert.assertTrue("nincs pepe",naked && wizard && tank && ricardo);
	}
	
	@Test
	public void testConstructor5() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes1.txt");
			int naked = lvl.getNakeds().size();
			int wizard = lvl.getWizards().size();
			int tank = lvl.getTanks().size();
			int ricardo = lvl.getRicardo().size();
			Assert.assertTrue("Vannak pepek",naked == 5 && wizard == 3 && tank == 2 && ricardo == 1);	
	}
	
	@Test
	public void testTowerShoot() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes1.txt");
			lvl.towerShoot();
			Assert.assertTrue("Nincs torony",lvl.getBullets().isEmpty());		
	}
	
	/*@Test
	public void testTowerShoot2() throws IOException {
		Level lvl = new Level("data/level_test3.txt","data/levelPepes.txt");
		lvl.createBallistaTower(0, 0);
			lvl.towerShoot();
			Assert.assertTrue("Egy torony",lvl.getBullets().isEmpty());		
	}*/
	
	/*@Test
	public void testTowerShoot3() {
		Level lvl = null;
		try {
			lvl = new Level("level_test2","levelPepes");
			lvl.towerShoot();
			Assert.assertTrue("T�bb torony",lvl.getBullets().size() == 12312);
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}*/
	
	/*@Test
	public void testInRange1() {
		
	}*/
	
	@Test
	public void testClickedInSpot1() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes_test.txt");
		Assert.assertNull("Nincs torony hely",lvl.clickedInPlacementSpot(2, 3));
	}
	
	@Test
	public void testClickedInSpot2() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt");
		Assert.assertNull("Van torony hely, nem kattintunk bele",lvl.clickedInPlacementSpot(2, 3));
	}
	
	@Test
	public void testClickedInSpot2_2() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt");
		Assert.assertNotNull("Van torony hely, belekattintunk",lvl.clickedInPlacementSpot(131, 182));
	}
	
	@Test
	public void testClickedInTower1() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt");
		Assert.assertNull("Nincs torony",lvl.clickedInTower(131, 182));
	}
	
	@Test
	public void testClickedInTower2() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt");
		lvl.getTowers().add(new Tower(0,0,null,0,0,0));
		Assert.assertNull("Van torony, nem kattintunk bele",lvl.clickedInTower(131, 182));
	}
	
	@Test
	public void testClickedInTower2_2() {
		Level lvl = null;
		try {
			lvl = new Level("data/level.txt","data/levelPepes_test.txt");
			lvl.getTowers().add(new Tower(80,280,null,0,0,0));
			Assert.assertNotNull("Van torony, belekattintunk",lvl.clickedInTower(133, 402));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//csak IceTower-re n�zem meg, mivel a t�bbin�l is ugyanazt csin�lja a program
	@Test
	public void testCreateTower() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt");
		lvl.cutMoney(800);
		Assert.assertNull("Nincs ra penz",lvl.createIceTower(0, 0));
	}
	
	@Test
	public void testCreateTower2() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt");
		Assert.assertNotNull("Van ra penz",lvl.createIceTower(0, 0));
	}
	
	@Test
	public void testDeleteTower() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes_test.txt");
		lvl.createBallistaTower(0, 0);
		lvl.deleteTower(new Tower(0,0,null,0,0,0));
		Assert.assertTrue("Torlunk egy tornyot, helyere rakunk egy Spotot",lvl.getSpots().size() == 1);
	}

}
