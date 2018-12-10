package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;

import muctivities.constants.Attributes;
import muctivities.constants.Phrases;
import muctivities.model.RandomPicker;

public class InfoHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.YesIntent"))
                && (input.matches(sessionAttribute(Attributes.STATE_KEY, Attributes.INFO_STATE))
                || input.matches(sessionAttribute(Attributes.STATE_KEY, Attributes.NEXTSUGGESTION_STATE)));

    }

    @Override
    public Optional<Response> handle(HandlerInput input) {

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        sessionAttributes.put(Attributes.STATE_KEY, Attributes.DESCRIPTION_STATE);

        String speechAndRepromptText = RandomPicker.get(Phrases.MORE_INFORMATION);
        sessionAttributes.put(Attributes.REPEAT_KEY, speechAndRepromptText);
        ResponseBuilder responseBuilder = input.getResponseBuilder();

        responseBuilder.withSpeech(speechAndRepromptText).withReprompt(speechAndRepromptText).withShouldEndSession(false);

        return responseBuilder.build();
    }

}
