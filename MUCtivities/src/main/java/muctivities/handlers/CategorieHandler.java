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
<<<<<<< HEAD
		return input.matches(intentName("AttributesIntent")
=======
		// TODO Auto-generated method stub
		// return input.matches(intentName("KategorieIntent"));
		return input.matches(intentName("MUCtivitiesIntent")
>>>>>>> 13f8b9eea3c8665541bdf8205348c9c8463639fc
				.and(sessionAttribute(Attributes.STATE_KEY, Attributes.Categorie_State)));

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
		String speechText, repromptText;
		boolean isAskResponse = false;

		if (kategorieSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {

			try {
				List<Activity> liste = muctivities.model.Database.suggestionOfActivities(locationBool, durationBool,
						category);
				Activity activitie = RandomPicker.get(liste);
				Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
				sessionAttributes.put(Attributes.ACTIVITY_KEY, activitie);
				speechText = activitie.getName();
			} catch (Exception e) {
				speechText = "Ein Fehler ist passiert";
			}

		} else {
			speechText = "Ich kenne deine Kategorie nicht. Bitte versucht es erneut.";

			isAskResponse = true;

		}

		ResponseBuilder responseBuilder = input.getResponseBuilder();

		responseBuilder.withSimpleCard("KategorieSession", speechText).withSpeech(speechText)
				.withShouldEndSession(false);

		if (isAskResponse) {
			repromptText = "Ich kenne deine Kategorie nicht. Bitte versucht es erneut.";
			responseBuilder.withShouldEndSession(false).withReprompt(repromptText);
		}

		return responseBuilder.build();

	}

}
