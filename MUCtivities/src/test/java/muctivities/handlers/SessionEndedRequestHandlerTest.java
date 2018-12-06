package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.SessionEndedRequest;
import muctivities.constants.Attributes;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.requestType;
import static com.amazon.ask.request.Predicates.sessionAttribute;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class SessionEndedRequestHandlerTest {

    private SessionEndedRequestHandler handler;

    @Before
    public void setup() {
        handler = new SessionEndedRequestHandler();
    }

    @Test
    public void canHandle() {
        final HandlerInput inputMock = Mockito.mock(HandlerInput.class);
        when(inputMock.matches(requestType(SessionEndedRequest.class))).thenReturn(true);
        assertTrue(handler.canHandle(inputMock));
    }

    @Test
    public void handle() {
    }
}