package muctivities.model;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Database {

	private static final String AKTIVITES_DATABASE = "activitiesdb.json";

	/**
	 * Static class, no ctor
	 */
	private Database() {
	}

	public static List<Activity> suggestionOfActivities(boolean location, boolean duration, String categoryString)
			throws IOException {

		Kategorie category = Kategorie.parseString(categoryString);
		List<Activity> activities = getDatabaseEntries();
		return activities.stream().filter(activity -> activity.isAllday() == duration)
				.filter(activity -> activity.isOutdoor() == location)
				.filter(activity -> activity.getCategory() == category).collect(Collectors.toList());

	}

	public static Activity randomActivity() throws IOException {
		return RandomPicker.get(getDatabaseEntries());
	}

	static List<Activity> getDatabaseEntries() throws IOException {
		JSONArray database = new JSONArray(readFile());
		List<Activity> activities = new ArrayList<>();
		for (int i = 0; i < database.length(); i++) {
			JSONObject entry = database.getJSONObject(i);
			Activity activity = parseJSONObject(entry);
			activities.add(activity);
		}
		return activities;
	}

	static Activity parseJSONObject(JSONObject obj) {
		return new Activity(obj.getBoolean("location"), obj.getBoolean("duration"),
				Kategorie.parseString(obj.getString("category")), obj.getString("name"), obj.getString("info"));
	}

	/**
	 * // Multiple streams were opened. Only the last is closed. // throws
	 * declaration, best practice? or should we catch it?
	 * 
	 * @return string
	 * @throws IOException exception
	 */
	static String readFile() throws IOException {
		ClassLoader cl = Database.class.getClassLoader();

		try (InputStream fis = cl.getResourceAsStream(AKTIVITES_DATABASE)) {
			byte[] data = IOUtils.toByteArray(fis);
			return new String(data, StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new IOException(e);
		}

	}

}
