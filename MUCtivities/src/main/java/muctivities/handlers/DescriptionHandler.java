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
//		return input.matches(intentName("AMAZON.YesIntent")
//				.and(sessionAttribute(Attributes.STATE_KEY, Attributes.DESCRIPTION_STATE)));
		return input.matches(sessionAttribute(Attributes.STATE_KEY, Attributes.DESCRIPTION_STATE));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText;

		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
//		Map<String, String> activity = (LinkedHashMap<String, String>) sessionAttributes.get(Attributes.ACTIVITY_KEY);
		speechText = "In der riesigen Trampolinanlage kannst du Springen, einen Salto üben, Völkerball spielen und vieles mehr. Die Arena befindet sich in der Ingolstädter Straße 172 und hat heute bis 21 Uhr geöffnet. Möchtest du MUCtivities beenden oder einen neuen Vorschlag?";
//		sessionAttributes.put(Attributes.REPEAT_KEY, speechText);
//if(sessionAttributes.containsKey(Attributes.COUNTER_KEY)) {
	sessionAttributes.put(Attributes.STATE_KEY, "_END");
//}
	
		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
	}

}
