package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.SlotConfirmationStatus;
import com.amazon.ask.model.slu.entityresolution.Resolution;
import com.amazon.ask.model.slu.entityresolution.Resolutions;

import muctivities.model.Wetterdienst;
import muctivities.phrasesAndConstants.Phrases;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;


public class GetActivitysIntent implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("GetActivitysIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		
		
		
		Request request = input.getRequestEnvelope().getRequest();
		IntentRequest intentRequest = (IntentRequest) request;
		Intent intent = intentRequest.getIntent();
	//	if (intentRequest.getDialogState().getValue().equals(DialogState.STARTED)){
		//	input.getAttributesManager().setSessionAttributes(Collections.singletonMap("weather", true));
	//	}

		
		Map<String, Slot> slots = intent.getSlots();
		String location = slots.get("location").getValue();
		String duration = slots.get("duration").getValue();
		String category = slots.get("category").getValue();

		Boolean durationBool = slots.get("duration").toString().contains("true");
		Boolean locationBool = slots.get("location").toString().contains("true");
		// More "precise" method then above: List authority =
		// slots.get("location").getResolutions().getResolutionsPerAuthority();

		boolean isEndOfDialog = intentRequest.getDialogState() == DialogState.COMPLETED;
		if (isEndOfDialog) {
			String output = "Lokalität: " + locationBool.toString() + ". Dauer: " + durationBool.toString()
					+ ". Kategorie: " + category + ".";
			return input.getResponseBuilder().withSpeech(output).build();
		}

		return input.getResponseBuilder().withShouldEndSession(false).addDelegateDirective(null).build();
	}

}
