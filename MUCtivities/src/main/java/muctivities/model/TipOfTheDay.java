package muctivities.model;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public final class TipOfTheDay {

    private TipOfTheDay() {}

    public static Activity get() throws IOException {
        return tipAtDay(Calendar.DAY_OF_YEAR);
    }

    static Activity tipAtDay(int dayOfYear) throws IOException {
        List<Activity> activities = Database.getDatabaseEntries();
        return activities.get(dayOfYear % activities.size());
    }

}
