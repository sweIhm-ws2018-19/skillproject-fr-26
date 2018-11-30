package muctivities.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.Phrases;
import muctivities.model.Wetterdienst;

public class TippDesTagesHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("TippDesTages"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		String speechText;
		try {
			speechText = "Der Tipp des Tages ist" + muctivities.model.Database.randomActivity().getName();
			return input.getResponseBuilder().withSpeech(speechText)
					.withSimpleCard(Phrases.MUCtivities_Name, speechText).build();
		} catch (Exception e) {
			speechText = "Fehler. Tipp des Tages";
		}
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard(Phrases.MUCtivities_Name, speechText)
				.build();

	}

}
