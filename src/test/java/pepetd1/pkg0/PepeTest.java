package test.pepetd1.pkg0;

import org.junit.Assert;
import org.junit.Test;

import pepetd1.pkg0.ElementalType;
import pepetd1.pkg0.Pepe;

public class PepeTest {
	
	@Test
	public void testTakeDamage1() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re állítja az életét
		int before = pepe.getHealth();
		pepe.takeDamage(-1,ElementalType.PHYSICAL);
		Assert.assertTrue("Negativ sebzes nem lehet, nem valtozik a Pepe elete",pepe.getHealth() == before);
	}
	
	@Test
	public void testTakeDamage2() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re állítja az életét
		int before = pepe.getHealth();
		pepe.takeDamage(1,ElementalType.PHYSICAL);
		Assert.assertTrue("Pozitiv sebzes, nem hal bele",
				pepe.getHealth() == before-1 && pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage3() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re állítja az életét
		int before = pepe.getHealth();
		pepe.takeDamage(10,ElementalType.PHYSICAL);
		Assert.assertTrue("Pozitiv sebzes, belehal, nulla lesz az elete",
				pepe.getHealth() == before-10 && !pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage4() {
		Pepe pepe = new Pepe(0,0,2,2,null); //ez a konstruktor 10re állítja az életét
		int before = pepe.getHealth();
		pepe.takeDamage(11,ElementalType.PHYSICAL);
		Assert.assertTrue("Pozitiv sebzes, belehal, negativba megy az elete",
				pepe.getHealth() == before-11 && !pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage_Resistance() {
		Pepe pepe = new Pepe(0,0,2,2,null);
		int before = pepe.getHealth();
		pepe.addResistance(ElementalType.PHYSICAL);
		pepe.takeDamage(2,ElementalType.PHYSICAL);
		Assert.assertTrue("Ellenallo, nem hal bele",pepe.getHealth() == before-1 && pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage_Resistance2() {
		Pepe pepe = new Pepe(0,0,2,2,null);
		int before = pepe.getHealth();
		pepe.addResistance(ElementalType.PHYSICAL);
		pepe.takeDamage(20,ElementalType.PHYSICAL);
		Assert.assertTrue("Ellenallo, belehal",pepe.getHealth() == before-10 && !pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage_Resistance3() {
		Pepe pepe = new Pepe(0,0,2,2,null);
		int before = pepe.getHealth();
		pepe.addResistance(ElementalType.PHYSICAL);
		pepe.takeDamage(2,ElementalType.FIRE);
		Assert.assertTrue("Nem ellenallo, nem hal bele",pepe.getHealth() == before-2 && pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage_Resistance4() {
		Pepe pepe = new Pepe(0,0,2,2,null);
		int before = pepe.getHealth();
		pepe.addResistance(ElementalType.PHYSICAL);
		pepe.takeDamage(10,ElementalType.FIRE);
		Assert.assertTrue("Nem ellenallo, belehal",pepe.getHealth() == before-10 && !pepe.isAlive());
	}
	
	@Test
	public void testTakeDamage_Vulnerability() {
		Pepe pepe = new Pepe(0,0,2,2,null);
		int before = pepe.getHealth();
		pepe.addWeakness(ElementalType.PHYSICAL);
		pepe.takeDamage(2,ElementalType.PHYSICAL);
		Assert.assertTrue("Sebezhetobb ellene, nem hal bele", pepe.getHealth() == before-4 && pepe.isAlive());;
	}
	
	@Test
	public void testTakeDamage_Vulnerability2() {
		Pepe pepe = new Pepe(0,0,2,2,null);
		int before = pepe.getHealth();
		pepe.addWeakness(ElementalType.PHYSICAL);
		pepe.takeDamage(5,ElementalType.PHYSICAL);
		Assert.assertTrue("Sebezhetobb ellene, belehal", pepe.getHealth() == before-10 && !pepe.isAlive());;
	}
	
	@Test
	public void testTakeDamage_Vulnerability3() {
		Pepe pepe = new Pepe(0,0,2,2,null);
		int before = pepe.getHealth();
		pepe.addWeakness(ElementalType.PHYSICAL);
		pepe.takeDamage(2,ElementalType.FIRE);
		Assert.assertTrue("Nem sebezhetobb ellene, nem hal bele", pepe.getHealth() == before-2 && pepe.isAlive());;
	}
	
	@Test
	public void testTakeDamage_Vulnerability4() {
		Pepe pepe = new Pepe(0,0,2,2,null);
		int before = pepe.getHealth();
		pepe.addWeakness(ElementalType.PHYSICAL);
		pepe.takeDamage(10,ElementalType.FIRE);
		Assert.assertTrue("Nem sebezhetobb ellene, belehal", pepe.getHealth() == before-10 && !pepe.isAlive());;
	}
	
	//MOZGAS TESZT!!
}
