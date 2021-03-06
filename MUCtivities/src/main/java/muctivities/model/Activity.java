package muctivities.model;

public class Activity {

	private final boolean isOutdoor;
	private final boolean isAllday;
	private final Kategorie category;
	private final String name;
	private final String description;

	Activity(boolean isOutdoor, boolean isAllday, Kategorie category, String name, String description) {
		this.isOutdoor = isOutdoor;
		this.isAllday = isAllday;
		this.category = category;
		this.name = name;
		this.description = description;
	}

	boolean isOutdoor() {
		return isOutdoor;
	}

	boolean isAllday() {
		return isAllday;
	}

	Kategorie getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
