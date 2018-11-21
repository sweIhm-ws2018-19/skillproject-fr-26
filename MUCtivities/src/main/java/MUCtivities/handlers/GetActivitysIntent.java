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
	    	    
        return input.getResponseBuilder()
                .withShouldEndSession(false)
                .addDelegateDirective(null)
                .build();

//        Request request = input.getRequestEnvelope().getRequest();
//        IntentRequest intentRequest = (IntentRequest) request;
//        Intent intent = intentRequest.getIntent();
//        
//        if (intentRequest.getDialogState() == DialogState.STARTED) {
//            return input.getResponseBuilder()
//                    .withShouldEndSession(false)
//                    .addDelegateDirective(null)
//                    .build();
//        }
//        
//        Map<String, Slot> slots = intent.getSlots();
//
//        Slot locationSlot = slots.get("location");
//        String location = slots.get("location").getValue();
//        String duration = slots.get("duration").getValue();
//        String category = slots.get("category").getValue();
//
//               
//        if (locationSlot.getResolutions().toString().contains("ER_SUCCESS_NO_MATCH") ) {
//            return input.getResponseBuilder()
//                    .withShouldEndSession(false)
//                    .withSpeech("Entschuldigung das hab ich nicht verstanden. Drinnen oder draußen.")
//                    .addElicitSlotDirective("location", null)
//                    .build();
//        } else if (!(duration = "")) { //TODO remove last condition
//            return input.getResponseBuilder()
//                    .withShouldEndSession(false)
//                    .withSpeech("Entschuldigung das hab ich nicht verstanden. Nur ein paar Stunden oder den ganzen Tag.")
//                    .addElicitSlotDirective("duration", null)
//                    .build();
//        } else if (category == null || category.isEmpty() || category.equals("Hallo2")) { //TODO remove last condition
//            return input.getResponseBuilder()
//                    .withShouldEndSession(false)
//                    .withSpeech("Entschuldigung das hab ich nicht verstanden. Spiel, Spaß oder Kultur.")
//                    .addElicitSlotDirective("category", null)
//                    .build();
//        }
//        

    }

}
