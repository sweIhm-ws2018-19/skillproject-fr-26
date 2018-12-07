package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import muctivities.constants.*;
import muctivities.model.Activity;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class TippDesTagesHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("TippDesTages"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText;
		try {
			Activity activitie = muctivities.model.Database.randomActivity();
			Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
			sessionAttributes.put(Attributes.STATE_KEY, Attributes.INFO_STATE);
			sessionAttributes.put(Attributes.ACTIVITY_KEY, activitie);
			speechText = "Der Tipp des Tages ist " + activitie.getName();
			//return input.getResponseBuilder().withSpeech(speechText)
				//	.withSimpleCard(Phrases.MUCTIVITIES_NAME, speechText).build();
		} catch (Exception e) {
			speechText = "Fehler. Tipp des Tages";
		}
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard(Phrases.MUCTIVITIES_NAME, speechText)
				.withShouldEndSession(false).build();

	}

}
