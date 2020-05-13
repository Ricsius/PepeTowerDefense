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
		Level lvl = new Level("asd","asd","asd");
	}
	
	@Test
	public void testConstructor2() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes_test.txt","data/level0move.txt");
			Assert.assertTrue("Üres level",lvl.getSpots().isEmpty());
	}
	
	@Test
	public void testConstructor3() throws IOException {
		Level lvl = new Level("data/level_test2.txt","data/levelPepes_test.txt","data/level0move.txt");
			Assert.assertTrue("4 toronyhely",!lvl.getSpots().isEmpty());	
	}
	
	@Test
	public void testConstructor4() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes_test.txt","data/level0move.txt");
			boolean pepes = lvl.getPepes().isEmpty();
			Assert.assertTrue("nincs pepe",pepes);
	}
	
	@Test
	public void testConstructor5() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes1.txt","data/level0move.txt");
			int pepes = lvl.getPepes().size();
			Assert.assertTrue("Vannak pepek",pepes == 7);
	}
	
	@Test
	public void testTowerShoot() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes1.txt","data/level0move.txt");
			lvl.towerShoot();
			Assert.assertTrue("Nincs torony",lvl.getBullets().isEmpty());		
	}
	
	@Test
	public void testClickedInSpot1() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes_test.txt","data/level0move.txt");
		Assert.assertNull("Nincs torony hely",lvl.clickedInPlacementSpot(2, 3, 0));
	}
	
	@Test
	public void testClickedInSpot2() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt","data/level0move.txt");
		Assert.assertNull("Van torony hely, nem kattintunk bele",lvl.clickedInPlacementSpot(2, 3, 0));
	}
	
	@Test
	public void testClickedInSpot2_2() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt","data/level0move.txt");
		Assert.assertNotNull("Van torony hely, belekattintunk",lvl.clickedInPlacementSpot(131, 182, 0));
	}
	
	@Test
	public void testClickedInTower1() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt","data/level0move.txt");
		Assert.assertNull("Nincs torony",lvl.clickedInTower(131, 182));
	}
	
	@Test
	public void testClickedInTower2() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt","data/level0move.txt");
		lvl.getTowers().add(new Tower(0,0,null,0,0,0));
		Assert.assertNull("Van torony, nem kattintunk bele",lvl.clickedInTower(131, 182));
	}
	
	@Test
	public void testClickedInTower2_2() {
		Level lvl = null;
		try {
			lvl = new Level("data/level.txt","data/levelPepes_test.txt","data/level0move.txt");
			lvl.getTowers().add(new Tower(80,280,null,0,0,0));
			Assert.assertNotNull("Van torony, belekattintunk",lvl.clickedInTower(133, 402));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testCreateTower() throws IOException {
		Level lvl = new Level("data/level.txt","data/levelPepes_test.txt","data/level0move.txt");
		Assert.assertNotNull("Van rá pénz",lvl.createIceTower(0, 0));
	}
	
	@Test
	public void testDeleteTower() throws IOException {
		Level lvl = new Level("data/level_test1.txt","data/levelPepes_test.txt","data/level0move.txt");
		lvl.createBallistaTower(0, 0);
		lvl.deleteTower(new Tower(0,0,null,0,0,0));
		Assert.assertTrue("Törlünk egy tornyot, helyére rakunk egy Spotot",lvl.getSpots().size() == 1);
	}

}
