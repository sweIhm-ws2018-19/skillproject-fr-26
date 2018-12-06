package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.LaunchRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.amazon.ask.request.Predicates.requestType;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LaunchRequestHandlerTest {
    private HelpIntentHandler handler;

    @Before
    public void setup() {
        handler = new HelpIntentHandler();
    }

    @Test
    public void canHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(requestType(LaunchRequest.class))).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }
}