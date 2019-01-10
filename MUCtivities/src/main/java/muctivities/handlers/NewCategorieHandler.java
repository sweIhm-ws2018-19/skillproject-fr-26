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
import muctivities.constants.Settings;

public class NewCategorieHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input
				.matches(intentName("AMAZON.NoIntent")
						.and(sessionAttribute(Attributes.STATE_KEY, Attributes.NEW_CATEGORIE_STATE)))
				|| input.matches(intentName("MUCtivitiesIntent")
						.and(sessionAttribute(Attributes.COUNTER_KEY, Settings.MAX_SUGGESTIONS)));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText;
		try {	Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

		sessionAttributes.put(Attributes.STATE_KEY, Attributes.CATEGORIE_STATE);
		speechText = Phrases.END_OF_SUGGESTIONS;
		sessionAttributes.put(Attributes.REPEAT_KEY, speechText);
		speechText="hallo andreas";
	}catch(Exception e){
		speechText=e.getMessage();
	}
		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
	}
}
