package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;

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
import static com.amazon.ask.request.Predicates.sessionAttribute;

import muctivities.constants.*;

public class LocationHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(
<<<<<<< HEAD
				intentName("AttributesIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.Location_State)));
=======
				intentName("MUCtivitiesIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.Location_State)));
>>>>>>> 13f8b9eea3c8665541bdf8205348c9c8463639fc
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot locationSlot = slots.get(Attributes.LOCATION_SLOT);

		String speechText, repromptText;
		boolean isAskResponse = false;
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		if (locationSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
			Boolean locationBool = slots.get(Attributes.LOCATION_SLOT).toString().contains("true");

			sessionAttributes.put(Attributes.STATE_KEY, Attributes.Duration_State);
			sessionAttributes.put(Attributes.LOCATION_KEY, locationBool);
			speechText = Phrases.DURATION_QUESTION;
			repromptText = Phrases.DURATION_QUESTION;

		} else {
			sessionAttributes.put(Attributes.STATE_KEY, Attributes.Location_State);
			speechText = "Draußen oder Drinnen? Bitte versuche es noch einmal.";
			repromptText = "Draußen oder Drinnen? Bitte versuche es noch einmal.";
			isAskResponse = true;
		}

		ResponseBuilder responseBuilder = input.getResponseBuilder();

		responseBuilder.withSimpleCard("LocalitaetSession", speechText).withSpeech(speechText)
				.withShouldEndSession(false);

		if (isAskResponse) {
			responseBuilder.withShouldEndSession(false).withReprompt(repromptText);
		}

		return responseBuilder.build();
	}

}
