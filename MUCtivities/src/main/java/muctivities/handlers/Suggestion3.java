package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.Attributes;
import muctivities.constants.Phrases;

public class Suggestion3 implements RequestHandler  {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.NoIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.SUGESTION2_STATE)));

	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

		sessionAttributes.put(Attributes.STATE_KEY, Attributes.SUGESTION3_STATE);
		String speechText="Vorschlag 3. noch nicht implementiert";
		
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard(Phrases.MUCTIVITIES_NAME, speechText)
				.withShouldEndSession(false).build();

	}

}
