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

public class IndoorOutdoorIntentHandler implements RequestHandler {

	public static final String LOCALITAET_SLOT = "lokalitaet";

	@Override
	public boolean canHandle(HandlerInput input) {

		// return input.matches(intentName("IndoorOutdoorIntent")
		// .and(sessionAttribute(Attributes.STATE_KEY, Attributes.Location_State)));
		return input.matches(sessionAttribute(Attributes.STATE_KEY, Attributes.Location_State));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		// Get the color slot from the list of slots.
		Slot favoriteColorSlot = slots.get(LOCALITAET_SLOT);

		String speechText, repromptText;
		boolean isAskResponse = false;
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		// Check for favorite color and create output to user.
		// if (favoriteColorSlot != null) {
		if (favoriteColorSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
			// Store the user's favorite color in the Session and create response.
			String favoriteColor = favoriteColorSlot.getValue();
		Boolean locationBool = slots.get(LOCALITAET_SLOT).toString().contains("true");

			// input.getAttributesManager().setSessionAttributes(Collections.singletonMap(Attributes.LOCALITAET_KEY,
			// favoriteColor));
			sessionAttributes.put(Attributes.STATE_KEY, Attributes.Duration_State);
			sessionAttributes.put(Attributes.LOCALITAET_KEY, locationBool);
	//		sessionAttributes.put(Attributes.LOCALITAET_KEY, favoriteColor);

			//			sessionAttributes.put(Attributes.STATE_KEY, Attributes.Location_State);

			speechText = Phrases.DAUER_FRAGE;
			// String.format("Deine Lieblingsfarbe ist %s. Du kannst mich jetzt nach Deiner
			// Lieblingsfarbe fragen. "
			// + "Frage einfach: was ist meine Lieblingsfarbe?", favoriteColor);
			repromptText = Phrases.DAUER_FRAGE;
			// "Frage nach meiner Lieblingsfarbe.";

		} else {
			// Render an error since we don't know what the users favorite color is.
			// speechText = "Ich kenne Deine Lieblingsfarbe nicht. Bitte versuche es noch
			// einmal.";
			sessionAttributes.put(Attributes.STATE_KEY, Attributes.Location_State);
			speechText = "Draußen oder Drinnen? Bitte versuche es noch einmal.";
			repromptText = "Draußen oder Drinnen? Bitte versuche es noch einmal.";
			// "Ich weiss nicht welches Deine Lieblingsfarbe ist. Sag mir Deine
			// Lieblingsfarbe. Sage zum Beispiel: ich mag blau.";
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
