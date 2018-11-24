package muctivities.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class Database {

	private static final String AKTIVITES_DATABASE = "activitiesdb.json";

	/**
	 * Static class, no ctor
	 */
	private Database() {
	}

	public static List<Activity> suggestionOfActivities(boolean location, boolean duration, String categoryString)
			throws Exception {
		Kategorie category = Kategorie.parseString(categoryString);
		List<Activity> activities = getDatabaseEntries();
		return activities.stream().filter(activity -> activity.isAllday() == duration)
				.filter(activity -> activity.isOutdoor() == location)
				.filter(activity -> activity.getCategory() == category).collect(Collectors.toList());

	}

	public static Activity randomActivity() throws JSONException, Exception {
		return RandomPicker.get(getDatabaseEntries());
	}

	static List<Activity> getDatabaseEntries() throws JSONException, Exception {
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

	static String readFile() throws IOException { // TODO throws declaration, best practice? or should we catch it?
		ClassLoader cl = Database.class.getClassLoader();
		String filePath = cl.getResource(AKTIVITES_DATABASE).getFile();

		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		try {
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			return new String(data, StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new IOException(e);
		} finally {
			fis.close(); // Multiple streams were opened. Only the last is closed.
		}

	}

}
