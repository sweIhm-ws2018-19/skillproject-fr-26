package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;
import muctivities.constants.Attributes;
import muctivities.constants.Phrases;
import muctivities.model.RandomPicker;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class DurationHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(
                intentName("AttributesIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.DURATION_STATE)));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();
        Slot durationSlot = slots.get(Attributes.DURATION_SLOT);

        String speechText;
        String repromptText;

        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        if (durationSlot != null && durationSlot.getResolutions() != null
                && durationSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
            boolean durationBool = slots.get(Attributes.DURATION_SLOT).toString().contains("true");
            sessionAttributes.put(Attributes.STATE_KEY, Attributes.CATEGORIE_STATE);
            sessionAttributes.put(Attributes.DURATION_KEY, durationBool);
            sessionAttributes.put(Attributes.REPEAT_KEY, Phrases.CATEGORIE_REPROMT);

            String repeat = RandomPicker.get(Phrases.CATEGORIE_QUESTION);
            speechText = repeat;
            repromptText = repeat;
        } else {
            speechText = Phrases.DURATION_REPROMT;
            repromptText = "Ganzer Tag oder paar Stunden? Ich habe dich nicht verstanden, bitte versuche es erneut";
        }

        ResponseBuilder responseBuilder = input.getResponseBuilder();

        responseBuilder.withSpeech(speechText).withReprompt(repromptText).withShouldEndSession(false);

        return responseBuilder.build();
    }

}
