package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;

import muctivities.constants.Attributes;
import muctivities.constants.Phrases;
import muctivities.model.Activity;

public class InfoHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("AMAZON.YesIntent"))
				&& (input.matches(sessionAttribute(Attributes.STATE_KEY, Attributes.INFO_STATE))
						|| input.matches(sessionAttribute(Attributes.STATE_KEY, Attributes.SUGESTION2_STATE))|| input.matches(sessionAttribute(Attributes.STATE_KEY, Attributes.SUGESTION3_STATE)));

	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

		sessionAttributes.put(Attributes.STATE_KEY, Attributes.DESCRIPTION_STATE);

		String speechText = "Magst du mehr Infos bekommen?";
		String repromptText = speechText;
		ResponseBuilder responseBuilder = input.getResponseBuilder();

		responseBuilder.withSimpleCard("LocalitaetSession", speechText).withSpeech(speechText)
				.withReprompt(repromptText).withShouldEndSession(false);

		return responseBuilder.build();
	}

}
