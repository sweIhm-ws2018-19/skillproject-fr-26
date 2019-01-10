package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.Attributes;
import muctivities.constants.Phrases;
import muctivities.model.RandomPicker;

public class DescriptionHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.YesIntent")
				.and(sessionAttribute(Attributes.STATE_KEY, Attributes.DESCRIPTION_STATE)));

	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText;

		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		Map<String, String> activity = (LinkedHashMap<String, String>) sessionAttributes.get(Attributes.ACTIVITY_KEY);
		speechText = activity.get("description") + " " + Phrases.DESCRIPTION_AND_END_QUESTION;
		sessionAttributes.put(Attributes.REPEAT_KEY, speechText);
		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
	}

}
