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

public class NoDescriptionHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.NoIntent")
				.and(sessionAttribute(Attributes.STATE_KEY, Attributes.DESCRIPTION_STATE)));

	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		String speechText = Phrases.NO_DESCRIPTION;
		sessionAttributes.put(Attributes.REPEAT_KEY, speechText);

		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
	}

}
