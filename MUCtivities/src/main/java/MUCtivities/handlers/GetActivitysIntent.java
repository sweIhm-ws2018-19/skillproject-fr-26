package main.java.MUCtivities.handlers;

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

import main.java.MUCtivities.attribute.Constants;
import main.java.MUCtivities.eigeneKlassen.Wetterdienst;

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
        
        Map<String, Slot> slots = intent.getSlots();
        String location = slots.get("location").getValue();
        String duration = slots.get("duration").getValue();
        String category = slots.get("category").getValue();
        
        Boolean durationBool = slots.get("duration").toString().contains("true") ? true : false;
        // More "precise" method then above: List authority = slots.get("location").getResolutions().getResolutionsPerAuthority();
             
        boolean isEndOfDialog = intentRequest.getDialogState() == DialogState.COMPLETED;
        if (isEndOfDialog) {
            String output = location + ". "  + durationBool.toString() + ". " + category + ".";
            return input.getResponseBuilder()
                    .withSpeech(output)
                    .build();
        }
	    
        return input.getResponseBuilder()
                .withShouldEndSession(false)
                .addDelegateDirective(null)
                .build();
    }

}
