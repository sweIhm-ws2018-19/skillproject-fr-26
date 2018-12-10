package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.response.ResponseBuilder;

import muctivities.constants.*;
import muctivities.model.*;

public class CategorieHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {

		return input.matches(
				intentName("AttributesIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.CATEGORIE_STATE)));

	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();
		Slot kategorieSlot = slots.get(Attributes.CATEGORIE_SLOT);

		String category = slots.get(Attributes.CATEGORIE_SLOT).getValue();
		boolean durationBool = (boolean) input.getAttributesManager().getSessionAttributes()
				.get(Attributes.DURATION_KEY);

		boolean locationBool = (boolean) input.getAttributesManager().getSessionAttributes()
				.get(Attributes.LOCATION_KEY);
		String speechText;
		String repromptText;

		if (kategorieSlot != null && kategorieSlot.getResolutions() != null
				&& kategorieSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {

			try {
				List<Activity> liste = muctivities.model.Database.suggestionOfActivities(locationBool, durationBool,
						category);
				Activity activitie = RandomPicker.get(liste);
				liste.remove(activitie);
				Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
				sessionAttributes.put(Attributes.ACTIVITY_KEY, activitie);
				sessionAttributes.put(Attributes.STATE_KEY, Attributes.INFO_STATE);
				sessionAttributes.put(Attributes.LIST_KEY, liste);
				sessionAttributes.put(Attributes.REPEAT_KEY, Phrases.DURATION_REPROMT);
				sessionAttributes.put(Attributes.COUNTER_KEY, 1);

				speechText = activitie.getName() + "Passt die Aktivität?";
				sessionAttributes.put(Attributes.REPEAT_KEY, Phrases.INFO_REPROMT);
			} catch (Exception e) {
				speechText = "Ein Fehler ist passiert";
			}
			repromptText = speechText;

		} else {
			speechText =Phrases.CATEGORIE_REPROMT;
			repromptText = speechText;
		}

		ResponseBuilder responseBuilder = input.getResponseBuilder();

		responseBuilder.withSpeech(speechText).withReprompt(repromptText)
				.withShouldEndSession(false);

		return responseBuilder.build();

	}

}
