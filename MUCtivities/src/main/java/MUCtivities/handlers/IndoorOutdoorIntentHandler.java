package main.java.MUCtivities.handlers;

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

import main.java.MUCtivities.attribute.Constants;

public class IndoorOutdoorIntentHandler implements RequestHandler {
    public static final String LOCALITAET_KEY = "LOCALITAET";
    public static final String LOCALITAET_SLOT = "lokalitaet";
	@Override
	public boolean canHandle(HandlerInput input) {
		
		 return input.matches(intentName("IndoorOutdoorIntent"));

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

	        // Check for favorite color and create output to user.
	      //  if (favoriteColorSlot != null) {
	        	if(favoriteColorSlot.getResolutions().toString().contains("ER_SUCCESS_MATCH")) {
	            // Store the user's favorite color in the Session and create response.
	            String favoriteColor = favoriteColorSlot.getValue();
	            input.getAttributesManager().setSessionAttributes(Collections.singletonMap(LOCALITAET_KEY, favoriteColor));

	            speechText =Constants.DAUER_FRAGE;
	                  //  String.format("Deine Lieblingsfarbe ist %s. Du kannst mich jetzt nach Deiner Lieblingsfarbe fragen. "
	                    //        + "Frage einfach: was ist meine Lieblingsfarbe?", favoriteColor);
	            repromptText =Constants.DAUER_FRAGE;
	              //      "Frage nach meiner Lieblingsfarbe.";

	        } else {
	            // Render an error since we don't know what the users favorite color is.
	          //  speechText = "Ich kenne Deine Lieblingsfarbe nicht. Bitte versuche es noch einmal.";
	            speechText="Drauﬂen oder Drinnen? Bitte versuche es noch einmal.";
	        	repromptText="Drauﬂen oder Drinnen? Bitte versuche es noch einmal.";
	              //      "Ich weiss nicht welches Deine Lieblingsfarbe ist. Sag mir Deine Lieblingsfarbe. Sage zum Beispiel: ich mag blau.";
	            isAskResponse = true;
	        }

	        ResponseBuilder responseBuilder = input.getResponseBuilder();

	        responseBuilder.withSimpleCard("LocalitaetSession", speechText)
	                .withSpeech(speechText)
	                .withShouldEndSession(false);

	        if (isAskResponse) {
	            responseBuilder.withShouldEndSession(false)
	                    .withReprompt(repromptText);
	        }

	        return responseBuilder.build();
	}

}
