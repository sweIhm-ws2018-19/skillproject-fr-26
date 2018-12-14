package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import muctivities.constants.*;
import muctivities.model.Activity;
import muctivities.model.TipOfTheDay;

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
			Activity activity = TipOfTheDay.get();
			Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
			sessionAttributes.put(Attributes.STATE_KEY, Attributes.DESCRIPTION_STATE);
			sessionAttributes.put(Attributes.ACTIVITY_KEY, activity);
			speechText = String.format(Phrases.DAILY_TIPP, activity.getName());
			sessionAttributes.put(Attributes.REPEAT_KEY, speechText);
		} catch (Exception e) {
			speechText = "Fehler. Tipp des Tages";
		}
		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();

	}

}
