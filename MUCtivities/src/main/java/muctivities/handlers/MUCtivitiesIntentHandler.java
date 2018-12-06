package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.*;

import muctivities.model.Wetterdienst;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class MUCtivitiesIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("MUCtivitiesIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        sessionAttributes.put(Attributes.STATE_KEY, Attributes.LOCATION_STATE);

        Optional<Boolean> aBoolean = Wetterdienst.wetterVorhersage();
        Boolean orElse = aBoolean.orElse(true);

        String speechText = orElse ? Phrases.WEATHER_SUNNY : Phrases.WEATHER_RAINY;
        return input.getResponseBuilder().withSpeech(speechText).withSimpleCard(Phrases.MUCtivities_Name, speechText)
                .withShouldEndSession(false).build();


    }

}
