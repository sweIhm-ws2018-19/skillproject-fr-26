package muctivities.model;

public enum Kategorie {
	KULTUR, SPASS, SPORT;

	/**
	 * Parses a string to a enum category. Prefer this instead of valueOf() to
	 * ignore the case of the string parameter.
	 *
	 * @param categoryName Name of the category
	 * @return Category matching the given name. No-match returns null.
	 */
	public static Kategorie parseString(String categoryName) {
		for (Kategorie kategorie : Kategorie.class.getEnumConstants()) {
			if (kategorie.name().equalsIgnoreCase(categoryName)) {
				return kategorie;
			}
			if (kategorie.name().equalsIgnoreCase("SPASS") && categoryName.equalsIgnoreCase("Spaß")) {
				return kategorie;
			}
		}
		return null;
	}
}
