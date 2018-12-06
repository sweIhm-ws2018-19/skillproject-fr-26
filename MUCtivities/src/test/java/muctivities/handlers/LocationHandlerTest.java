package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import muctivities.constants.Attributes;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class LocationHandlerTest {

    private LocationHandler handler;

    @Before
    public void setup() {
        handler = new LocationHandler();
    }

    @Test
    public void canHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(
                intentName("AttributesIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.LOCATION_STATE)))).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void handle() {
    }
}