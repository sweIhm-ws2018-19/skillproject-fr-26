package muctivities.constants;

import org.junit.Assert;
import org.junit.Test;

public class WellPlayedTest {
    @Test
    public void testTheConstants(){
        Assert.assertNotNull(Phrases.LAUNCH_REQUEST);
        Assert.assertNotNull(Phrases.LAUNCH_REQUEST_REPEAT);
        Assert.assertNotNull(Phrases.HELP_INTENT);
        Assert.assertNotNull(Phrases.FALLBACK_INTENT);
        Assert.assertNotNull(Phrases.WEATHER_RAINY);
        Assert.assertNotNull(Phrases.WEATHER_SUNNY);
        Assert.assertNotNull(Phrases.WEATHER_REPROMPT);
        Assert.assertNotNull(Phrases.WEATHER_SUNNY_REPROMT);
        Assert.assertNotNull(Phrases.WEATHER_RAINY_REPROMPT);
        Assert.assertNotNull(Phrases.DAILY_TIPP);
        Assert.assertNotNull(Phrases.DURATION_QUESTION);
        Assert.assertNotNull(Phrases.DURATION_REPROMT);
        Assert.assertNotNull(Phrases.CATEGORIE_QUESTION);
        Assert.assertNotNull(Phrases.CATEGORIE_REPROMT);
        Assert.assertNotNull(Phrases.NEXT_SUGGESTION);
        Assert.assertNotNull(Phrases.INFO_REPROMT);
        Assert.assertNotNull(Phrases.FIRST_SUGGESTION);
        Assert.assertNotNull(Phrases.END_OF_SUGGESTIONS);
        Assert.assertNotNull(Phrases.TIP_OF_DAY_END_QUESTION);
        Assert.assertNotNull(Phrases.MORE_INFORMATION);
        Assert.assertNotNull(Phrases.CANCEL_AND_STOP_INTENT);
        Assert.assertNotNull(Phrases.DESCRIPTION_END);
    }

    @Test
    public void testTheAttributes() {
        Assert.assertNotNull(Attributes.STATE_KEY);
        Assert.assertNotNull(Attributes.LOCATION_KEY);
        Assert.assertNotNull(Attributes.DURATION_KEY);
        Assert.assertNotNull(Attributes.CATEGORIE_KEY);
        Assert.assertNotNull(Attributes.ACTIVITY_KEY);
        Assert.assertNotNull(Attributes.WEATHER_KEY);
        Assert.assertNotNull(Attributes.LIST_KEY);
        Assert.assertNotNull(Attributes.REPEAT_KEY);
        Assert.assertNotNull(Attributes.COUNTER_KEY);

        Assert.assertNotNull(Attributes.LOCATION_STATE);
        Assert.assertNotNull(Attributes.DURATION_STATE);
        Assert.assertNotNull(Attributes.CATEGORIE_STATE);
        Assert.assertNotNull(Attributes.NEXTSUGGESTION_STATE);
        Assert.assertNotNull(Attributes.NEW_CATEGORIE_STATE);

        Assert.assertNotNull(Attributes.DESCRIPTION_STATE);
        Assert.assertNotNull(Attributes.INFO_STATE);

        Assert.assertNotNull(Attributes.CATEGORIE_SLOT);
        Assert.assertNotNull(Attributes.DURATION_SLOT);
        Assert.assertNotNull(Attributes.LOCATION_SLOT);
    }

}
