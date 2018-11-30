package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import java.util.Collections;
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

public class DurationHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(
				intentName("MUCtivitiesIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.Duration_State)));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();
		Slot durationSlot = slots.get(Attributes.DURATION_SLOT);

		String speechText, repromptText;
		boolean isAskResponse = false;
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

		if (durationSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
			boolean durationBool = slots.get(Attributes.DURATION_SLOT).toString().contains("true");
			boolean location = (boolean) sessionAttributes.get(Attributes.LOCATION_KEY);
			sessionAttributes.put(Attributes.STATE_KEY, Attributes.Categorie_State);
			sessionAttributes.put(Attributes.LOCATION_KEY, location);
			sessionAttributes.put(Attributes.DURATION_KEY, durationBool);
			speechText = Phrases.CATEGORIE_FRAGE;
			repromptText = Phrases.CATEGORIE_FRAGE;
		} else {
			speechText = "Ganzer Tag oder paar Stunden? Ich habe dich nicht verstanden, bitte versuche es erneut";
			repromptText = "Ganzer Tag oder paar Stunden? Ich habe dich nicht verstanden, bitte versuche es erneut";
			isAskResponse = true;
		}

		ResponseBuilder responseBuilder = input.getResponseBuilder();

		responseBuilder.withSimpleCard("DauerSession", speechText).withSpeech(speechText).withShouldEndSession(false);

		if (isAskResponse) {
			responseBuilder.withShouldEndSession(false).withReprompt(repromptText);
		}

		return responseBuilder.build();
	}

}
