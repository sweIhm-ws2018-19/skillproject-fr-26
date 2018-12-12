package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import java.util.*;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.Attributes;
import muctivities.constants.Phrases;
import muctivities.constants.Settings;
import muctivities.model.RandomPicker;

public class NextSuggestionsHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(
				intentName("AMAZON.NoIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.INFO_STATE)));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

		int counter = (int) input.getAttributesManager().getSessionAttributes().get(Attributes.COUNTER_KEY);
		counter++;

		ArrayList<LinkedHashMap<String, String>> activities = (ArrayList<LinkedHashMap<String, String>>) input
				.getAttributesManager().getSessionAttributes().get(Attributes.LIST_KEY);
		LinkedHashMap<String, String> activity = RandomPicker.get(activities);
		activities.remove(activity);

		sessionAttributes.put(Attributes.ACTIVITY_KEY, activity);
		sessionAttributes.put(Attributes.LIST_KEY, activities);
		sessionAttributes.put(Attributes.REPEAT_KEY, Phrases.INFO_REPROMT);
		sessionAttributes.put(Attributes.COUNTER_KEY, counter);

		String speechText = String.format(RandomPicker.get(Phrases.NEXT_SUGGESTION), activity.get("name"));

		if (counter == Settings.MAX_SUGGESTIONS) {
			sessionAttributes.put(Attributes.STATE_KEY, Attributes.NEW_CATEGORIE_STATE);
		} else {
			sessionAttributes.put(Attributes.STATE_KEY, Attributes.INFO_STATE);
		}

		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();

	}

}
