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

public class DescriptionHandler implements RequestHandler{

	@Override
	public boolean canHandle(HandlerInput input) {
		// TODO Auto-generated method stub
		return input.matches(intentName("AMAZON.YesIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.DESCRIPTION_STATE)));


	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechtext;
	
			Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();


//			Activity activitie = (Activity) sessionAttributes.get(Attributes.ACTIVITY_KEY);
			Map<String, String> activity = (LinkedHashMap<String, String>) sessionAttributes
					.get(Attributes.ACTIVITY_KEY);
			speechtext=	activity.get("description");
			
	
		return input.getResponseBuilder().withSpeech(speechtext)
				// .withReprompt(Phrases.WELCOME_REPROMT)
				.build();
	}

}
