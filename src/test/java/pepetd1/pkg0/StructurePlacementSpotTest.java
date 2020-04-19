package test.pepetd1.pkg0;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.StructurePlacementSpot;

public class StructurePlacementSpotTest {
	
	//a kirajzol�s torz�t�sa miatt el van "tol�dva" az inside f�ggv�ny, eszerint az y �rt�ke nem 120,
	//hanem 160 (az inside() szerint)
	@Test
	public void testInside1(){
		StructurePlacementSpot spot = new StructurePlacementSpot(80,120,null);
		
		Assert.assertTrue("Benne levo pont tenyleg benne van",spot.inside(90,170));
	}
	
	@Test
	public void testInside2(){
		StructurePlacementSpot spot = new StructurePlacementSpot(80,120,null);
		
		Assert.assertTrue("Hataron levo pont tenyleg benne van",spot.inside(80,160)); //bal fels� sarok
	}
	
	@Test
	public void testInside2_2(){
		StructurePlacementSpot spot = new StructurePlacementSpot(80,120,null);
		
		Assert.assertTrue("Hataron levo pont tenyleg benne van",spot.inside(92,160)); //fels� oldal
	}
	
	@Test
	public void testInside3(){
		StructurePlacementSpot spot = new StructurePlacementSpot(80,120,null);
		
		Assert.assertFalse("Kulso pont nincsen benne",spot.inside(0,0));
	}	
}
