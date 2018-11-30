package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import java.util.Collections;
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

public class KategorieIntentHandler implements RequestHandler {
	public static final String KATEGORIE_KEY = "KATEGORIE";
	public static final String KATEGORIE_SLOT = "kategorie";

	@Override
	public boolean canHandle(HandlerInput input) {
		// TODO Auto-generated method stub
	//	return input.matches(intentName("KategorieIntent"));
		return input.matches(sessionAttribute(Attributes.STATE_KEY, Attributes.Kategorie_State));

	
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		// TODO Auto-generated method stub
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
		Map<String, Slot> slots = intent.getSlots();

		// Get the color slot from the list of slots.
		Slot kategorieSlot = slots.get(KATEGORIE_SLOT);

		String category = slots.get(KATEGORIE_SLOT).getValue();
		boolean durationBool = (boolean) input.getAttributesManager().getSessionAttributes()
				.get(Attributes.DAUER_KEY);

	boolean locationBool = (boolean) input.getAttributesManager().getSessionAttributes()
		.get(Attributes.LOCALITAET_KEY);
		
		
		
		
		// String locationBool =
		// slots.get(IndoorOutdoorIntentHandler.LOCALITAET_SLOT).toString().contains("true");

		String speechText, repromptText;
		boolean isAskResponse = false;

		// Check for favorite color and create output to user.
		// if (favoriteColorSlot != null) {
		if (kategorieSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {

			// Store the user's favorite color in the Session and create response.
		//	String favoriteColor = kategorieSlot.getValue();
		//	input.getAttributesManager().setSessionAttributes(Collections.singletonMap(KATEGORIE_KEY, favoriteColor));
			try {
				List<Activity> liste = muctivities.model.Database.suggestionOfActivities(locationBool, durationBool,
						category);
			Activity activitie=	RandomPicker.get(liste);
			Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
			sessionAttributes.put(Attributes.AKTIVITIE_KEY, activitie);
			speechText=activitie.getName();
			} catch (Exception e) {
				speechText="Ein Fehler ist passiert";
			}
			//speechText = "Lokalität: " + locationBool+". Dauer: " + durationBool
				//	+ ". Kategorie: " + category + ".";
			//speechText= category;
			// speechText = String
			// .format("Deine Lieblingsfarbe ist %s. Du kannst mich jetzt nach Deiner
			// Lieblingsfarbe fragen. "
			// + "Frage einfach: was ist meine Lieblingsfarbe?", favoriteColor);
			// repromptText = "Frage nach meiner Lieblingsfarbe.";

		} else {
			// Render an error since we don't know what the users favorite color is.
			// speechText = "Ich kenne Deine Lieblingsfarbe nicht. Bitte versuche es noch
			// einmal.";
			speechText = "Ich kenne deine Kategorie nicht. Bitte versucht es erneut.";

			// repromptText = "Ich weiss nicht welches Deine Lieblingsfarbe ist. Sag mir
			// Deine Lieblingsfarbe. Sage zum Beispiel: ich mag blau.";
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
		/*
		 * String speechText; String favoriteColor = (String)
		 * input.getAttributesManager().getSessionAttributes().get(COLOR_KEY);
		 * 
		 * if (favoriteColor != null && !favoriteColor.isEmpty()) { speechText =
		 * String.format("Deine Lieblingsfarbe ist %s. Auf Wiedersehen.",
		 * favoriteColor); } else { // Since the user's favorite color is not set render
		 * an error message. speechText =
		 * "Ich weiss nicht welches Deine Lieblingsfarbe ist. Sag mir Deine Lieblingsfarbe. Sage zum Beispiel: ich mag rot."
		 * ; }
		 * 
		 * return input.getResponseBuilder().withSpeech(speechText).withSimpleCard(
		 * "ColorSession", speechText).build();
		 */
	}

}
