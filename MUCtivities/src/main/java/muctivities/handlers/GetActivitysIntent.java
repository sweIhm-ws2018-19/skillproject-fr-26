package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.DialogState;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Request;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;

import muctivities.constants.Attributes;
import muctivities.model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

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

		Map<String, Slot> slots = intent.getSlots();
		String category = slots.get("category").getValue();

		Boolean durationBool = slots.get("duration").toString().contains("true");
		Boolean locationBool = slots.get("location").toString().contains("true");

		boolean isEndOfDialog = intentRequest.getDialogState() == DialogState.COMPLETED;
		if (isEndOfDialog) {
			String output = "";
			try {
				List<Activity> liste = muctivities.model.Database.suggestionOfActivities(locationBool, durationBool,
						category);
				output = RandomPicker.get(liste).getName();
			} catch (Exception e) {
				output = "Leider habe ich keine passende Aktivität gefunden";
			}

			return input.getResponseBuilder().withSpeech(output).build();
		}

		return input.getResponseBuilder().withShouldEndSession(false).addDelegateDirective(null).build();
	}

}
