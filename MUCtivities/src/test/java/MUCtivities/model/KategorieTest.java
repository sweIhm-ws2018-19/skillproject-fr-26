package muctivities.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class KategorieTest {

	@Test
	public void testParseString() {
		assertEquals(Kategorie.spaß, Kategorie.parseString("spaß"));
		assertEquals(Kategorie.spaß, Kategorie.parseString("Spaß"));
		assertEquals(Kategorie.spaß, Kategorie.parseString("sPaß"));
		assertEquals(null, Kategorie.parseString("asdf"));
	}

}
