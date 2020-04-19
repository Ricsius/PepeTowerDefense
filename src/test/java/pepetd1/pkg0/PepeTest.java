package test.pepetd1.pkg0;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.Pepe;

public class PepeTest {
	
	@Test
	public void testTakeDamage1() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re �ll�tja az �let�t
		int before = pepe.getHealth();
		pepe.takeDamage(-1);
		Assert.assertTrue("Negativ sebzes nem lehet, nem valtozik a Pepe elete",pepe.getHealth() == before);
	}
	
	@Test
	public void testTakeDamage2() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re �ll�tja az �let�t
		int before = pepe.getHealth();
		pepe.takeDamage(1);
		Assert.assertTrue("Pozitiv sebzes, nem hal bele",
				pepe.getHealth() == before-1 && pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage3() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re �ll�tja az �let�t
		int before = pepe.getHealth();
		pepe.takeDamage(10);
		Assert.assertTrue("Pozitiv sebzes, belehal, nulla lesz az elete",
				pepe.getHealth() == before-10 && !pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage4() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re �ll�tja az �let�t
		int before = pepe.getHealth();
		pepe.takeDamage(11);
		Assert.assertTrue("Pozitiv sebzes, belehal, negativba megy az elete",
				pepe.getHealth() == before-11 && !pepe.isAlive());
	}
	
	//MOZG�S TESZT!!
}
