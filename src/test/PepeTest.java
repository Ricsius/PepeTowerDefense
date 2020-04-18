package test.pepetd1.pkg0;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.Pepe;

public class PepeTest {
	
	@Test
	public void testTakeDamage1() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re állítja az életét
		int before = pepe.getHealth();
		pepe.takeDamage(-1);
		Assert.assertTrue("Negatív sebzés nem lehet, nem változik a Pepe élete",pepe.getHealth() == before);
	}
	
	@Test
	public void testTakeDamage2() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re állítja az életét
		int before = pepe.getHealth();
		pepe.takeDamage(1);
		Assert.assertTrue("Pozitív sebzés, nem hal bele",
				pepe.getHealth() == before-1 && pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage3() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re állítja az életét
		int before = pepe.getHealth();
		pepe.takeDamage(10);
		Assert.assertTrue("Pozitív sebzés, belehal, nulla lesz az élete",
				pepe.getHealth() == before-10 && !pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage4() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re állítja az életét
		int before = pepe.getHealth();
		pepe.takeDamage(11);
		Assert.assertTrue("Pozitív sebzés, belehal, negatívba megy az élete",
				pepe.getHealth() == before-11 && !pepe.isAlive());
	}
	
	//MOZGÁS TESZT!!
}
