package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.Attributes;
import muctivities.constants.Phrases;
import muctivities.model.Activity;

public class Suggestion2 implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(
				intentName("AMAZON.NoIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.INFO_STATE)));

	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

		sessionAttributes.put(Attributes.STATE_KEY, Attributes.SUGESTION2_STATE);
		String speechText = "Vorschlag2. noch nicht implementiert";
		sessionAttributes.put(Attributes.REPEAT_KEY, speechText);

		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();

	}

}
