package muctivities.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class KategorieTest {

	@Test
	public void testParseString() {
		assertEquals(Kategorie.SPASS, Kategorie.parseString("spass"));
		assertEquals(Kategorie.SPASS, Kategorie.parseString("Spass"));
		assertEquals(Kategorie.SPASS, Kategorie.parseString("sPass"));
		assertNull(Kategorie.parseString("asdf"));
	}

}
