package muctivities.handlers;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.Attributes;

public class ProblemHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return true;
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {

		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		String speechText = sessionAttributes.containsKey(Attributes.REPEAT_KEY)
				? (String) sessionAttributes.get(Attributes.REPEAT_KEY)
				: "Ein Problem ist aufgetreten. Problem Handler";
		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();
	}

}
