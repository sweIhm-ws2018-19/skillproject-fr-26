package muctivities.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class KategorieTest {

	@Test
	public void testParseString() {
		assertEquals(Kategorie.SPAẞ, Kategorie.parseString("spaß"));
		assertEquals(Kategorie.SPAẞ, Kategorie.parseString("Spaß"));
		assertEquals(Kategorie.SPAẞ, Kategorie.parseString("sPaß"));
		assertEquals(null, Kategorie.parseString("asdf"));
	}

}
