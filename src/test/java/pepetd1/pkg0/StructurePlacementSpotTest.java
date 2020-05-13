package test.pepetd1.pkg0;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.StructurePlacementSpot;

public class StructurePlacementSpotTest {
	
	//a kirajzolás torzítása miatt el van "tolódva" az inside függvény, eszerint az y értéke nem 120,
	//hanem 160 (az inside() szerint)
	@Test
	public void testInside1(){
		StructurePlacementSpot spot = new StructurePlacementSpot(80,120,null);
		
		Assert.assertTrue("Benne lévő pont tényleg benne van",spot.inside(90,170));
	}
	
	@Test
	public void testInside2(){
		StructurePlacementSpot spot = new StructurePlacementSpot(80,120,null);
		
		Assert.assertTrue("Határán lévő pont tényleg benne van",spot.inside(80,160)); //bal felső sarok
	}
	
	@Test
	public void testInside2_2(){
		StructurePlacementSpot spot = new StructurePlacementSpot(80,120,null);
		
		Assert.assertTrue("Határán lévő pont tényleg benne van",spot.inside(92,160)); //felső oldal
	}
	
	@Test
	public void testInside3(){
		StructurePlacementSpot spot = new StructurePlacementSpot(80,120,null);
		
		Assert.assertFalse("Külső pont nincsen benne",spot.inside(0,0));
	}	
}
