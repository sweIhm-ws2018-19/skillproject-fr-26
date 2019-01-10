package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import muctivities.constants.*;
import muctivities.model.RandomPicker;

public class Location1Handler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(

				(sessionAttribute(Attributes.STATE_KEY, Attributes.LOCATION_STATE)));
//				&& (input.matches(intentName("AMAZON.YesIntent").or(intentName("AMAZON.NoIntent"))));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		String speechText;

		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
//		boolean locationBool = !input.matches(intentName("AMAZON.YesIntent"))
//				^ (boolean) sessionAttributes.get(Attributes.WEATHER_KEY);

		sessionAttributes.put(Attributes.STATE_KEY, Attributes.DURATION_STATE);
//		sessionAttributes.put(Attributes.LOCATION_KEY, locationBool);
//		sessionAttributes.put(Attributes.REPEAT_KEY, Phrases.DURATION_REPROMT);
		speechText = Phrases.DURATION_QUESTION[2];
		ResponseBuilder responseBuilder = input.getResponseBuilder();

		responseBuilder.withSpeech(speechText).withShouldEndSession(false);

		return responseBuilder.build();
	}

}
