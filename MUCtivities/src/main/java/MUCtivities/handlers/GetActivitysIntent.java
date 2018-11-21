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
//        List authority = slots.get("location").getResolutions().getResolutionsPerAuthority();
//        authority.length != 0 ?  
        
        Boolean durationBool = slots.get("duration").toString().contains("true") ? true : false;
        
        
        if (
                location != null && !location.isEmpty()
                && duration != null && !duration.isEmpty()
                && category != null && !category.isEmpty() 
        ) {
            String output = location + ". "  + durationBool.toString() + ". " + category + ".";
            return input.getResponseBuilder()
                    .withSpeech(output)
                    .build();
        }
	    

        // CHECK BUGFIX
//        return input.getResponseBuilder()
//                .withShouldEndSession(false)
//                .addDelegateDirective(null)
//                .build();
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
