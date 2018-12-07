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
import muctivities.model.Activity;

public class InfoHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("Info").and(sessionAttribute(Attributes.STATE_KEY, Attributes.INFO_STATE)));

	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechtext;
		try {
			Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();


//			Activity activitie = (Activity) sessionAttributes.get(Attributes.ACTIVITY_KEY);
			Map<String, String> activity = (LinkedHashMap<String, String>) sessionAttributes
					.get(Attributes.ACTIVITY_KEY);
			speechtext=	activity.get("description");
			
		} catch (Exception e) {
			// System.out.println(e.getStackTrace());
			speechtext = e.getMessage();
		}

		return input.getResponseBuilder().withSpeech(speechtext)
				// .withReprompt(Phrases.WELCOME_REPROMT)
				.build();
	}

}
