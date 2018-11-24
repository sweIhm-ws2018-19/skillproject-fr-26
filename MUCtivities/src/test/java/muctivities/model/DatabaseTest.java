package muctivities.model;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void testGetDatabaseEntries() {
		List<Activity> activities;
		try {
			activities = Database.getDatabaseEntries();
			Assert.assertEquals(38, activities.size());
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReadFile() {
		try {
			String fileContent = Database.readFile();
			Assert.assertEquals('[', fileContent.charAt(0));
			Assert.assertEquals(']', fileContent.charAt(fileContent.length() - 1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParseJSONObject() {
		JSONObject exampleFromDatabase = new JSONObject("  {\r\n" + 
		"    \"location\": false,\r\n" + 
		"    \"duration\": false,\r\n" + 
		"    \"category\": \"Spaß\",\r\n" + 
		"    \"name\": \"Museum\",\r\n" + 
		"    \"info\": \"asdf\"\r\n" + 
		"  },\r\n");
		Activity activity = Database.parseJSONObject(exampleFromDatabase);
		Assert.assertEquals("Museum", activity.getName());
		Assert.assertEquals("asdf", activity.getDescription());
		Assert.assertEquals(false , activity.isAllday());
		Assert.assertEquals(false , activity.isOutdoor());
		Assert.assertEquals(Kategorie.spaß, activity.getCategory());
	}

	@Test
	public void suggestionOfActivities() throws JSONException, IOException {
		List<Activity> suggestions = Database.suggestionOfActivities(true, true, "spaß");
		suggestions.forEach(activity -> {
			Assert.assertEquals(Kategorie.spaß, activity.getCategory());
		});
		Assert.assertEquals(3, suggestions.size());
	}

}
