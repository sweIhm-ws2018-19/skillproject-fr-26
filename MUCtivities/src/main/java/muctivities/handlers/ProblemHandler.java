package muctivities.handlers;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.Phrases;

public class ProblemHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		return input.getResponseBuilder().withSpeech("Ein Problem ist aufgetreten. Problem Handler")
				.withShouldEndSession(false).build();
	}

}
