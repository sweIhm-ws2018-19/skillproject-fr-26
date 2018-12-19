package muctivities.model;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;

import static org.junit.Assert.*;

public class TipOfTheDayTest {

    @Test
    public void getSameActivitiesOnSameDate() throws IOException {
        Activity act1 = TipOfTheDay.get();
        Activity act2 = TipOfTheDay.get();
        assertEquals(act1.getName(), act2.getName());
    }

    @Test
    public void tipAtDayDifferentActivitiesOnDifferentDays() throws IOException {
        Activity act1 = TipOfTheDay.tipAtDay(Calendar.DAY_OF_YEAR);
        Activity act2 = TipOfTheDay.tipAtDay(Calendar.DAY_OF_YEAR + 1);
        assertNotEquals(act1.getName(), act2.getName());
    }
}