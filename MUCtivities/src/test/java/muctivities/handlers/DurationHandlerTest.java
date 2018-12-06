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

public class DurationHandlerTest {

    private DurationHandler handler;

    @Before
    public void setup() {
        handler = new DurationHandler();
    }

    @Test
    public void canHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(
                intentName("AttributesIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.DURATION_STATE)))
        ).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void handle() {
    }

}