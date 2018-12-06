package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.amazon.ask.request.Predicates.intentName;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class FallbackIntentHandlerTest {
    private FallbackIntentHandler handler;

    @Before
    public void setup() {
        handler = new FallbackIntentHandler();
    }

    @Test
    public void canHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(intentName("AMAZON.FallbackIntent"))).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void handle() {
    }
}