package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.model.Wetterdienst;
import muctivities.phrasesAndConstants.Phrases;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class MUCtivitiesIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("MUCtivitiesIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		// String speechText = "Hallo Welt";
		// wetter muss noch angepasst werden.
	//	String speechText = Wetterdienst.wetterVorhersage() ? Constants.MUCtivitie_SONNIG : Constants.MUCtivitie_REGEN;
		String speechText ="test";
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard(Phrases.MUCtivities_Name, speechText)
				.build();
	}

}
