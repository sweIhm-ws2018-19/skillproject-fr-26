package muctivities.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import muctivities.model.Kategorie;

public final class Database {
	
	private static final String activitiesDatabase = "activitiesdb.json";
	
	/**
	 * Static class, no ctor
	 */
	private Database() {}
	
	public static List<Activity> suggestionOfActivities(boolean location, boolean duration, String category) throws JSONException, IOException {
		Kategorie _category = Kategorie.parseString(category);
		List<Activity> activities = getDatabaseEntries();
		List<Activity> filteredActivites = activities.stream()
				.filter(activity -> activity.isAllday() == duration)
				.filter(activity -> activity.isOutdoor() == location)
				.filter(activity -> activity.getCategory() == _category)
				.collect(Collectors.toList());
		return filteredActivites;
	}
	
	public static Activity randomActivity() throws JSONException, IOException {
		return RandomPicker.get(getDatabaseEntries());
	}
	
	static List<Activity> getDatabaseEntries() throws JSONException, IOException {	
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
		return new Activity(
				obj.getBoolean("location"),
				obj.getBoolean("duration"),
				Kategorie.parseString(obj.getString("category")),
				obj.getString("name"),
				obj.getString("info")
		);
	}
	
	static String readFile() throws IOException { //TODO throws declaration, best practice? or should we catch it?
		ClassLoader cl = Database.class.getClassLoader();
		String filePath = cl.getResource(activitiesDatabase).getFile();
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();
		return new String(data, "UTF-8");
	}
	
}
