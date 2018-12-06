package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;

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
				intentName("AttributesIntent").and(sessionAttribute(Attributes.STATE_KEY, Attributes.LOCATION_STATE)));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		Slot locationSlot = slots.get(Attributes.LOCATION_SLOT);

		String speechText;
		String repromptText;

		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		if (locationSlot != null && locationSlot.getResolutions() != null
				&& locationSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
			Boolean locationBool = slots.get(Attributes.LOCATION_SLOT).toString().contains("true");

			sessionAttributes.put(Attributes.STATE_KEY, Attributes.DURATION_STATE);
			sessionAttributes.put(Attributes.LOCATION_KEY, locationBool);
			speechText = Phrases.DURATION_QUESTION;
			repromptText = Phrases.DURATION_QUESTION;

		} else {
			sessionAttributes.put(Attributes.STATE_KEY, Attributes.LOCATION_STATE);
			speechText = "Draußen oder Drinnen? Bitte versuche es noch einmal.";
			repromptText = "Draußen oder Drinnen? Bitte versuche es noch einmal.";

		}

		ResponseBuilder responseBuilder = input.getResponseBuilder();

		responseBuilder.withSimpleCard("LocalitaetSession", speechText).withSpeech(speechText)
				.withReprompt(repromptText).withShouldEndSession(false);

		return responseBuilder.build();
	}

}
